package co.com.hexagonbank.mongo;

import co.com.hexagonbank.model.account.Account;
import co.com.hexagonbank.model.account.gateways.AccountRepository;
import co.com.hexagonbank.mongo.helper.AccountMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class AccountMongoDBRepositoryAdapter implements AccountRepository {

    private final AccountMongoDBRepository accountJPARepository;

    @Override
    public Account selectById(long id) {
        return AccountMapper.mapToAccount(accountJPARepository.findById(id));
    }

    @Override
    public void insert(Account account) {
        Long maxId = accountJPARepository.selectMaxId();
        maxId = maxId == null ? 0 : maxId;
        account.setId(maxId + 1);
        accountJPARepository.save(AccountMapper.mapToAccountEntity(account));
    }

    @Override
    public void update(Account account) {
        accountJPARepository.save(AccountMapper.mapToAccountEntity(account));
    }

    @Override
    public Long selectMaxId() {
        return accountJPARepository.selectMaxId();
    }
}
