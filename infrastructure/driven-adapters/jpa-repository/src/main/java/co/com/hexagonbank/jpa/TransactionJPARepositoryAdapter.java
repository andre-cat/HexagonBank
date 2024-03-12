package co.com.hexagonbank.jpa;

import co.com.hexagonbank.jpa.helper.TransactionMapper;
import co.com.hexagonbank.model.transaction.Transaction;
import co.com.hexagonbank.model.transaction.gateways.TransactionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class TransactionJPARepositoryAdapter implements TransactionRepository {

    private final TransactionJPARepository transactionJPARepository;

    @Override
    public Transaction selectById(long id) {
        return TransactionMapper.mapToTransaction(transactionJPARepository.findById(id));
    }

    @Override
    public List<Transaction> selectAllByAccountId(long accountId) {
        return TransactionMapper.mapToTransactionList(transactionJPARepository.selectAllByAccountId(accountId));
    }

    @Override
    public void insert(Transaction transaction) {
        transactionJPARepository.save(TransactionMapper.mapToTransactionEntity(transaction));
    }
}
