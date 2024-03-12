package co.com.hexagonbank.usecase.transactionservice.seetransaction;

import co.com.hexagonbank.model.account.exceptions.AccountNotFoundException;
import co.com.hexagonbank.model.transaction.Transaction;
import co.com.hexagonbank.model.transaction.exceptions.TransactionNotFoundException;
import co.com.hexagonbank.model.transaction.gateways.TransactionRepository;

public class SeeTransactionUseCase implements ISeeTransaction {

    private final TransactionRepository transactionRepository;

    public SeeTransactionUseCase(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public Transaction see(long id) {
        Transaction transaction = transactionRepository.selectById(id);
        if (transaction != null) {
            return transaction;
        } else {
            throw new TransactionNotFoundException();
        }
    }
}
