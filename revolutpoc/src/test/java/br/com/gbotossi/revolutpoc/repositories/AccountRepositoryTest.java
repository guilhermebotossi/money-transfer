package br.com.gbotossi.revolutpoc.repositories;

import br.com.gbotossi.revolutpoc.models.Account;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

import static br.com.gbotossi.revolutpoc.utils.CustomMockito.mockList;
import static br.com.gbotossi.revolutpoc.utils.CustomMockito.mockTypedQuery;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.*;

public class AccountRepositoryTest {

    private EntityManager entityManager;
    private AccountRepository accountRepository;

    @Before
    public void before() {
        entityManager = mock(EntityManager.class);
        accountRepository = new DefaultAccountRepository(entityManager);
    }

    @Test
    public void listAll_called_success(){
        String query = "FROM Account";
        TypedQuery<Account> typedQuery = mockTypedQuery(Account.class);
        when(entityManager.createQuery(query, Account.class)).thenReturn(typedQuery);
        List<Account> accountList = mockList(Account.class);
        when(typedQuery.getResultList()).thenReturn(accountList);

        List<Account> accounts = accountRepository.listAll();

        assertSame(accountList, accounts);
        verify(entityManager).createQuery(query, Account.class);
        verify(typedQuery).getResultList();
    }

    @Test
    public void findById_called_success(){
        Long id = 1L;
        Account accountMock = mock(Account.class);
        when(entityManager.find(Account.class, id)).thenReturn(accountMock);

        Account account = accountRepository.findById(id);

        assertSame(accountMock, account);
        verify(entityManager).find(Account.class, id);
    }

    @Test
    public void create_called_success(){
        Account accountMock = mock(Account.class);
        EntityTransaction entityTransaction = mock(EntityTransaction.class);
        when(entityManager.getTransaction()).thenReturn(entityTransaction);

        Account account = accountRepository.create(accountMock);

        assertSame(accountMock, account);
        verify(entityManager, times(2)).getTransaction();
        verify(entityTransaction).begin();
        verify(entityTransaction).commit();
    }

}
