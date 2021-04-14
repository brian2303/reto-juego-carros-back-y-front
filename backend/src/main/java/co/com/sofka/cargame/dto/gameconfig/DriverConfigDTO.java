package co.com.sofka.cargame.dto.gameconfig;

public class DriverConfigDTO {

    private Long id;
    private String name;
    private String brandCar;
    private String modelCar;
    private Integer numberLane;
    private Long lastPodium;
    private Long timesWon;

    public Long getLastPodium() {
        return lastPodium;
    }

    public void setLastPodium(Long lastPodium) {
        this.lastPodium = lastPodium;
    }

    public Long getTimesWon() {
        return timesWon;
    }

    public void setTimesWon(Long timesWon) {
        this.timesWon = timesWon;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrandCar() {
        return brandCar;
    }

    public void setBrandCar(String brandCar) {
        this.brandCar = brandCar;
    }

    public String getModelCar() {
        return modelCar;
    }

    public void setModelCar(String modelCar) {
        this.modelCar = modelCar;
    }

    public Integer getNumberLane() {
        return numberLane;
    }

    public void setNumberLane(Integer numberLane) {
        this.numberLane = numberLane;
    }
}
