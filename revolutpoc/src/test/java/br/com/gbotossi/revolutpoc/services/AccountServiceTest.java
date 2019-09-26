package br.com.gbotossi.revolutpoc.services;

import br.com.gbotossi.revolutpoc.models.Account;
import br.com.gbotossi.revolutpoc.repositories.AccountRepository;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static br.com.gbotossi.revolutpoc.utils.CustomMockito.mockList;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.*;

public class AccountServiceTest {

    private AccountService accountService;
    private AccountRepository accountRepository;

    @Before
    public void before() {
        accountRepository = mock(AccountRepository.class);
        accountService = new DefaultAccountService(accountRepository);
    }

    @Test
    public void listAll_called_success(){
        List<Account> accountList = mockList(Account.class);
        when(accountRepository.listAll()).thenReturn(accountList);

        List<Account> accounts = accountService.listAll();

        assertSame(accountList, accounts);
        verify(accountRepository).listAll();
    }

    @Test
    public void findById_called_success(){
        Long id = 1L;
        Account accountMock = mock(Account.class);
        when(accountRepository.findById(id)).thenReturn(accountMock);

        Account account = accountService.findById(id);

        assertSame(accountMock, account);
        verify(accountRepository).findById(id);
    }

    @Test
    public void create_called_success(){
        Account accountMock = mock(Account.class);
        when(accountRepository.create(accountMock)).thenReturn(accountMock);

        Account account = accountService.create(accountMock);

        assertSame(accountMock, account);
        verify(accountRepository).create(accountMock);
    }

}
