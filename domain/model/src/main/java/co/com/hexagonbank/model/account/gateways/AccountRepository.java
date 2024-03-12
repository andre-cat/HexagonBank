package co.com.hexagonbank.model.account.gateways;

import co.com.hexagonbank.model.account.Account;

public interface AccountRepository {

    Account selectById(long id);

    Account selectByUserId(long id);

    void insert(Account account);

    void update(Account account);

    Long selectMaxId();
}
