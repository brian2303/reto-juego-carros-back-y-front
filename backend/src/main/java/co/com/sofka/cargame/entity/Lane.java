package co.com.sofka.cargame.entity;


import javax.persistence.*;

@Entity
@Table(name = "lane")
public class Lane {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "number_lane")
    private Integer numberLane;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumberLane() {
        return numberLane;
    }

    public void setNumberLane(Integer numberLane) {
        this.numberLane = numberLane;
    }
}
