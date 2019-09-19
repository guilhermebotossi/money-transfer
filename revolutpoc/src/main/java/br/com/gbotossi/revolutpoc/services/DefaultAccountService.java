package br.com.gbotossi.revolutpoc.services;

import br.com.gbotossi.revolutpoc.models.Account;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DefaultAccountService implements AccountService {
    @Override
    public List<Account> listAll() {
        return new ArrayList<>();
    }

    @Override
    public Account findById(UUID id) {
        return new Account();
    }

    @Override
    public Account create(Account accountMock) {
        return new Account();
    }
}
