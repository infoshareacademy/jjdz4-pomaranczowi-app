package com.infoshareacademy.pomaranczowi.financialanalyser.servlets;

import com.infoshareacademy.pomaranczowi.financialanalyser.domain.QuotationType;
import com.infoshareacademy.pomaranczowi.financialanalyser.services.QuotationReport;
import com.infoshareacademy.pomaranczowi.financialanalyser.services.ReportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(urlPatterns = "/report")
public class ReportServlet extends HttpServlet{
    private Logger logger = LoggerFactory.getLogger(ReportServlet.class.getName());

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
        List<QuotationReport> quotationReportList = reportService.getAllQuotations();
        logger.info("User korzysta z " + reportService.getUserAgent());

        // Currency
        HashMap<String, Integer> numberOfCurrencyUse = new HashMap<>();
        List<QuotationReport> quotationReportCurrencyList = quotationReportList.stream()
                .filter(quotationReport -> quotationReport.getQuotationType() == QuotationType.CURRENCY)
                .collect(Collectors.toList());

        for (QuotationReport quotationReport: quotationReportCurrencyList) {
            if (!numberOfCurrencyUse.containsKey(quotationReport.getCode())){
                numberOfCurrencyUse.put(quotationReport.getCode(),1);
            } else{
                Integer numberOfuse = numberOfCurrencyUse.get(quotationReport.getCode());
                numberOfCurrencyUse.replace(quotationReport.getCode(),numberOfuse + 1);
            }
        }

        request.getSession().setAttribute("numberOfCurrencyUse", numberOfCurrencyUse);
        request.getSession().setAttribute("quotationReportCurrencyList", quotationReportCurrencyList);


        // Investments
        HashMap<String, Integer> numberOfInvestmentUse = new HashMap<>();
        List<QuotationReport> quotationReportInvestmentsList = quotationReportList.stream()
                .filter(quotationReport -> quotationReport.getQuotationType() == QuotationType.FUNDINVESTMENT)
                .collect(Collectors.toList());

        for (QuotationReport quotationReport: quotationReportInvestmentsList) {
            if (!numberOfInvestmentUse.containsKey(quotationReport.getCode())){
                numberOfInvestmentUse.put(quotationReport.getCode(),1);
            } else{
                Integer numberOfuse = numberOfInvestmentUse.get(quotationReport.getCode());
                numberOfInvestmentUse.replace(quotationReport.getCode(),numberOfuse + 1);
            }
        }

        request.getSession().setAttribute("numberOfInvestmentUse", numberOfInvestmentUse);
        request.getSession().setAttribute("quotationReportInvestmentsList", quotationReportInvestmentsList);

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