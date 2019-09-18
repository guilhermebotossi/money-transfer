package br.com.gbotossi.revolutpoc.controllers;

import br.com.gbotossi.revolutpoc.models.Account;
import br.com.gbotossi.revolutpoc.services.AccountService;

import java.util.List;

public class AccountController {

    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }


    public List<Account> listAll() {
        return accountService.listAll();
    }
}
