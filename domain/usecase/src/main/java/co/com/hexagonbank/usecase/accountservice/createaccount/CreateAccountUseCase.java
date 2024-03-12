package co.com.hexagonbank.usecase.accountservice.createaccount;

import co.com.hexagonbank.model.account.Account;
import co.com.hexagonbank.model.account.gateways.AccountRepository;
import co.com.hexagonbank.model.transaction.Transaction;
import co.com.hexagonbank.model.transaction.gateways.TransactionRepository;
import co.com.hexagonbank.model.transaction.types.TransactionMean;
import co.com.hexagonbank.model.transaction.types.TransactionType;
import co.com.hexagonbank.model.user.User;
import co.com.hexagonbank.model.user.exceptions.UserNotFoundException;
import co.com.hexagonbank.model.user.exceptions.UserWithAccountException;
import co.com.hexagonbank.model.user.gateways.UserRepository;

import java.util.Date;

public class CreateAccountUseCase implements ICreateAccount {

    private final UserRepository userRepository;
    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;

    public CreateAccountUseCase(UserRepository userRepository, AccountRepository accountRepository, TransactionRepository transactionRepository) {
        this.userRepository = userRepository;
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

    @Override
    public Account create(Account account) {
        if (isUserCreated(account.getUserId())) {
            if (!hasUserAnAccount(account.getUserId())) {
                if (isBalanceEnough(account.getBalance())) {
                    accountRepository.insert(account);
                    Long maxId = accountRepository.selectMaxId();
                    maxId = maxId == null ? 0 : maxId;
                    Transaction transaction = new Transaction(0, account.getBalance(), 0, Date.from(java.time.ZonedDateTime.now().toInstant()), "My first deposit", TransactionType.DEPOSIT, TransactionMean.BRANCH, maxId);
                    transactionRepository.insert(transaction);
                }
                return account;
            } else {
                throw new UserWithAccountException();
            }
        } else {
            throw new UserNotFoundException();
        }
    }

    private boolean isUserCreated(long userId) {
        User user = userRepository.selectById(userId);
        return user != null;
    }

    private boolean hasUserAnAccount(long userId) {
        Account account = accountRepository.selectById(userId);
        return account != null;
    }

    private boolean isBalanceEnough(double balance) {
        return balance > 0;
    }
}
