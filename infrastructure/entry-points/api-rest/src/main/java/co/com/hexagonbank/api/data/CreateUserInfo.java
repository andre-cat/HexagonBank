package co.com.hexagonbank.api.data;

import co.com.hexagonbank.model.user.User;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public record CreateUserInfo(
        @JsonProperty("id") long id,
        @JsonProperty("username") String username,
        @JsonProperty("password") String password,
        @JsonProperty("name") String name,
        @JsonProperty("lastName") String lastName,
        @JsonProperty("phone") long phone,
        @JsonProperty("email") String email,
        @JsonProperty("accountId") long accountId
) implements Serializable {

    public User toUser() {
        return new User(id, username, password, name, lastName, phone, email);
    }
}
