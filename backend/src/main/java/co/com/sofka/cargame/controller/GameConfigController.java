package co.com.sofka.cargame.controller;

import co.com.sofka.cargame.dto.TrackDTO;
import co.com.sofka.cargame.entity.Track;
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

    @PostMapping
    public ResponseEntity<TrackDTO> saveTrack(@RequestBody TrackDTO trackDTO){
        return new ResponseEntity(gameConfigService.saveTrack(trackDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TrackDTO>> getTracks(){
        return new ResponseEntity(gameConfigService.findAll(),HttpStatus.OK);
    }

}
