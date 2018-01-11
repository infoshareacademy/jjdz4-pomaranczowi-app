package com.infoshareacademy.pomaranczowi.financialanalyser.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("form-with-steps")
public class FormWithStepsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/form-step-0.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int step = Integer.parseInt(req.getParameter("step"));
        switch (step) {
            case 1:
                dispatchToNextView(req, resp, step);
                break;
            case 2:
                dispatchToNextView(req, resp, step);
                break;
        }
    }

    private void dispatchToNextView(HttpServletRequest req, HttpServletResponse resp, int step) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/form-step-" + (step + 1) + ".jsp");
        requestDispatcher.forward(req, resp);
    }
}
