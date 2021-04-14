package co.com.sofka.cargame.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "player")
public class Player{

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "last_podium")
    private Long lastPodium;

    @Column(name = "times_won")
    private Long timesWon;

    @OneToOne
    @JoinColumn(name = "driver_id", referencedColumnName = "id")
    private Driver driver;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }
}
