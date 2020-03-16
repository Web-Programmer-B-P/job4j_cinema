package ru.job4j.filtres;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("*")
public class DispatcherFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        String currentRequestUri = req.getRequestURI();

        if (currentRequestUri.contains("/hall") || currentRequestUri.contains("css/style.css")) {
            chain.doFilter(req, resp);
        } else {
            resp.sendRedirect("/hall");
        }
    }
}
