package co.com.hexagonbank.jpa.helper;

import co.com.hexagonbank.jpa.data.AccountData;
import co.com.hexagonbank.model.account.Account;

public class AccountMapper {

    public static Account mapToAccount(AccountData accountData) {
        return new Account(
                accountData.getId(),
                accountData.getBalance(),
                accountData.getUserId()
        );
    }

    public static AccountData mapToAccountEntity(Account account) {
        AccountData accountData = new AccountData();
        accountData.setId(account.getId());
        accountData.setBalance(account.getBalance());
        accountData.setUserId(account.getUserId());
        return accountData;
    }
}
