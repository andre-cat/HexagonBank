package co.com.hexagonbank.api.data;

import co.com.hexagonbank.model.account.Account;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public record CreateAccountInfo(
        @JsonProperty("balance") double balance,
        @JsonProperty("userId") long userId
) implements Serializable {

    public Account toAccount() {
        return new Account(0, balance, userId);
    }
}
