package com.infoshareacademy.pomaranczowi.financialanalyser.servlets;

import com.infoshareacademy.pomaranczowi.financialanalyser.dao.PriceRepositoryDao;
import com.infoshareacademy.pomaranczowi.financialanalyser.dao.QuotationRepositoryDao;
import com.infoshareacademy.pomaranczowi.financialanalyser.domain.QuotationType;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet(urlPatterns = "/portal/home")
public class HomeServlet extends HttpServlet {

    @EJB
    private QuotationRepositoryDao quotationRepositoryDao;

    @EJB
    private PriceRepositoryDao priceRepositoryDao;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/portal/home.jsp");
        request.setAttribute("step", 0);
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/portal/home.jsp");

        Integer step = Integer.valueOf(request.getParameter("step"));
        request.getSession().setAttribute("step", step);

        if (step == 1) {
            String data = request.getParameter("data");
            if (data != null) {
                request.getSession().setAttribute("data", data);
                request.getSession().setAttribute("codeList", getCodeList(data));
            }
        }

        if (step == 2) {
            String code = request.getParameter("code");
            if (code != null) {
                request.getSession().setAttribute("code", code);
                request.getSession().setAttribute("yearsList", getYearsList(code));
            }
        }

        if (step == 3) {
            if (request.getParameter("action") != null) {
                request.getSession().setAttribute("action", request.getParameter("action"));
                String code = (String) request.getSession().getAttribute("code");
                switch (request.getParameter("action")) {
                    case "globalExtremes":
                        printPricesForGlobalExtremes(request, code);
                        break;
                }
            }
        }

        requestDispatcher.forward(request, response);
    }

    private List<Integer> getYearsList(String code) {
        List<Integer> yearsList = new ArrayList<>();
        Integer minYear = priceRepositoryDao.getMinDate(code).getYear();
        Integer maxYear = priceRepositoryDao.getMaxDate(code).getYear();
        for (; minYear <= maxYear; minYear++) {
            yearsList.add(minYear);
        }
        return yearsList;
    }

    private void printPricesForGlobalExtremes(HttpServletRequest request, String code) {
        LocalDate startDate = priceRepositoryDao.getMinDate(code);
        LocalDate endDate = priceRepositoryDao.getMaxDate(code);
        request.getSession().setAttribute("startDate", startDate);
        request.getSession().setAttribute("endDate", endDate);

        request.getSession().setAttribute("maxOpen",
                priceRepositoryDao.getMaxOpenFromDateToDate(code, startDate, endDate));
        request.getSession().setAttribute("minOpen",
                priceRepositoryDao.getMinOpenFromDateToDate(code, startDate, endDate));
        request.getSession().setAttribute("maxLow",
                priceRepositoryDao.getMaxLowFromDateToDate(code, startDate, endDate));
        request.getSession().setAttribute("minLow",
                priceRepositoryDao.getMinLowFromDateToDate(code, startDate, endDate));
        request.getSession().setAttribute("maxHigh",
                priceRepositoryDao.getMaxHighFromDateToDate(code, startDate, endDate));
        request.getSession().setAttribute("minHigh",
                priceRepositoryDao.getMinHighFromDateToDate(code, startDate, endDate));
        request.getSession().setAttribute("maxClose",
                priceRepositoryDao.getMaxCloseFromDateToDate(code, startDate, endDate));
        request.getSession().setAttribute("minClose",
                priceRepositoryDao.getMinCloseFromDateToDate(code, startDate, endDate));
        /*request.getSession().setAttribute("maxVolume",
                priceRepositoryDao.getMaxVolumeFromDateToDate(code, startDate, endDate));
        request.getSession().setAttribute("minVolume",
                priceRepositoryDao.getMinVolumeFromDateToDate(code, startDate, endDate));*/
    }

    private List<String> getCodeList(String data) {
        List<String> codeList = quotationRepositoryDao
                .getAllQuotationsList(chooseQuotation(data));
        codeList.sort(String.CASE_INSENSITIVE_ORDER);
        return codeList;
    }

    private QuotationType chooseQuotation(String quotationFromUser) {
        switch (quotationFromUser) {
            case "fund":
                return QuotationType.FUNDINVESTMENT;
            case "currency":
                return QuotationType.CURRENCY;
            default:
                return null;
        }
    }
}
