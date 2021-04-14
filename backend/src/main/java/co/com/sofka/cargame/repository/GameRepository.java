package co.com.sofka.cargame.repository;

import co.com.sofka.cargame.entity.Game;
import org.springframework.data.repository.CrudRepository;

public interface GameRepository extends CrudRepository<Game,Long> {
}
