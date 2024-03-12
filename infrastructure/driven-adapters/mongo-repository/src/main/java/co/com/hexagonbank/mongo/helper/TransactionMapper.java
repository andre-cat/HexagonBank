package co.com.hexagonbank.mongo.helper;

import co.com.hexagonbank.model.transaction.Transaction;
import co.com.hexagonbank.mongo.data.TransactionEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TransactionMapper {

    public static Transaction mapToTransaction(Optional<TransactionEntity> optionalTransactionEntity) {
        if (optionalTransactionEntity.isPresent()) {
            TransactionEntity transactionEntity = optionalTransactionEntity.get();
            return new Transaction(
                    transactionEntity.getId(),
                    transactionEntity.getValue(),
                    transactionEntity.getCost(),
                    transactionEntity.getDate(),
                    transactionEntity.getDescription(),
                    transactionEntity.getType(),
                    transactionEntity.getMean(),
                    transactionEntity.getAccountId()
            );
        } else {
            return null;
        }
    }

    public static Transaction mapToTransaction(TransactionEntity transactionEntity) {
        return new Transaction(
                transactionEntity.getId(),
                transactionEntity.getValue(),
                transactionEntity.getCost(),
                transactionEntity.getDate(),
                transactionEntity.getDescription(),
                transactionEntity.getType(),
                transactionEntity.getMean(),
                transactionEntity.getAccountId()
        );
    }

    public static List<Transaction> mapToTransactionList(Iterable<TransactionEntity> transactionEntities) {
        List<Transaction> transactions = new ArrayList<>();

        for (TransactionEntity transactionEntity : transactionEntities) {
            transactions.add(mapToTransaction(transactionEntity));
        }

        return transactions;
    }

    public static TransactionEntity mapToTransactionEntity(Transaction transaction) {
        TransactionEntity transactionEntity = new TransactionEntity();
        transactionEntity.setId(transaction.getId());
        transactionEntity.setValue(transaction.getValue());
        transactionEntity.setCost(transaction.getCost());
        transactionEntity.setDate(transaction.getDate());
        transactionEntity.setDescription(transaction.getDescription());
        transactionEntity.setType(transaction.getType());
        transactionEntity.setMean(transaction.getMean());
        transactionEntity.setAccountId(transaction.getAccountId());
        return transactionEntity;
    }
}
