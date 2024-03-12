package co.com.hexagonbank.mongo.data;

import co.com.hexagonbank.model.transaction.types.TransactionMean;
import co.com.hexagonbank.model.transaction.types.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Transactions")
public class TransactionEntity {

    @Field
    @Id
    private long id;

    @Field(name = "value")
    private double value;

    @Field(name = "cost")
    private double cost;

    @Field(name = "date")
    private Date date;

    @Field(name = "description")
    private String description;

    @Field(name = "type", targetType = FieldType.STRING)
    private TransactionType type;

    @Field(name = "mean")
    private TransactionMean mean;

    @Field(name = "account_id")
    private long accountId;
}
