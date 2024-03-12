package co.com.hexagonbank.jpa.data;

import co.com.hexagonbank.model.transaction.types.TransactionMean;
import co.com.hexagonbank.model.transaction.types.TransactionType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@Table(name = "Transactions")
public class TransactionData {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Id
    private long id;

    @Column(name = "value")
    private double value;

    @Column(name = "cost")
    private double cost;

    @Column(name = "date")
    private Date date;

    @Column(name = "description")
    private String description;

    @Column(name = "type")
    private TransactionType type;

    @Column(name = "mean")
    private TransactionMean mean;

    @Column(name = "account_id")
    private long accountId;
}
