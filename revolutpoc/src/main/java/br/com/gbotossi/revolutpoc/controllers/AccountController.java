package br.com.gbotossi.revolutpoc.controllers;

import br.com.gbotossi.revolutpoc.models.Account;
import br.com.gbotossi.revolutpoc.services.AccountService;

import java.util.List;
import java.util.UUID;

public class AccountController {

    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }


    public List<Account> listAll() {
        return accountService.listAll();
    }

    public Account findById(UUID id) {
        return accountService.findById(id);
    }

    public Account create(Account account) { return accountService.create(account); }
}
