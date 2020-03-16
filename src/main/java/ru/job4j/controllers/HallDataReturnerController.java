package ru.job4j.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.job4j.services.HallService;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/init-hall-data")
public class HallDataReturnerController extends HttpServlet {
    private static final HallService SERVICE = HallService.getInstance();
    private static final String CONTENT_TYPE = "txt/html";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter writer = resp.getWriter();
        resp.setContentType(CONTENT_TYPE);
        String responseObject = new ObjectMapper().writeValueAsString(SERVICE.findAll());
        writer.write(responseObject);
        writer.flush();
    }
}
