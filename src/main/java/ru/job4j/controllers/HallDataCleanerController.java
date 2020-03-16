package ru.job4j.controllers;

import ru.job4j.services.HallService;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/reset-hall-data")
public class HallDataCleanerController extends HttpServlet {
    private static final HallService SERVICE = HallService.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        SERVICE.restoreHallDefaultState();
    }
}
