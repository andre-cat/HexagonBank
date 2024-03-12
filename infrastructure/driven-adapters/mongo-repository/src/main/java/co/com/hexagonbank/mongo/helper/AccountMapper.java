package co.com.hexagonbank.mongo.helper;

import co.com.hexagonbank.model.account.Account;
import co.com.hexagonbank.mongo.data.AccountEntity;

import java.util.Optional;

public class AccountMapper {

    public static Account mapToAccount(Optional<AccountEntity> optionalAccountEntity) {
        if (optionalAccountEntity.isPresent()) {
            AccountEntity accountEntity = optionalAccountEntity.get();
            return new Account(
                    accountEntity.getId(),
                    accountEntity.getBalance(),
                    accountEntity.getUserId()
            );
        } else {
            return null;
        }
    }

    public static AccountEntity mapToAccountEntity(Account account) {
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setId(account.getId());
        accountEntity.setBalance(account.getBalance());
        accountEntity.setUserId(account.getUserId());
        return accountEntity;
    }
}
