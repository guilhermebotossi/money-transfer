package br.com.gbotossi.revolutpoc.controllers;

import br.com.gbotossi.revolutpoc.models.Account;
import br.com.gbotossi.revolutpoc.services.AccountService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static br.com.gbotossi.revolutpoc.CustomMockito.*;
import static org.junit.Assert.assertSame;

@RunWith(MockitoJUnitRunner.class)
public class AccountControllerTest {

    private AccountController accountController;
    private AccountService accountService;

    @Before
    public void before() {
        accountService = mock(AccountService.class);
        accountController = new AccountController(accountService);
    }

    @Test
    public void listAll_called_success(){
        List<Account> accountList = mockList(Account.class);
        when(accountService.listAll()).thenReturn(accountList);

        List<Account> accounts = accountController.listAll();

        assertSame(accountList, accounts);
        verify(accountService).listAll();
    }

}
