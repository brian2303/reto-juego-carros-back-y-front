package co.com.sofka.cargame.dto.gamestart;

import co.com.sofka.cargame.dto.gameconfig.DriverConfigDTO;

import java.util.List;

public class DriversInGameDTO {

    private List<DriverConfigDTO> driversInGame;
    private Boolean isFinished;

    public List<DriverConfigDTO> getDriversInGame() {
        return driversInGame;
    }

    public void setDriversInGame(List<DriverConfigDTO> driversInGame) {
        this.driversInGame = driversInGame;
    }

    public Boolean getFinished() {
        return isFinished;
    }

    public void setFinished(Boolean finished) {
        isFinished = finished;
    }
}
