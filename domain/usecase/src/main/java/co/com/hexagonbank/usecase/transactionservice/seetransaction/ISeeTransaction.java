package co.com.hexagonbank.usecase.transactionservice.seetransaction;

import co.com.hexagonbank.model.transaction.Transaction;

public interface ISeeTransaction {

    Transaction see(long id);

}
