package co.com.hexagonbank.api;

import co.com.hexagonbank.model.account.gateways.AccountRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AccountRestTest {


    @InjectMocks
    AccountRepository accountRepository;

    @Mock
    AccountRest accountRest;

    @Test
    void setAccountRest() {
       
    }
}
