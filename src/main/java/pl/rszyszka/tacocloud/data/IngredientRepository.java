package pl.rszyszka.tacocloud.data;

import org.springframework.data.repository.CrudRepository;
import pl.rszyszka.tacocloud.Ingredient;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {
}
