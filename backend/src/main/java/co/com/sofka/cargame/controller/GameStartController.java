package co.com.sofka.cargame.controller;

import co.com.sofka.cargame.dto.gameconfig.DriverConfigDTO;
import co.com.sofka.cargame.dto.gamestart.DriversInGameDTO;
import co.com.sofka.cargame.service.GameStartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/game")
@CrossOrigin(origins = "http://localhost:3000")
public class GameStartController {

    @Autowired
    GameStartService gameStartService;

    @PostMapping("/start")
    public DriversInGameDTO startGame(@RequestBody DriversInGameDTO driversInGame){
        return gameStartService.startGame(driversInGame);
    }
}
