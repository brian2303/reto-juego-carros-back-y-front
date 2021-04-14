package co.com.sofka.cargame.dto.gameconfig;

import java.util.List;

public class GameDTO {

    private Long gameId;
    private String gameName;
    private TrackDTO track;
    private List<DriverConfigDTO> drivers;

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public TrackDTO getTrack() {
        return track;
    }

    public void setTrack(TrackDTO track) {
        this.track = track;
    }

    public List<DriverConfigDTO> getDrivers() {
        return drivers;
    }

    public void setDrivers(List<DriverConfigDTO> drivers) {
        this.drivers = drivers;
    }
}
