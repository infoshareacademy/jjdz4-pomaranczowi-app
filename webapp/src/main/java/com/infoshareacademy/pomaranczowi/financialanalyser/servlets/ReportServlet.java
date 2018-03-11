package com.infoshareacademy.pomaranczowi.financialanalyser.servlets;

import com.infoshareacademy.pomaranczowi.financialanalyser.services.QuotationReport;
import com.infoshareacademy.pomaranczowi.financialanalyser.services.ReportService;

import javax.servlet.RequestDispatcher;
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
    public void doGet(HttpServletRequest request, HttpServletResponse res) throws IOException, ServletException {
        getReports(request,res);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse res) throws IOException, ServletException {
        getReports(request,res);
    }

    private void getReports(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {

        ReportService reportService = new ReportService();
        String fromAPI = reportService.getUserAgent();
        System.out.println(fromAPI);

        /*req.setAttribute("agent", fromAPI.toString());
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/portal/agent.jsp");
        requestDispatcher.forward(req, resp);*/

        ReportService reportService1 = new ReportService();
        List<QuotationReport> quotationReportList = reportService1.getAllQuotations();
        quotationReportList.stream().forEach(quotationReport -> System.out.println(quotationReport));

        ReportService reportService2 = new ReportService();
        QuotationReport quotationReport = reportService2.getQuotation(1);
        System.out.println("Quot" + quotationReport.toString());


        request.getSession().setAttribute("name", quotationReport.getName());
        request.getSession().setAttribute("code", quotationReport.getCode());
        request.getSession().setAttribute("quotationType", quotationReport.getQuotationType());

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("portal/report/report-page.jsp");
        requestDispatcher.forward(request,resp);
    }
}