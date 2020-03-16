package ru.job4j.persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class PoolDaoConnection {
    private static final PoolDaoConnection INSTANCE = new PoolDaoConnection();
    private static final Logger LOG = LogManager.getLogger(PoolDaoConnection.class.getName());
    private static final String DATA_SOURCE_PATH = "java:comp/env/jdbc/cinemaPool";
    private static final String ERROR_MESSAGE_POOL_CONNECTION = "Смотри в инициализацию контекста пула";

    private PoolDaoConnection() {

    }

    public static PoolDaoConnection getInstance() {
        return INSTANCE;
    }

    public Connection getConnection() {
        Context context;
        Connection connection = null;
        try {
            context = new InitialContext();
            DataSource dataSource = (DataSource) context.lookup(DATA_SOURCE_PATH);
            connection = dataSource.getConnection();
        } catch (NamingException | SQLException e) {
            LOG.error(ERROR_MESSAGE_POOL_CONNECTION, e);
        }
        return connection;
    }
}
