package co.com.sofka.cargame.dto.gameconfig;

public class TrackDTO {
    private Long id;
    private String name;
    private Integer kms;

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

    public Integer getKms() {
        return kms;
    }

    public void setKms(Integer kms) {
        this.kms = kms;
    }
}
