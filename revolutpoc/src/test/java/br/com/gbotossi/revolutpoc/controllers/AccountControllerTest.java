package br.com.gbotossi.revolutpoc.controllers;

import br.com.gbotossi.revolutpoc.models.Account;
import br.com.gbotossi.revolutpoc.services.AccountService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import java.util.UUID;

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

    @Test
    public void findById_called_success(){
        UUID id = UUID.fromString("2f1246c0-c023-4fca-ab8d-b57ae848546c");
        Account accountMock = mock(Account.class);
        when(accountService.findById(id)).thenReturn(accountMock);

        Account account = accountController.findById(id);

        assertSame(accountMock, account);
        verify(accountService).findById(id);
    }

    @Test
    public void create_called_success(){
        Account accountMock = mock(Account.class);
        when(accountService.create(accountMock)).thenReturn(accountMock);

        Account account = accountController.create(accountMock);

        assertSame(accountMock, account);
        verify(accountService).create(accountMock);
    }

}
