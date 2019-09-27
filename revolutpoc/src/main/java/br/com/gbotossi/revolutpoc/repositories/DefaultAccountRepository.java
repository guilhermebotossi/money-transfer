package br.com.gbotossi.revolutpoc.repositories;

import br.com.gbotossi.revolutpoc.models.Account;
import com.google.inject.Inject;

import javax.persistence.EntityManager;
import java.util.List;

public class DefaultAccountRepository implements AccountRepository  {

    private EntityManager entityManager;

    @Inject
    public DefaultAccountRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Account> listAll() {
        return entityManager.createQuery("FROM Account", Account.class).getResultList();
    }

    @Override
    public Account findById(Long id) {
        return entityManager.find(Account.class, id);
    }

    @Override
    public Account create(Account account) {
        entityManager.getTransaction().begin();
        entityManager.persist(account);
        entityManager.getTransaction().commit();
        return account;
    }
}
