package com.infoshareacademy.pomaranczowi.financialanalyser.servlets;

import com.infoshareacademy.pomaranczowi.financialanalyser.dao.PriceRepositoryDao;
import com.infoshareacademy.pomaranczowi.financialanalyser.dao.QuotationRepositoryDao;
import com.infoshareacademy.pomaranczowi.financialanalyser.domain.Price;
import com.infoshareacademy.pomaranczowi.financialanalyser.domain.QuotationType;

import javax.ejb.EJB;
import javax.ejb.EJBTransactionRolledbackException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
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
                    case "localExtremes":
                        printPricesForLocalExtremes(request, code);
                        break;
                    case "singleDate":
                        printPricesForSingleDate(request, code);
                        break;
                    case "dataSimplification":
                        checkIfYearSelected(request, code);
                        break;
                    case "rawData":
                        request.getSession().setAttribute("prices", getPricesBetweenDates(request,code));

                        break;
                }
            }
        }

        requestDispatcher.forward(request, response);
    }

    private void checkIfYearSelected(HttpServletRequest request, String code) {
        if (request.getParameter("year").equals("")) {
            request.setAttribute("errorMessage", "Wybierz rok!");
        } else {
            printSipmlifiedPrices(request, code);
        }
    }

    private void printSipmlifiedPrices(HttpServletRequest request, String code) {
        Integer month = Integer.valueOf(request.getParameter("month"));
        Integer year = Integer.valueOf(request.getParameter("year"));
        LocalDate startDate;
        LocalDate endDate;
        if (month.equals(0)) {
            startDate = Year.of(year).atDay(1);
            endDate = Year.of(year).atMonth(12).atEndOfMonth();
        } else {
            startDate = YearMonth.of(year, month).atDay(1);
            endDate = YearMonth.of(year, month).atEndOfMonth();
        }
        request.getSession().setAttribute("startDate", startDate);
        request.getSession().setAttribute("endDate", endDate);
        printMinMaxValues(request, code, startDate, endDate);
    }

    private void printPricesForSingleDate(HttpServletRequest request, String code) {
        try {
            LocalDate date = LocalDate.parse(request.getParameter("date"), DateTimeFormatter.ISO_DATE);
            request.getSession().setAttribute("date", date);
            Price price = priceRepositoryDao.getPriceFromDate(code, date);
            request.getSession().setAttribute("Open", price.getOpen());
            request.getSession().setAttribute("Low", price.getLow());
            request.getSession().setAttribute("High", price.getHigh());
            request.getSession().setAttribute("Close", price.getClose());
        } catch (EJBTransactionRolledbackException e) {
            request.setAttribute("dateError", "Nie ma notowań dla powyższej daty!");
        } catch (DateTimeParseException e) {
            request.setAttribute("dateError", "Podaj datę!");
            request.getSession().setAttribute("date", "\"brak daty\"");
        }
    }

    private void printPricesForLocalExtremes(HttpServletRequest request, String code) {
        try {
            LocalDate startDate = LocalDate.parse(request.getParameter("startDate"), DateTimeFormatter.ISO_DATE);
            LocalDate endDate = LocalDate.parse(request.getParameter("endDate"), DateTimeFormatter.ISO_DATE);
            if (startDate.isBefore(endDate)) {
                request.getSession().setAttribute("startDate", startDate);
                request.getSession().setAttribute("endDate", endDate);
                printMinMaxValues(request, code, startDate, endDate);
            } else if (startDate.isAfter(endDate)) {
                request.setAttribute("dateLogicError", "Błąd chronologii dat!");
            } else {
                request.setAttribute("dateLogicError", "Wybierz opcję: Wartości z danego dnia!");
            }
        } catch (DateTimeParseException e) {
            request.setAttribute("dateLogicError", "Podaj daty!");
        }
    }



    private List<Price> getPricesBetweenDates(HttpServletRequest request, String code){
        try {
            LocalDate startDate = LocalDate.parse(request.getParameter("startDate"), DateTimeFormatter.ISO_DATE);
            LocalDate endDate = LocalDate.parse(request.getParameter("endDate"), DateTimeFormatter.ISO_DATE);
            if (startDate.isBefore(endDate)) {
                request.getSession().setAttribute("startDate", startDate);
                request.getSession().setAttribute("endDate", endDate);
                List<Price> pricesBetweenDates = priceRepositoryDao.getPricesFromDateToDate(code,startDate,endDate);
                return pricesBetweenDates;
            } else if (startDate.isAfter(endDate)) {
                request.setAttribute("dateLogicError", "Błąd chronologii dat!");
            } else {
                request.setAttribute("dateLogicError", "Wybierz opcję: Wartości z danego dnia!");
            }
        } catch (DateTimeParseException e) {
            request.setAttribute("dateLogicError", "Podaj daty!");
        }

        return null;
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
        printMinMaxValues(request, code, startDate, endDate);
    }

    private void printMinMaxValues(HttpServletRequest request, String code, LocalDate startDate, LocalDate endDate) {
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
