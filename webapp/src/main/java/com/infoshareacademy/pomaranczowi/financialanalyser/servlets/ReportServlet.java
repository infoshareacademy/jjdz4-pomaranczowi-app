package com.infoshareacademy.pomaranczowi.financialanalyser.servlets;

import com.infoshareacademy.pomaranczowi.financialanalyser.services.QuotationReport;
import com.infoshareacademy.pomaranczowi.financialanalyser.services.ReportService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/report")
public class ReportServlet extends HttpServlet{

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        getReports(req,res);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        getReports(req,res);
    }

    private void getReports(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ReportService reportService = new ReportService();
        String fromAPI = reportService.getUserAgent();
        System.out.println(fromAPI);

        /*req.setAttribute("agent", fromAPI.toString());
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/portal/agent.jsp");
        requestDispatcher.forward(req, resp);*/

        ReportService reportService1 = new ReportService();
        List<QuotationReport> quotationReportList = reportService1.getAllQuotations();
        quotationReportList.stream().forEach(quotationReport -> System.out.println(quotationReport));

    }
}