package pl.rszyszka.tacocloud.security;

import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.rszyszka.tacocloud.User;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class RegistrationForm {
    @NotNull(message = "{register.username.notnull}")
    @Size(min = 4, message = "{register.username.size}")
    private final String username;

    private final String password;
    private final String confirm;
    private final String fullName;
    private final String street;
    private final String city;
    private final String zip;
    private final String phoneNumber;

    public User toUser(PasswordEncoder encoder) {
        return new User(username, encoder.encode(password), fullName, street, city, zip, phoneNumber);
    }
}
