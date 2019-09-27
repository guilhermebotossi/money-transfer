package br.com.gbotossi.revolutpoc.config;

import br.com.gbotossi.revolutpoc.controllers.AccountController;
import br.com.gbotossi.revolutpoc.repositories.AccountRepository;
import br.com.gbotossi.revolutpoc.repositories.DefaultAccountRepository;
import br.com.gbotossi.revolutpoc.services.AccountService;
import br.com.gbotossi.revolutpoc.services.DefaultAccountService;
import com.google.inject.AbstractModule;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.persist.PersistService;
import com.google.inject.persist.jpa.JpaPersistModule;
import com.google.inject.servlet.GuiceFilter;

public class GuiceModule extends AbstractModule {

    @Override
    protected void configure() {
        install(new JpaPersistModule("H2_PU"));
        bind(JPAInitializer.class).asEagerSingleton();
        bind(AccountController.class);
        bind(AccountService.class).to(DefaultAccountService.class);
        bind(AccountRepository.class).to(DefaultAccountRepository.class);
        bind(GuiceFilter.class);
    }

    @Singleton
    private static class JPAInitializer {
        @Inject
        public JPAInitializer(PersistService service) {
            service.start();
        }
    }
}
