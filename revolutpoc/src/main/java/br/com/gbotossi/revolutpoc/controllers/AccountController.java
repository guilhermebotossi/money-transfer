package br.com.gbotossi.revolutpoc.controllers;

import br.com.gbotossi.revolutpoc.models.Account;
import br.com.gbotossi.revolutpoc.services.AccountService;
import com.google.inject.Inject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.UUID;

@Path("/account")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AccountController {

    private AccountService accountService;

    public AccountController() {}
    @Inject
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GET
    public List<Account> listAll() {
        return accountService.listAll();
    }

    @GET
    @Path("{id}")
    public Account findById(@PathParam("id") UUID id) {
        return accountService.findById(id);
    }

    @PUT
    public Account create(Account account) { return accountService.create(account); }
}
