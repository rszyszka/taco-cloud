package pl.rszyszka.tacocloud;

import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Data
@Entity(name = "Taco_Order")
public class Order {
    @Id
    @GeneratedValue
    private Long id;
    private Date placedAt;
    @NotBlank(message = "{order.name.notBlank}")
    private String name;
    @NotBlank(message = "{order.street.notBlank}")
    private String street;
    @NotBlank(message = "{order.zip.notBlank}")
    private String zip;
    @NotBlank(message = "{order.city.notBlank}")
    private String city;
    @CreditCardNumber(message = "{order.ccNumber.valid}")
    private String ccNumber;
    @Pattern(regexp = "^(0[1-9]|1[0-2])([/])([1-9][0-9])$", message = "{order.ccExpiration.valid}")
    private String ccExpiration;
    @Digits(integer = 3, fraction = 0, message = "{order.ccCVV.valid}")
    private String ccCVV;
    @ManyToMany(targetEntity = Taco.class)
    private List<Taco> tacos = new LinkedList<>();

    public void addTaco(Taco taco) {
        tacos.add(taco);
    }

    @PrePersist
    void placedAt() {
        this.placedAt = new Date();
    }
}
