package br.com.gbotossi.revolutpoc;

import org.h2.tools.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebListener
public class AppInitializer implements ServletContextListener {

    private static Logger logger = LoggerFactory.getLogger(AppInitializer.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
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
        try {
            Server.shutdownTcpServer("tcp://localhost:9092", "", true, true);
        } catch (SQLException e) {

        }
    }
}
