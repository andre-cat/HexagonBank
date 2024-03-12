package co.com.hexagonbank.api;

import co.com.hexagonbank.api.data.CreateAccountInfo;
import co.com.hexagonbank.model.account.Account;
import co.com.hexagonbank.model.account.exceptions.AccountNotFoundException;
import co.com.hexagonbank.model.user.exceptions.UserNotFoundException;
import co.com.hexagonbank.model.user.exceptions.UserWithAccountException;
import co.com.hexagonbank.usecase.accountservice.createaccount.CreateAccountUseCase;
import co.com.hexagonbank.usecase.accountservice.seeaccount.SeeAccountUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/v1")
public class AccountRest {

    private final SeeAccountUseCase seeAccountUseCase;
    private final CreateAccountUseCase createAccountUseCase;

    @GetMapping("/account")
    public ResponseEntity<Object> seeAccount(@RequestParam("id") long id) {
        try {
            Account account = seeAccountUseCase.see(id);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .header("Content-Type", "application/json")
                    .body(account);
        } catch (AccountNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

    @PostMapping("/account")
    public ResponseEntity<Object> createAccount(@RequestBody CreateAccountInfo createAccountInfo) {
        try {
            Account account = createAccountInfo.toAccount();
            account = createAccountUseCase.create(account);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .header("Content-Type", "application/json")
                    .body("Account created:\n"
                            .concat("id: " + account.getId() + "\n")
                            .concat("balance: " + account.getBalance() + "\n")
                            .concat("user id: " + account.getUserId()));
        } catch (UserNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        } catch (UserWithAccountException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }
}
