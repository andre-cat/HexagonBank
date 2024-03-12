package co.com.hexagonbank.api;

import co.com.hexagonbank.api.data.CreateTransactionInfo;
import co.com.hexagonbank.model.account.exceptions.AccountNotFoundException;
import co.com.hexagonbank.model.account.exceptions.InsufficientBalanceException;
import co.com.hexagonbank.model.transaction.Transaction;
import co.com.hexagonbank.model.transaction.exceptions.TransactionNotFoundException;
import co.com.hexagonbank.usecase.transactionservice.createtransaction.implementation.depositfromaccount.DepositFromAccountUseCase;
import co.com.hexagonbank.usecase.transactionservice.createtransaction.implementation.depositfromatm.DepositFromATMUseCase;
import co.com.hexagonbank.usecase.transactionservice.createtransaction.implementation.depositfrombranch.DepositFromBranchUseCase;
import co.com.hexagonbank.usecase.transactionservice.createtransaction.implementation.purchaseinstorewithcard.PurchaseInStoreWithCardUseCase;
import co.com.hexagonbank.usecase.transactionservice.createtransaction.implementation.purchaseonlinewithcard.PurchaseOnlineWithCardUseCase;
import co.com.hexagonbank.usecase.transactionservice.createtransaction.implementation.withdrawwithatm.WithdrawFromATMUseCase;
import co.com.hexagonbank.usecase.transactionservice.seetransaction.SeeAllAccountTransactionsUseCase;
import co.com.hexagonbank.usecase.transactionservice.seetransaction.SeeTransactionUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/v1")
public class TransactionRest {

    private final SeeTransactionUseCase seeTransactionUseCase;
    private final SeeAllAccountTransactionsUseCase seeAllAccountTransactionsUseCase;
    private final DepositFromAccountUseCase depositFromAccountUseCase;
    private final DepositFromATMUseCase depositFromATMUseCase;
    private final DepositFromBranchUseCase depositFromBranchUseCase;
    private final PurchaseInStoreWithCardUseCase purchaseInStoreWithCardUseCase;
    private final PurchaseOnlineWithCardUseCase purchaseOnlineWithCardUseCase;
    private final WithdrawFromATMUseCase withdrawFromATMUseCase;

    @GetMapping("/transaction")
    public ResponseEntity<Object> seeTransaction(@RequestParam("id") long id) {
        try {
            Transaction transaction = seeTransactionUseCase.see(id);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .header("Content-Type", "application/json")
                    .body(transaction);
        } catch (TransactionNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("ERROR");
        }
    }

    @GetMapping("/transactions/{accountId}")
    public ResponseEntity<Object> seeAccountTransactions(@PathVariable("accountId") long accountId) {
        try {
            List<Transaction> transactions = seeAllAccountTransactionsUseCase.see(accountId);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .header("Content-Type", "application/json")
                    .body(transactions);
        } catch (AccountNotFoundException | TransactionNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("ERROR");
        }
    }

    @PostMapping("/transaction/deposit/account")
    public ResponseEntity<Object> depositFromAccount(@RequestBody CreateTransactionInfo createTransactionInfo) {
        try {
            Transaction transaction = createTransactionInfo.toTransaction();
            transaction = depositFromAccountUseCase.create(transaction);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .header("Content-Type", "application/json")
                    .body(generateTransactionMessage(transaction));
        } catch (AccountNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        } catch (InsufficientBalanceException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("ERROR");
        }
    }

    @PostMapping("/transaction/deposit/atm")
    public ResponseEntity<Object> depositFromATM(@RequestBody CreateTransactionInfo createTransactionInfo) {
        try {
            Transaction transaction = createTransactionInfo.toTransaction();
            transaction = depositFromATMUseCase.create(transaction);

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .header("Content-Type", "application/json")
                    .body(generateTransactionMessage(transaction));
        } catch (AccountNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        } catch (InsufficientBalanceException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("ERROR");
        }
    }

    @PostMapping("/transaction/deposit/branch")
    public ResponseEntity<Object> depositFromBranch(@RequestBody CreateTransactionInfo createTransactionInfo) {
        try {
            Transaction transaction = createTransactionInfo.toTransaction();
            transaction = depositFromBranchUseCase.create(transaction);

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .header("Content-Type", "application/json")
                    .body(generateTransactionMessage(transaction));
        } catch (AccountNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        } catch (InsufficientBalanceException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("ERROR");
        }
    }

    @PostMapping("/transaction/purchase/in-store-card")
    public ResponseEntity<Object> purchaseInStoreWithCard(@RequestBody CreateTransactionInfo createTransactionInfo) {
        try {
            Transaction transaction = createTransactionInfo.toTransaction();
            transaction = purchaseInStoreWithCardUseCase.create(transaction);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .header("Content-Type", "application/json")
                    .body(generateTransactionMessage(transaction));
        } catch (AccountNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        } catch (InsufficientBalanceException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("ERROR");
        }
    }

    @PostMapping("/transaction/purchase/online-card")
    public ResponseEntity<Object> purchaseOnlineWithCard(@RequestBody CreateTransactionInfo createTransactionInfo) {
        try {
            Transaction transaction = createTransactionInfo.toTransaction();
            transaction = purchaseOnlineWithCardUseCase.create(transaction);

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .header("Content-Type", "application/json")
                    .body(generateTransactionMessage(transaction));
        } catch (AccountNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        } catch (InsufficientBalanceException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("ERROR");
        }
    }

    @PostMapping("/transaction/withdrawal/atm")
    public ResponseEntity<Object> withdrawFromATM(@RequestBody CreateTransactionInfo createTransactionInfo) {
        try {
            Transaction transaction = createTransactionInfo.toTransaction();
            transaction = withdrawFromATMUseCase.create(transaction);

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .header("Content-Type", "application/json")
                    .body(generateTransactionMessage(transaction));
        } catch (AccountNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        } catch (InsufficientBalanceException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("ERROR");
        }
    }

    private String generateTransactionMessage(Transaction transaction) {
        return ("Transaction created:\n"
                //.concat("id: " + transaction.getId() + "\n")
                .concat("value: " + transaction.getValue() + "\n")
                .concat("cost: " + transaction.getCost() + "\n")
                .concat("date: " + transaction.getDate() + "\n")
                .concat("description: " + transaction.getDescription() + "\n")
                .concat("type: " + transaction.getType() + "\n")
                .concat("mean: " + transaction.getMean() + "\n")
                .concat("account id: " + transaction.getAccountId())
        );
    }
}
