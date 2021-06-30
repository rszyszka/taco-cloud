package pl.rszyszka.tacocloud.data;

import org.springframework.data.repository.CrudRepository;
import pl.rszyszka.tacocloud.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
