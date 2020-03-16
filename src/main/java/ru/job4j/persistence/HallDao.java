package ru.job4j.persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.job4j.model.Account;
import ru.job4j.model.Hall;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HallDao {
    private static final HallDao INSTANCE = new HallDao();
    private static final PoolDaoConnection POOL_DAO_CONNECTION = PoolDaoConnection.getInstance();
    private static final AccountDao ACCOUNT_DAO = AccountDao.getInstance();
    private static final Logger LOG = LogManager.getLogger(HallDao.class.getName());
    private static final String TABLE = "hall";
    private static final String UPDATE_BY_ID = "UPDATE " + TABLE + " SET status=?, account_id=? WHERE id ";
    private static final String SELECT_ALL = "SELECT * FROM " + TABLE + " ORDER BY id";
    private static final String MESSAGE_FIND_ALL = "Смотри в выборку всего с таблицы " + TABLE;
    private static final String MESSAGE_UPDATE_STATUS = "Ошибка при попытке проведения транзакции покупки билетов";
    private static final String MESSAGE_ROLLBACK = "Откат транзакции на начало";
    private static final String MESSAGE_FINALLY_BLOCK = "С закрытием ресурсов пошло что то не так";
    private static final boolean FLAG_PLACE_IS_BOOKED = false;
    private static final boolean RESET_RESERVATION_STATUS = true;
    private static final int DEFAULT_ACCOUNT_ID = -1;

    private HallDao() {

    }

    public static HallDao getInstance() {
        return INSTANCE;
    }

    public List<Hall> findAll() {
        List<Hall> allHalls = new ArrayList<>();
        try (Connection connection = POOL_DAO_CONNECTION.getConnection();
             Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(SELECT_ALL)) {
                while (resultSet.next()) {
                    allHalls.add(fillHall(resultSet));
                }
            }
        } catch (SQLException e) {
            LOG.error(MESSAGE_FIND_ALL, e);
        }
        return allHalls;
    }

    public void paymentTransaction(List<Hall> listId, Account account) {
        int listSize = listId.size();
        int accountId = -1;
        String blockIn = generateQueryForUpdate(listSize);
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = POOL_DAO_CONNECTION.getConnection();
            connection.setAutoCommit(false);
            accountId = ACCOUNT_DAO.addAccount(account);
            preparedStatement = connection.prepareStatement(UPDATE_BY_ID + blockIn);
            setDataForUpdate(preparedStatement, listId, accountId);
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException rollbackException) {
                LOG.error(MESSAGE_ROLLBACK, rollbackException);
            }
            LOG.error(MESSAGE_UPDATE_STATUS, e);
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.setAutoCommit(true);
                    connection.close();
                }
            } catch (SQLException sqlException) {
                LOG.error(MESSAGE_FINALLY_BLOCK, sqlException);
            }
        }
    }

    public void restoreHallData() {
        try (Connection connection = POOL_DAO_CONNECTION.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE " + TABLE + " SET status=?, account_id=?")) {
            preparedStatement.setBoolean(1, RESET_RESERVATION_STATUS);
            preparedStatement.setInt(2, DEFAULT_ACCOUNT_ID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOG.error(MESSAGE_FIND_ALL, e);
        }
    }

    private void setDataForUpdate(PreparedStatement preparedStatement, List<Hall> listId, int accountId) throws SQLException {
        preparedStatement.setBoolean(1, FLAG_PLACE_IS_BOOKED);
        preparedStatement.setInt(2, accountId);
        for (int index = 1; index <= listId.size(); index++) {
            preparedStatement.setInt(index + 2, listId.get(index - 1).getId());
        }
    }

    private String generateQueryForUpdate(int countQuestionMark) {
        StringBuilder blockIn = new StringBuilder();
        blockIn.append("in(");
        for (int index = 0; index < countQuestionMark; index++) {
            if (index != countQuestionMark - 1) {
                blockIn.append("?, ");
            } else {
                blockIn.append("?)");
            }
        }
        return blockIn.toString();
    }

    private Hall fillHall(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        int row = resultSet.getInt("row");
        int seat = resultSet.getInt("seat");
        boolean status = resultSet.getBoolean("status");
        int accountId = resultSet.getInt("account_id");
        return new Hall(id, row, seat, status, accountId);
    }
}
