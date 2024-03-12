package co.com.hexagonbank.model.account;

public class Account {

    private long id;
    private double balance;
    private long userId;

    public Account(long id, double balance, long userId) {
        this.id = id;
        this.balance = balance;
        this.userId = userId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
