package co.com.hexagonbank.usecase.transactionservice.createtransaction.implementation.depositfromaccount;

import co.com.hexagonbank.model.account.Account;
import co.com.hexagonbank.model.account.gateways.AccountRepository;
import co.com.hexagonbank.model.transaction.Transaction;
import co.com.hexagonbank.model.transaction.gateways.TransactionRepository;
import co.com.hexagonbank.model.transaction.types.TransactionMean;
import co.com.hexagonbank.model.transaction.types.TransactionType;
import co.com.hexagonbank.usecase.transactionservice.createtransaction.implementation.CreateTransactionUseCase;

import java.util.Date;

public class DepositFromAccountUseCase extends CreateTransactionUseCase {

    public DepositFromAccountUseCase(AccountRepository accountRepository, TransactionRepository transactionRepository) {
        super(accountRepository, transactionRepository);
    }

    @Override
    protected double calculateBalance(Transaction transaction, Account account) {
        return account.getBalance() + transaction.getValue() - transaction.getCost();
    }

    @Override
    protected Transaction addInformation(Transaction transaction) {
        transaction.setDate(Date.from(java.time.ZonedDateTime.now().toInstant()));
        transaction.setType(TransactionType.DEPOSIT);
        transaction.setMean(TransactionMean.ACCOUNT);
        transaction.setCost(1.5);
        return transaction;
    }
}