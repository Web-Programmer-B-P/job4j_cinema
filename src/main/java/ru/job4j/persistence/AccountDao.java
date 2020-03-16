package ru.job4j.persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.job4j.model.Account;
import java.sql.*;

public class AccountDao {
    private static final AccountDao INSTANCE = new AccountDao();
    private static final PoolDaoConnection POOL_DAO_CONNECTION = PoolDaoConnection.getInstance();
    private static final Logger LOG = LogManager.getLogger(AccountDao.class.getName());
    private static final String TABLE_NAME = "account";
    private static final String INSERT_NEW_ACCOUNT = "INSERT INTO " + TABLE_NAME + " (name, phone) values (?, ?)";
    private static final String GET_BACK_NEW_ID = "id";

    private AccountDao() {

    }

    public static AccountDao getInstance() {
        return INSTANCE;
    }

    public int addAccount(Account account) throws SQLException {
        int accountId = -1;
        try (Connection connection = POOL_DAO_CONNECTION.getConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement(INSERT_NEW_ACCOUNT,
                             Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, account.getName());
            preparedStatement.setString(2, account.getPhone());
            preparedStatement.executeUpdate();
            try (ResultSet rs = preparedStatement.getGeneratedKeys()) {
                if (rs.next()) {
                    accountId = rs.getInt(GET_BACK_NEW_ID);
                }
            }
        }
        return accountId;
    }
}
