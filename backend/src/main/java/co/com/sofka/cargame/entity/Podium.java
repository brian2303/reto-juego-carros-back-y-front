package co.com.sofka.cargame.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "podium")
public class Podium {

    @Id
    private String name;

    private Integer position;

    @Column(name = "won_times")
    private Integer wonTimes;


    public Podium(String name, Integer position, Integer wonTimes) {
        this.name = name;
        this.position = position;
        this.wonTimes = wonTimes;
    }

    public Podium() {
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Integer getWonTimes() {
        return wonTimes;
    }

    public void setWonTimes(Integer wonTimes) {
        this.wonTimes = wonTimes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
