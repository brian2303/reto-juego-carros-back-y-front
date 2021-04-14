package co.com.sofka.cargame.mapper.gameconfig;

import co.com.sofka.cargame.dto.gameconfig.GameDTO;
import co.com.sofka.cargame.entity.Game;

import java.util.ArrayList;
import java.util.List;

public class GameConfigMapper {

    public static GameDTO toGameDTO(Game game){
        GameDTO gameDTO = new GameDTO();
        gameDTO.setGameId(game.getId());
        gameDTO.setGameName(game.getName());
        gameDTO.setTrack(TrackMapper.toTrackDTO(game.getTrack()));
        gameDTO.setDrivers(DriverConfigMapper.toListDriverConfigDTO(game.getDrivers()));
        return gameDTO;
    }

    public static List<GameDTO> toListGameDTO(List<Game> games){
        List<GameDTO> gamesDTO = new ArrayList();
        for(Game game : games) {
            gamesDTO.add(GameConfigMapper.toGameDTO(game));
        }
        return gamesDTO;
    }
}
