package co.com.hexagonbank.usecase.accountservice.seeaccount;

import co.com.hexagonbank.model.account.Account;

public interface ISeeAccount {

    Account see(long accountId);

}
