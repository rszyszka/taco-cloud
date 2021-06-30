package pl.rszyszka.tacocloud.data;

import org.springframework.data.repository.CrudRepository;
import pl.rszyszka.tacocloud.User;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
