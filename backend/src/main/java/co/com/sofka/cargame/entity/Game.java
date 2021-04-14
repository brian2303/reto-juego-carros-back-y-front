package co.com.sofka.cargame.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "game")
public class Game {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "track_id",referencedColumnName = "id")
    private Track track;

    @JoinTable(
            name = "rel_games_drivers",
            joinColumns = @JoinColumn(name = "fk_game", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "fk_driver", nullable = false)
    )
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Driver> drivers;

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

    public Track getTrack() {
        return track;
    }

    public void setTrack(Track track) {
        this.track = track;
    }

    public List<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(List<Driver> drivers) {
        this.drivers = drivers;
    }
}
