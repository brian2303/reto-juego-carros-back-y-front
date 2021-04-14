package co.com.sofka.cargame.mapper.gameconfig;

import co.com.sofka.cargame.dto.gameconfig.GameDTO;
import co.com.sofka.cargame.entity.Game;

public class GameConfigMapper {

    public static GameDTO toGameDTO(Game game){
        GameDTO gameDTO = new GameDTO();
        gameDTO.setGameId(game.getId());
        gameDTO.setGameName(game.getName());
        gameDTO.setTrack(TrackMapper.toTrackDTO(game.getTrack()));
        gameDTO.setDrivers(DriverConfigMapper.toListDriverConfigDTO(game.getDrivers()));
        return gameDTO;
    }
}
