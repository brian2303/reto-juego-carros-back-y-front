package co.com.sofka.cargame.service;

import co.com.sofka.cargame.dto.gameconfig.DriverConfigDTO;
import co.com.sofka.cargame.dto.gamestart.DriversInGameDTO;
import co.com.sofka.cargame.entity.Driver;
import co.com.sofka.cargame.entity.Podium;
import co.com.sofka.cargame.mapper.gameconfig.DriverConfigMapper;
import co.com.sofka.cargame.mapper.gameconfig.GameConfigMapper;
import co.com.sofka.cargame.repository.DriverRepository;
import co.com.sofka.cargame.repository.PodiumRepository;
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

    @Autowired
    private PodiumRepository podiumRepository;

    public DriversInGameDTO startGame(DriversInGameDTO game){
        List<Driver> winners = new ArrayList();

        for (DriverConfigDTO driver: game.getDriversInGame()) {
            Driver driverShift = this.findDriverShift(driver.getId());
            Integer scorePrevious = driverShift.getCar().getScore();

            driverShift.getCar().setScore(GameStartService.rollDice(scorePrevious));
            Driver driverWithScoreUpdated = driverRepository.save(driverShift);

            Integer newScore = driverWithScoreUpdated.getCar().getScore();
            if (newScore >= convertTrackToMeters(game.getKmsTrack())){
                winners.add(driverWithScoreUpdated);
                if(winners.size() == 3){
                    savePodium(winners);
                    resetScores(game);
                    game.setFinished(true);
                    return game;
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

    private void savePodium(List<Driver> winners){

        winners.forEach((winner) -> {
            Podium podiumDriver = podiumRepository.findById(winner.getName())
                    .orElse(podiumRepository.save(new Podium(winner.getName(),0,0)));
            podiumDriver.setWonTimes(podiumDriver.getWonTimes() + 1);
            podiumRepository.save(podiumDriver);
        });
    }

    private void resetScores(DriversInGameDTO game){
        game.getDriversInGame().stream().forEach(d -> {
            Driver driverToUpdateScore = driverRepository.findById(d.getId()).get();
            driverToUpdateScore.getCar().setScore(0);
            driverRepository.save(driverToUpdateScore);
        });
    }

    private Driver findDriverShift(Long id){
        return driverRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Driver not found"));
    }

    private static Integer convertTrackToMeters(Integer kmsTrack){
        return kmsTrack * 1000;
    }

    private static int rollDice(Integer previousScore){
        return ((int)(Math.random() * 6 + 1) * 100) + previousScore;
    }

}
