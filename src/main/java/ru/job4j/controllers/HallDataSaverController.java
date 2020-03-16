package ru.job4j.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.job4j.model.Account;
import ru.job4j.model.Hall;
import ru.job4j.services.HallService;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet("/save-hall-data")
public class HallDataSaverController extends HttpServlet {
    private static final HallService SERVICE = HallService.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String seatId = req.getParameter("seatId");
        String accountData = req.getParameter("accountData");
        Account account = mapper.readValue(accountData, Account.class);
        List<Hall> listOfSeatsId = Arrays.asList(mapper.readValue(seatId, Hall[].class));
        SERVICE.paymentOperation(listOfSeatsId, account);
    }
}
