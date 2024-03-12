package co.com.hexagonbank.model.user.exceptions;

public class UserWithAccountException extends RuntimeException {
    public UserWithAccountException() {
        super("User already has an account");
    }
}
