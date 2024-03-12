package co.com.hexagonbank.model.transaction;

import co.com.hexagonbank.model.transaction.types.TransactionMean;
import co.com.hexagonbank.model.transaction.types.TransactionType;

import java.util.Date;

public class Transaction {

    private long id;
    private double value;
    private double cost;
    private Date date;
    private String description;
    private TransactionType type;
    private TransactionMean mean;
    private long accountId;

    public Transaction(long id, double value, double cost, Date date, String description, TransactionType type, TransactionMean mean, long accountId) {
        this.id = id;
        this.value = value;
        this.cost = cost;
        this.date = date;
        this.description = description;
        this.type = type;
        this.mean = mean;
        this.accountId = accountId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public TransactionMean getMean() {
        return mean;
    }

    public void setMean(TransactionMean mean) {
        this.mean = mean;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }
}
