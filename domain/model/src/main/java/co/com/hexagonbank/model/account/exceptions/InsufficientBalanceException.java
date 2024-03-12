package co.com.hexagonbank.model.account.exceptions;

public class InsufficientBalanceException extends RuntimeException {
    public InsufficientBalanceException() {
        super("Insufficient balance for the transaction");
    }
}
