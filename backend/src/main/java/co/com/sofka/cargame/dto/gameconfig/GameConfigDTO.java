package co.com.sofka.cargame.dto.gameconfig;

import java.util.List;

public class GameConfigDTO {

    private String gameName;
    private Long trackId;
    private Integer quantityPlayers;
    private List<Long> drivers;

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public Long getTrackId() {
        return trackId;
    }

    public void setTrackId(Long trackId) {
        this.trackId = trackId;
    }

    public Integer getQuantityPlayers() {
        return quantityPlayers;
    }

    public void setQuantityPlayers(Integer quantityPlayers) {
        this.quantityPlayers = quantityPlayers;
    }

    public List<Long> getDrivers() {
        return drivers;
    }

    public void setDrivers(List<Long> drivers) {
        this.drivers = drivers;
    }
}
