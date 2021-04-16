package co.com.sofka.cargame.service;

import co.com.sofka.cargame.dto.gameconfig.DriverConfigDTO;
import co.com.sofka.cargame.dto.gamestart.DriversInGameDTO;
import co.com.sofka.cargame.entity.Driver;
import co.com.sofka.cargame.mapper.gameconfig.DriverConfigMapper;
import co.com.sofka.cargame.mapper.gameconfig.GameConfigMapper;
import co.com.sofka.cargame.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GameStartService {

    @Autowired
    private DriverRepository driverRepository;

    public DriversInGameDTO startGame(DriversInGameDTO game){
        List<Driver> winners = new ArrayList();

        for (DriverConfigDTO driver: game.getDriversInGame()) {
            Driver driverShift = driverRepository.findById(driver.getId())
                    .orElseThrow(() -> new RuntimeException("Driver not found"));

            Integer score = driverShift.getCar().getScore();
            if (score == null) score = 0;

            driverShift.getCar().setScore(score  + GameStartService.rollDice());
            Driver driverWithScoreUpdated = driverRepository.save(driverShift);


            if (driverWithScoreUpdated.getCar().getScore() >= 2000){
                winners.add(driverWithScoreUpdated);
                if(winners.size() == 3){
                    DriversInGameDTO gameFinished = new DriversInGameDTO();
                    List<DriverConfigDTO> winnersConfigDTO  = winners.stream()
                            .map(DriverConfigMapper::toDriverConfigDTO)
                            .collect(Collectors.toList());
                    gameFinished.setDriversInGame(winnersConfigDTO);
                    gameFinished.setFinished(true);

                    game.getDriversInGame().stream().forEach(d -> {
                        Driver driverToUpdateScore = driverRepository.findById(d.getId()).get();
                        driverToUpdateScore.getCar().setScore(0);
                        driverRepository.save(driverToUpdateScore);
                    });

                    return gameFinished;
                }
            }

        }
        List<DriverConfigDTO> driverConfigDTOS = new ArrayList();
        game.getDriversInGame().stream().forEach(d ->{
            Driver driver = driverRepository.findById(d.getId()).get();
            DriverConfigDTO driverConfigDTO = DriverConfigMapper.toDriverConfigDTO(driver);
            driverConfigDTOS.add(driverConfigDTO);
        });
        game.getDriversInGame().clear();
        game.setDriversInGame(driverConfigDTOS);
        return game;
    }

    private static int rollDice(){
        return (int)(Math.random() * 6 + 1) * 100;
    }


    private Boolean carHasScore(DriverConfigDTO car){
        return car.getScore() != null;
    }

}
