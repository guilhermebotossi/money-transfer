package br.com.gbotossi.revolutpoc.services;

import br.com.gbotossi.revolutpoc.models.Account;

import java.util.List;
import java.util.UUID;

public interface AccountService {
    public List<Account> listAll();

    public Account findById(UUID id);

    public Account create(Account accountMock);
}
