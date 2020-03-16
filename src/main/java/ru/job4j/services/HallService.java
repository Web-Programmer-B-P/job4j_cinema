package ru.job4j.services;

import ru.job4j.model.Account;
import ru.job4j.model.Hall;
import ru.job4j.persistence.HallDao;
import java.util.List;

public class HallService {
    private static final HallService INSTANCE = new HallService();
    private static final HallDao HALL_DAO = HallDao.getInstance();

    private HallService() {

    }

    public static HallService getInstance() {
        return INSTANCE;
    }

    public List<Hall> findAll() {
        return HALL_DAO.findAll();
    }

    public void paymentOperation(List<Hall> listId, Account account) {
        HALL_DAO.paymentTransaction(listId, account);
    }

    public void restoreHallDefaultState() {
        HALL_DAO.restoreHallData();
    }
}
