package pl.rszyszka.tacocloud.data;

import org.springframework.data.repository.CrudRepository;
import pl.rszyszka.tacocloud.Taco;

public interface TacoRepository extends CrudRepository<Taco, Long> {
}
