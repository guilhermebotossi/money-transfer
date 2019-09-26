package br.com.gbotossi.revolutpoc.services;

import br.com.gbotossi.revolutpoc.models.Account;
import br.com.gbotossi.revolutpoc.repositories.AccountRepository;

import javax.inject.Inject;
import java.util.List;

public class DefaultAccountService implements AccountService {

    private AccountRepository accountRepository;

    @Inject
    public DefaultAccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }


    @Override
    public List<Account> listAll() {
        return accountRepository.listAll();
    }

    @Override
    public Account findById(Long id) {
        return accountRepository.findById(id);
    }

    @Override
    public Account create(Account account) {
        return accountRepository.create(account);
    }
}
