package co.com.sofka.cargame.repository;

import co.com.sofka.cargame.entity.Player;
import org.springframework.data.repository.CrudRepository;

public interface PlayerRepository extends CrudRepository<Player,Long> {
}
