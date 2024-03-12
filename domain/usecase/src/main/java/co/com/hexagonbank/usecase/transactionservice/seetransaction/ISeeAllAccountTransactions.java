package co.com.hexagonbank.usecase.transactionservice.seetransaction;

import co.com.hexagonbank.model.transaction.Transaction;

import java.util.List;

public interface ISeeAllAccountTransactions {

    List<Transaction> see(long accountId);

}
