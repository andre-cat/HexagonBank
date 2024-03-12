package co.com.hexagonbank.usecase.accountservice.seeaccount;

import co.com.hexagonbank.model.account.Account;
import co.com.hexagonbank.model.account.exceptions.AccountNotFoundException;
import co.com.hexagonbank.model.account.gateways.AccountRepository;

public class SeeAccountUseCase implements ISeeAccount {

    private final AccountRepository accountRepository;

    public SeeAccountUseCase(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account see(long id) {
        Account account = accountRepository.selectById(id);
        if (account != null) {
            return account;
        } else {
            throw new AccountNotFoundException();
        }
    }

}
