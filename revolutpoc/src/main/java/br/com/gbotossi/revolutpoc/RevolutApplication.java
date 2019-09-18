package br.com.gbotossi.revolutpoc;

import br.com.gbotossi.revolutpoc.resources.MessageResource;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/")
public class RevolutApplication extends Application {

    private Set<Object> singletons = new HashSet<Object>();

    public RevolutApplication() {
        singletons.add(new MessageResource());
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }

}
