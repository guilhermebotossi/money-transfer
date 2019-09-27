package br.com.gbotossi.revolutpoc.config;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;
import org.h2.tools.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.annotation.WebListener;
import java.sql.SQLException;

@WebListener
public class AppInitializer extends GuiceServletContextListener {

    private static Logger logger = LoggerFactory.getLogger(AppInitializer.class);
    private Server tcpServer;
    private Server webServer;


    public AppInitializer(){
        try{
            String[] webProp = {"-web", "-webAllowOthers", "-ifNotExists"};
            String[] tcpProp = {"-tcp", "-tcpAllowOthers", "-tcpAllowOthers", "-ifNotExists"};
            tcpServer = Server.createTcpServer(tcpProp).start();
            webServer = Server.createWebServer(webProp).start();
        } catch(SQLException e) {
            logger.error("Irrecoverable Error while trying to start H2 Server!!! Exiting ...", e);
            System.exit(1);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        super.contextDestroyed(sce);
        tcpServer.stop();
        webServer.stop();
    }

    @Override
    protected Injector getInjector() {
        return Guice.createInjector( new ServletModule());
    }
}
