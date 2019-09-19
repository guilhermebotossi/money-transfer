package br.com.gbotossi.revolutpoc;

import br.com.gbotossi.revolutpoc.controllers.AccountController;
import br.com.gbotossi.revolutpoc.controllers.HelloController;
import br.com.gbotossi.revolutpoc.services.AccountService;
import br.com.gbotossi.revolutpoc.services.DefaultAccountService;
import com.google.inject.AbstractModule;
import com.google.inject.servlet.GuiceFilter;

public class GuiceModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(HelloController.class);
        bind(AccountController.class);
        bind(AccountService.class).to(DefaultAccountService.class);
        bind(GuiceFilter.class);
    }

}
