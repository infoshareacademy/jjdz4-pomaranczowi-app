package com.infoshareacademy.pomaranczowi.financialanalyser.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/portal/home")
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/portal/home.jsp");
        request.setAttribute("step",0);
        requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/portal/home.jsp");

        Integer step = Integer.valueOf(request.getParameter("step"));
        request.getSession().setAttribute("step",step);

        if (step == 1) {
            if (request.getParameter("data") != null) {
                request.getSession().setAttribute("data", request.getParameter("data"));
            }
        }

        if (step == 2) {
            if (request.getParameter("code") != null) {
                request.getSession().setAttribute("code", request.getParameter("code"));
            }
        }

        if (step == 3) {
            if (request.getParameter("action") != null) {
                request.getSession().setAttribute("action", request.getParameter("action"));
            }
        }

        requestDispatcher.forward(request,response);
    }
}
