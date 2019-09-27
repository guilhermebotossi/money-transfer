package br.com.gbotossi.revolutpoc.repositories;

import br.com.gbotossi.revolutpoc.models.Account;

import java.util.List;

public interface AccountRepository {

    public List<Account> listAll();

    public Account findById(Long id);

    public Account create(Account account);
}
