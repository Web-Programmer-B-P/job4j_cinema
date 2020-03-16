package ru.job4j.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.job4j.model.Account;
import ru.job4j.model.Hall;
import ru.job4j.services.HallService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

@WebServlet("/hall")
public class HallController extends HttpServlet {
    private static final HallService SERVICE = HallService.getInstance();
    private static final String CONTENT_TYPE = "txt/html";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("hall/hall.html").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String action = req.getParameter("action");
        if (action.equals("getAll")) {
            PrintWriter writer = resp.getWriter();
            resp.setContentType(CONTENT_TYPE);
            String responseObject = new ObjectMapper().writeValueAsString(SERVICE.findAll());
            writer.write(responseObject);
            writer.flush();
        }

        if (action.equals("save")) {
            ObjectMapper mapper = new ObjectMapper();
            String seatId = req.getParameter("seatId");
            String accountData = req.getParameter("accountData");
            Account account = mapper.readValue(accountData, Account.class);
            List<Hall> listOfSeatsId = Arrays.asList(mapper.readValue(seatId, Hall[].class));
            SERVICE.paymentOperation(listOfSeatsId, account);
        }
    }
}
