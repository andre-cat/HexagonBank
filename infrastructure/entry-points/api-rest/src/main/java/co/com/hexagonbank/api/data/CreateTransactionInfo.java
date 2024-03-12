package co.com.hexagonbank.api.data;

import co.com.hexagonbank.model.transaction.Transaction;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;


public record CreateTransactionInfo(
        @JsonProperty("value") double value,
        @JsonProperty("description") String description,
        @JsonProperty("accountId") long accountId
) implements Serializable {

    public Transaction toTransaction() {
        return new Transaction(0, value, 0, null, description, null, null, accountId);
    }
}
