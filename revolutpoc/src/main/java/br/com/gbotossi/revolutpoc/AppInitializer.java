package br.com.gbotossi.revolutpoc;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;
import org.h2.tools.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.annotation.WebListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebListener
public class AppInitializer extends GuiceServletContextListener {

    private static Logger logger = LoggerFactory.getLogger(AppInitializer.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        super.contextInitialized(sce);
        Injector injector = Guice.createInjector(new GuiceModule());
        try {
            Server.createTcpServer("-tcpPort", "9092", "-tcpAllowOthers", "-ifNotExists").start();
            validateConnection();
        } catch(SQLException | ClassNotFoundException e) {
            logger.error("Irrecoverable Error while trying to start H2 Server!!! Exiting ...", e);
            System.exit(1);
        }
    }

    private void validateConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");
        Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/:9092", "sa", "");
        conn.createStatement().execute("select 1");
    }

    public void contextDestroyed(ServletContextEvent sce) {
        super.contextDestroyed(sce);
        try {
            Server.shutdownTcpServer("tcp://localhost:9092", "", true, true);
        } catch (SQLException e) {

        }
    }

    @Override
    protected Injector getInjector() {
        return Guice.createInjector(new ServletModule());
    }
}
