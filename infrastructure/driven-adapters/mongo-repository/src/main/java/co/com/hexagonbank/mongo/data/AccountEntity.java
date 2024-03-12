package co.com.hexagonbank.mongo.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Accounts")
public class AccountEntity {

    @Id
    @Field("id")
    private long id;

    @Field(name = "balance")
    private double balance;

    @Field(name = "user_id")
    private long userId;
}
