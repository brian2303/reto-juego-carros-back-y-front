package co.com.sofka.cargame.entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "driver")
public class Driver {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Column(name = "last_podium")
    private Long lastPodium;

    @Column(name = "times_won")
    private Long timesWon;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "car_id",referencedColumnName = "id")
    private Car car;

    @ManyToMany(mappedBy = "drivers")
    private List<Game> games;

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

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
