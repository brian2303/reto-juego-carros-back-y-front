package co.com.sofka.cargame.repository;

import co.com.sofka.cargame.entity.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car,Long> {
}
