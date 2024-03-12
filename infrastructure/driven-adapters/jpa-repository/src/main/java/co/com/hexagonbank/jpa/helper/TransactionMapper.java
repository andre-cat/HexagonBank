package co.com.hexagonbank.jpa.helper;

import co.com.hexagonbank.jpa.data.TransactionData;
import co.com.hexagonbank.model.transaction.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TransactionMapper {

    public static Transaction mapToTransaction(Optional<TransactionData> optionalTransactionEntity) {
        if (optionalTransactionEntity.isPresent()) {
            TransactionData transactionData = optionalTransactionEntity.get();
            return new Transaction(
                    transactionData.getId(),
                    transactionData.getValue(),
                    transactionData.getCost(),
                    transactionData.getDate(),
                    transactionData.getDescription(),
                    transactionData.getType(),
                    transactionData.getMean(),
                    transactionData.getAccountId()
            );
        } else {
            return null;
        }
    }

    public static Transaction mapToTransaction(TransactionData transactionData) {
        return new Transaction(
                transactionData.getId(),
                transactionData.getValue(),
                transactionData.getCost(),
                transactionData.getDate(),
                transactionData.getDescription(),
                transactionData.getType(),
                transactionData.getMean(),
                transactionData.getAccountId()
        );
    }

    public static List<Transaction> mapToTransactionList(Iterable<TransactionData> transactionEntities) {
        List<Transaction> transactions = new ArrayList<>();

        for (TransactionData transactionData : transactionEntities) {
            transactions.add(mapToTransaction(transactionData));
        }

        return transactions;
    }

    public static TransactionData mapToTransactionEntity(Transaction transaction) {
        TransactionData transactionData = new TransactionData();
        transactionData.setId(transaction.getId());
        transactionData.setValue(transaction.getValue());
        transactionData.setCost(transaction.getCost());
        transactionData.setDate(transaction.getDate());
        transactionData.setDescription(transaction.getDescription());
        transactionData.setType(transaction.getType());
        transactionData.setMean(transaction.getMean());
        transactionData.setAccountId(transaction.getAccountId());
        return transactionData;
    }
}
