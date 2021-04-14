package co.com.sofka.cargame.service;

import co.com.sofka.cargame.dto.gameconfig.DriverConfigDTO;
import co.com.sofka.cargame.dto.gameconfig.GameConfigDTO;
import co.com.sofka.cargame.dto.gameconfig.GameDTO;
import co.com.sofka.cargame.dto.gameconfig.TrackDTO;
import co.com.sofka.cargame.entity.*;
import co.com.sofka.cargame.mapper.gameconfig.DriverConfigMapper;
import co.com.sofka.cargame.mapper.gameconfig.GameConfigMapper;
import co.com.sofka.cargame.mapper.gameconfig.TrackMapper;
import co.com.sofka.cargame.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameConfigService {

    @Autowired
    private TrackRepository trackRepository;

    @Autowired
    private LaneRepository laneRepository;

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private GameRepository gameRepository;


    public TrackDTO saveTrack(TrackDTO trackDTO){
        Track track = TrackMapper.toTrack(trackDTO);
        return TrackMapper.toTrackDTO(trackRepository.save(track));
    }

    public List<TrackDTO> findAllTracks() {
        List<Track> trackList = (List<Track>) trackRepository.findAll();
        return TrackMapper.toTrackDTOs(trackList);
    }

    public DriverConfigDTO saveDriver(DriverConfigDTO driverConfigDTO) {

        Lane lane = laneRepository.save(DriverConfigMapper.toLane(driverConfigDTO));
        Car car = DriverConfigMapper.toCar(driverConfigDTO);
        car.setLane(lane);
        carRepository.save(car);

        Driver driver = DriverConfigMapper.toDriver(driverConfigDTO);
        driver.setCar(car);
        driverRepository.save(driver);

        return DriverConfigMapper.toDriverConfigDTO(driver);
    }

    public List<DriverConfigDTO> findAllDrivers() {
        List<Driver> driverList = (List<Driver>) driverRepository.findAll();
        return DriverConfigMapper.toListDriverConfigDTO(driverList);
    }

    public GameDTO saveGame(GameConfigDTO gameConfigDTO) {

        Game game = new Game();
        game.setName(gameConfigDTO.getGameName());
        Track track = trackRepository.findById(gameConfigDTO.getTrackId())
                .orElseThrow(() -> new RuntimeException("Track not found"));
        List<Driver> driverList = findDriversById(gameConfigDTO.getDrivers());
        game.setTrack(track);
        game.setDrivers(driverList);
        return GameConfigMapper.toGameDTO(gameRepository.save(game));
    }

    private List<Driver> findDriversById(List<Long> driversListId){
        List<Driver> driverList = new ArrayList();
        for (Long idDriver: driversListId) {
            Driver driver = driverRepository.findById(idDriver)
                    .orElseThrow(()-> new RuntimeException("Error searching driver"));
            driverList.add(driver);
        }
        return driverList;
    }
}
