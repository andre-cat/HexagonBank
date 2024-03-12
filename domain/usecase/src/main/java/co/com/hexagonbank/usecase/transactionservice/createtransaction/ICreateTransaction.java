package co.com.hexagonbank.usecase.transactionservice.createtransaction;

import co.com.hexagonbank.model.transaction.Transaction;

public interface ICreateTransaction {

    Transaction create(Transaction transaction);

}
