package com.infoshareacademy.pomaranczowi.financialanalyser.servlets;

import com.infoshareacademy.pomaranczowi.financialanalyser.domain.QuotationType;
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
import java.util.stream.Collectors;

@WebServlet(urlPatterns = "/report")
public class ReportServlet extends HttpServlet{

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse res) throws IOException, ServletException {
        changeLanguage(request);
        getReports(request,res);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse res) throws IOException, ServletException {
        changeLanguage(request);
        getReports(request,res);
    }

    private void getReports(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {

        ReportService reportService = new ReportService();
        String fromAPI = reportService.getUserAgent();
        System.out.println(fromAPI);

       // ReportService reportServicePost = new ReportService();
        /*ReportService reportService2 = new ReportService();
        QuotationReport quotationReport = reportService2.getQuotation(1);
        System.out.println("Quot" + quotationReport.toString());*/

        ReportService reportService1 = new ReportService();
        List<QuotationReport> quotationReportList = reportService1.getAllQuotations();
        quotationReportList = quotationReportList.stream()
                .filter(quotationReport -> quotationReport.getQuotationType() == QuotationType.CURRENCY)
                .collect(Collectors.toList());

        request.getSession().setAttribute("quotationReportList", quotationReportList);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("portal/report/report-page.jsp");
        requestDispatcher.forward(request,resp);
    }

    private void changeLanguage(HttpServletRequest request) {
        String pageLanguage = request.getParameter("lang");
        if (pageLanguage != null) {
            request.getSession().setAttribute("language", pageLanguage);
        }
    }
}