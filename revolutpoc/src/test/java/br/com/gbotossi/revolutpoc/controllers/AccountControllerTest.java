package br.com.gbotossi.revolutpoc.controllers;

import br.com.gbotossi.revolutpoc.models.Account;
import br.com.gbotossi.revolutpoc.services.AccountService;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static br.com.gbotossi.revolutpoc.utils.CustomMockito.*;
import static org.junit.Assert.*;

public class AccountControllerTest {

    private AccountController accountController;
    private AccountService accountService;

    @Before
    public void before() {
        accountService = mock(AccountService.class);
        accountController = new AccountController(accountService);
    }

    @Test
    public void noArgsCostructor(){
        AccountController accountController = new AccountController();
        assertNotNull(accountController);
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
        Long id = 1L;
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
