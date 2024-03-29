package br.com.gbotossi.revolutpoc.services;

import br.com.gbotossi.revolutpoc.models.Account;

import java.util.List;

public interface AccountService {

    public List<Account> listAll();

    public Account findById(Long id);

    public Account create(Account account);
}
