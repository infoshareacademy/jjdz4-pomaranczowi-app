package com.infoshareacademy.pomaranczowi.financialanalyser.servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();

        writer.println("<!DOCTYPE html>");
        writer.println("<html>");
        writer.println("<head>");
        writer.println("</head>");
        writer.println("<body style=\"background-color: grey; font-size: 300%; text-align: center; margin-top: 50px;\">");
        writer.println("Hello orange team! <br />");
        writer.println("This is a first Servlet on our Financial Analyser web-app!"+"<br />");
        writer.println("</body>");
        writer.println("</html>");
    }
}
