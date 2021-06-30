package pl.rszyszka.tacocloud;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Taco {
    @Id
    @GeneratedValue
    private Long id;
    private Date createdAt;
    @NotNull(message = "{taco.name.notnull}")
    @Size(min = 5, message = "{taco.name.notnull}")
    private String name;
    @NotNull(message = "{taco.ingredients.notnull}")
    @Size(min = 1, message = "{taco.ingredients.notnull}")
    @ManyToMany(targetEntity = Ingredient.class)
    private List<Ingredient> ingredients;

    @PrePersist
    void createdAt() {
        this.createdAt = new Date();
    }
}
