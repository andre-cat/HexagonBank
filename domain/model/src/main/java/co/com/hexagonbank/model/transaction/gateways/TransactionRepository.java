package co.com.hexagonbank.model.transaction.gateways;

import co.com.hexagonbank.model.transaction.Transaction;

import java.util.List;

public interface TransactionRepository {

    Transaction selectById(long id);

    List<Transaction> selectAllByAccountId(long accountId);

    void insert(Transaction transaction);
}
