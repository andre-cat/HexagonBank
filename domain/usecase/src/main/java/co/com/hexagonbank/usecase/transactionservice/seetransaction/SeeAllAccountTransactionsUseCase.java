package co.com.hexagonbank.usecase.transactionservice.seetransaction;

import co.com.hexagonbank.model.account.Account;
import co.com.hexagonbank.model.account.exceptions.AccountNotFoundException;
import co.com.hexagonbank.model.account.gateways.AccountRepository;
import co.com.hexagonbank.model.transaction.Transaction;
import co.com.hexagonbank.model.transaction.exceptions.TransactionNotFoundException;
import co.com.hexagonbank.model.transaction.gateways.TransactionRepository;

import java.util.List;

public class SeeAllAccountTransactionsUseCase implements ISeeAllAccountTransactions {

    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;

    public SeeAllAccountTransactionsUseCase(AccountRepository accountRepository, TransactionRepository transactionRepository) {
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

    @Override
    public List<Transaction> see(long accountId) {
        if (isAccountCreated(accountId)) {
            List<Transaction> transactionEntities = transactionRepository.selectAllByAccountId(accountId);

            if (transactionEntities.isEmpty()) {
                throw new TransactionNotFoundException("There is no transactions for account " + accountId + " yet");
            } else {
                return transactionEntities;
            }
        } else {
            throw new AccountNotFoundException("The account doesn't exist. Unable to show transactions");
        }
    }

    private boolean isAccountCreated(long accountId) {
        Account account = accountRepository.selectById(accountId);
        return account != null;
    }
}
