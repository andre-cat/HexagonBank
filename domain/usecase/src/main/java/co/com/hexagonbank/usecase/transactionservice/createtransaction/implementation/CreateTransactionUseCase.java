package co.com.hexagonbank.usecase.transactionservice.createtransaction.implementation;

import co.com.hexagonbank.model.account.Account;
import co.com.hexagonbank.model.account.exceptions.AccountNotFoundException;
import co.com.hexagonbank.model.account.exceptions.InsufficientBalanceException;
import co.com.hexagonbank.model.account.gateways.AccountRepository;
import co.com.hexagonbank.model.transaction.Transaction;
import co.com.hexagonbank.model.transaction.gateways.TransactionRepository;
import co.com.hexagonbank.usecase.transactionservice.createtransaction.ICreateTransaction;

public abstract class CreateTransactionUseCase implements ICreateTransaction {

    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;

    public CreateTransactionUseCase(AccountRepository accountRepository, TransactionRepository transactionRepository) {
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

    @Override
    public Transaction create(Transaction transaction) {
        Account account = accountRepository.selectById(transaction.getAccountId());
        if (account != null) {
            transaction = addInformation(transaction);
            double newBalance = calculateBalance(transaction, account);
            if (newBalance >= 0) {
                transactionRepository.insert(transaction);
                account.setBalance(newBalance);
                accountRepository.update(account);
                return transaction;
            } else {
                throw new InsufficientBalanceException();
            }
        } else {
            throw new AccountNotFoundException("The account doesn't exist. Unable to create transaction");
        }
    }

    protected abstract double calculateBalance(Transaction transaction, Account account);

    protected abstract Transaction addInformation(Transaction transaction);
}
