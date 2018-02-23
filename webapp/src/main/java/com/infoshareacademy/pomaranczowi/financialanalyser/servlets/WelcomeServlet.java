package com.infoshareacademy.pomaranczowi.financialanalyser.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("")
public class WelcomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pageLanguage = req.getParameter("lang");
        if (pageLanguage != null) {
            setLanguage(req, resp, pageLanguage);
        } else {
            setLanguage(req, resp, "en_GB");
        }
    }

    private void setLanguage(HttpServletRequest req, HttpServletResponse resp, String pageLanguage) throws ServletException, IOException {
        req.getSession().setAttribute("language", pageLanguage);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
