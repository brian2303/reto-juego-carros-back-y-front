package co.com.sofka.cargame.controller;

import co.com.sofka.cargame.dto.gameconfig.DriverConfigDTO;
import co.com.sofka.cargame.dto.gameconfig.GameConfigDTO;
import co.com.sofka.cargame.dto.gameconfig.GameDTO;
import co.com.sofka.cargame.dto.gameconfig.TrackDTO;
import co.com.sofka.cargame.service.GameConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/config")
@CrossOrigin(origins = "http://localhost:3000")
public class GameConfigController {

    @Autowired
    GameConfigService gameConfigService;

    @PostMapping("/new/track")
    public ResponseEntity<TrackDTO> saveTrack(@RequestBody TrackDTO trackDTO){
        return new ResponseEntity(gameConfigService.saveTrack(trackDTO), HttpStatus.CREATED);
    }

    @PostMapping("/new/game")
    public ResponseEntity<GameDTO> saveGame(@RequestBody GameConfigDTO gameConfigDTO){
        return new ResponseEntity(gameConfigService.saveGame(gameConfigDTO),HttpStatus.CREATED);
    }

    @GetMapping("/tracks")
    public ResponseEntity<List<TrackDTO>> getTracks(){
        return new ResponseEntity(gameConfigService.findAllTracks(),HttpStatus.OK);
    }

    @PostMapping("/new/driver")
    public ResponseEntity<DriverConfigDTO> saveDriver(@RequestBody DriverConfigDTO driverConfigDTO){
        return new ResponseEntity(gameConfigService.saveDriver(driverConfigDTO),HttpStatus.CREATED);
    }

    @GetMapping("/drivers")
    public ResponseEntity<List<DriverConfigDTO>> findAll(){
        return new ResponseEntity(gameConfigService.findAllDrivers(),HttpStatus.OK);
    }

}
