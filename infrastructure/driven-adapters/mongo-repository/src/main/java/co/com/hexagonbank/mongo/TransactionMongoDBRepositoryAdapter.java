package co.com.hexagonbank.mongo;

import co.com.hexagonbank.model.transaction.Transaction;
import co.com.hexagonbank.model.transaction.gateways.TransactionRepository;
import co.com.hexagonbank.mongo.helper.TransactionMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
@AllArgsConstructor
public class TransactionMongoDBRepositoryAdapter implements TransactionRepository {

    private final TransactionMongoDBRepository transactionMongoDBRepository;

    @Override
    public Transaction selectById(long id) {
        return TransactionMapper.mapToTransaction(Objects.requireNonNull(transactionMongoDBRepository.findById(id)));
    }

    @Override
    public List<Transaction> selectAllByAccountId(long accountId) {
        return TransactionMapper.mapToTransactionList(transactionMongoDBRepository.selectAllByAccountId(accountId));
    }

    @Override
    public void insert(Transaction transaction) {
        Long maxId = transactionMongoDBRepository.selectMaxId();
        maxId = maxId == null ? 0 : maxId;
        transaction.setId(maxId + 1);
        transactionMongoDBRepository.save(TransactionMapper.mapToTransactionEntity(transaction));
    }
}
