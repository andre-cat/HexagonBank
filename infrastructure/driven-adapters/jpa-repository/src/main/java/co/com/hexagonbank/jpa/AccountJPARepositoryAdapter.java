package co.com.hexagonbank.jpa;

import co.com.hexagonbank.jpa.data.AccountData;
import co.com.hexagonbank.jpa.helper.AccountMapper;
import co.com.hexagonbank.jpa.helper.AdapterOperations;
import co.com.hexagonbank.model.account.Account;
import co.com.hexagonbank.model.account.gateways.AccountRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

@Repository
public class AccountJPARepositoryAdapter extends AdapterOperations<Account, AccountData, Long, AccountJPARepository> implements AccountRepository {

    private final AccountJPARepository accountJPARepository;

    public AccountJPARepositoryAdapter(AccountJPARepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.map(d, Account.class));
        this.accountJPARepository = repository;
    }

    @Override
    public Account selectById(long id) {
        AccountData accountData = accountJPARepository.findById(id).orElse(null);
        return toEntity(accountData);
    }

    @Override
    public Account selectByUserId(long userId) {
        return AccountMapper.mapToAccount(accountJPARepository.selectByUserId(userId));
    }

    @Override
    public void insert(Account account) {
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
