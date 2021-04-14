package co.com.sofka.cargame.service;

import co.com.sofka.cargame.dto.gameconfig.DriverConfigDTO;
import co.com.sofka.cargame.dto.gameconfig.TrackDTO;
import co.com.sofka.cargame.entity.Car;
import co.com.sofka.cargame.entity.Driver;
import co.com.sofka.cargame.entity.Lane;
import co.com.sofka.cargame.entity.Track;
import co.com.sofka.cargame.mapper.gameconfig.DriverConfigMapper;
import co.com.sofka.cargame.mapper.gameconfig.TrackMapper;
import co.com.sofka.cargame.repository.CarRepository;
import co.com.sofka.cargame.repository.DriverRepository;
import co.com.sofka.cargame.repository.LaneRepository;
import co.com.sofka.cargame.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
