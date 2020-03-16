package ru.job4j.persistence;

import org.apache.commons.dbcp2.BasicDataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class PoolDaoConnection {
    private static final PoolDaoConnection INSTANCE = new PoolDaoConnection();
    private final BasicDataSource source = new BasicDataSource();

    private PoolDaoConnection() {
        source.setDriverClassName("org.postgresql.Driver");
        source.setDriverClassName("org.postgresql.Driver");
        source.setUrl("jdbc:postgresql://ec2-79-125-125-97.eu-west-1.compute.amazonaws.com:5432/d8s278pga7t9ei?ssl=true&sslmode=require");
        source.setUsername("jrstngyiqkrziq");
        source.setPassword("906ca0f80bd67b4ee751db6c35ae9babfa4448faf94617a07f8b975f56b9702a");
        source.setMinIdle(5);
        source.setMaxIdle(10);
        source.setMaxOpenPreparedStatements(100);
    }

    public static PoolDaoConnection getInstance() {
        return INSTANCE;
    }

    public Connection getConnection() throws SQLException {
        return source.getConnection();
    }
}
