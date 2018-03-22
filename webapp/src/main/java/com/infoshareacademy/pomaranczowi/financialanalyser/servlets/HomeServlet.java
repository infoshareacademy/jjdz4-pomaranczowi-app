package com.infoshareacademy.pomaranczowi.financialanalyser.servlets;

import com.infoshareacademy.pomaranczowi.financialanalyser.dao.PriceRepositoryDao;
import com.infoshareacademy.pomaranczowi.financialanalyser.dao.QuotationRepositoryDao;
import com.infoshareacademy.pomaranczowi.financialanalyser.domain.MinMaxPrice;
import com.infoshareacademy.pomaranczowi.financialanalyser.domain.Price;
import com.infoshareacademy.pomaranczowi.financialanalyser.domain.QuotationType;
import com.infoshareacademy.pomaranczowi.financialanalyser.domain.User;
import com.infoshareacademy.pomaranczowi.financialanalyser.services.UserService;
import com.infoshareacademy.pomaranczowi.financialanalyser.services.UserServiceImpl;

import javax.ejb.EJB;
import javax.ejb.EJBTransactionRolledbackException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.stream.DoubleStream;

@WebServlet(urlPatterns = "/portal/home")
public class HomeServlet extends HttpServlet {

    @EJB
    private QuotationRepositoryDao quotationRepositoryDao;

    @EJB
    private PriceRepositoryDao priceRepositoryDao;

    @EJB
    private UserService userService;

    private User user;

    private ServletConfig config;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.config = config;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        changeLanguage(request);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/portal/home.jsp");
        setStepIfEmpty(request);
        HttpSession session = request.getSession(true);
        session.setAttribute("user", userService.getUserInfo(config, (String) session.getAttribute("accessToken")));
        requestDispatcher.forward(request, response);
        doPost(request, response);
    }

    private void setStepIfEmpty(HttpServletRequest request) {
        if (request.getSession().getAttribute("step") == null) {
            request.getSession().setAttribute("step", 0);
        }
    }

    private void changeLanguage(HttpServletRequest request) {
        String pageLanguage = request.getParameter("lang");
        if (pageLanguage != null) {
            request.getSession().setAttribute("language", pageLanguage);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/portal/home.jsp");

        Integer step = setStep(request);

        if (step == 1) {
            String data = request.getParameter("data");
            if (data != null) {
                request.getSession().setAttribute("data", data);
                request.getSession().setAttribute("codeList", quotationRepositoryDao.getCodeList(data));
                setChooseCodeMessage(request, data);
            }
        }

        if (step == 2) {
            String code = request.getParameter("code");
            if (code != null) {
                request.getSession().setAttribute("code", code);
                request.getSession().setAttribute("yearsList", priceRepositoryDao.getYearsList(code));
            }
        }

        if (step == 3) {
            if (request.getParameter("action") != null) {
                request.getSession().setAttribute("action", request.getParameter("action"));
                String code = (String) request.getSession().getAttribute("code");
                String data = (String) request.getSession().getAttribute("data");
                Boolean toConversion1 = request.getParameter("toConversion") == null ? false : true;
                switch (request.getParameter("action")) {
                    case "globalExtremes":
                        setGlobalExtremesMessage(request, data);
                        printPricesForGlobalExtremes(request, code);
                        break;
                    case "localExtremes":
                        setLocalExtremesMessage(request, data);
                        printPricesForLocalExtremes(request, code);
                        break;
                    case "singleDate":
                        setSingleDateMessage(request, data);
                        printPricesForSingleDate(request, code);
                        break;
                    case "dataSimplification":
                        setDataSimplificationMessage(request, data);
                        printSipmlifiedPrices(request, code);
                        break;
                    case "rawData":
                        request.getSession().setAttribute("toConversion", toConversion1);
                        request.getSession().setAttribute("conversion", request.getParameter("conversion"));
                        if (toConversion1) {
                            switch (request.getParameter("conversion")) {
                                case "SMA":
                                    request.getSession().setAttribute("prices", getPricesBetweenDatesSMA(request, code));
                                    break;
                            }
                        } else {
                            request.getSession().setAttribute("prices", getPricesBetweenDates(request, code));
                        }
                        break;
                }
            }
        }

        requestDispatcher.forward(request, response);
    }

    private Integer setStep(HttpServletRequest request) {
        if (request.getSession().getAttribute("inputError") == null) {
            Integer step = Integer.valueOf(request.getParameter("step"));
            request.getSession().setAttribute("step", step);
            return step;
        } else {
            return (Integer) request.getSession().getAttribute("step");
        }
    }

    private void setDataSimplificationMessage(HttpServletRequest request, String data) {
        if (data.equals("fund")) {
            request.getSession().setAttribute("dataSimplificationMessage", "dataSimplification.fundMessage");
        } else {
            request.getSession().setAttribute("dataSimplificationMessage", "dataSimplification.currencyMessage");
        }
    }

    private void setSingleDateMessage(HttpServletRequest request, String data) {
        if (data.equals("fund")) {
            request.getSession().setAttribute("singleDateDayMessage", "singleDate.dayMessage");
            request.getSession().setAttribute("singleDateDataMessage", "singleDate.fundMessage");
        } else {
            request.getSession().setAttribute("singleDateDayMessage", "singleDate.dayMessage");
            request.getSession().setAttribute("singleDateDataMessage", "singleDate.currencyMessage");
        }
    }

    private void setLocalExtremesMessage(HttpServletRequest request, String data) {
        if (data.equals("fund")) {
            request.getSession().setAttribute("localExtremesMessage", "localExtremes.fundMessage");
        } else {
            request.getSession().setAttribute("localExtremesMessage", "localExtremes.currencyMessage");
        }
    }

    private void setGlobalExtremesMessage(HttpServletRequest request, String data) {
        if (data.equals("fund")) {
            request.getSession().setAttribute("globalExtremesMessage", "globalExtremes.fundMessage");
        } else {
            request.getSession().setAttribute("globalExtremesMessage", "globalExtremes.currencyMessage");
        }
    }

    private void setChooseCodeMessage(HttpServletRequest request, String data) {
        if (data.equals("fund")) {
            request.getSession().setAttribute("chooseCodeMessage", "chooseCode.fund");
        } else {
            request.getSession().setAttribute("chooseCodeMessage", "chooseCode.currency");
        }
    }

    private void printSipmlifiedPrices(HttpServletRequest request, String code) {
        Integer month = Integer.valueOf(request.getParameter("month"));
        Integer year = Integer.valueOf(request.getParameter("year"));
        LocalDate startDate;
        LocalDate endDate;
        if (year.equals(0)) {
            List<Integer> yearsList = priceRepositoryDao.getYearsList(code);
            startDate = Year.of(yearsList.get(0)).atDay(1);
            endDate = Year.of(yearsList.get(yearsList.size() - 1)).atMonth(12).atEndOfMonth();
            List<MinMaxPrice> minMaxPriceList = new ArrayList<>();
            setMinMaxValuesForAllYears(code, yearsList, minMaxPriceList);
            request.getSession().setAttribute("yearsPriceList", minMaxPriceList);
        } else if (month.equals(0)) {
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

    private void setMinMaxValuesForAllYears(String code, List<Integer> yearsList, List<MinMaxPrice> minMaxPriceList) {
        for (Integer localYear : yearsList) {
            LocalDate yearStartDate = Year.of(localYear).atDay(1);
            LocalDate yearEndDate = Year.of(localYear).atMonth(12).atEndOfMonth();
            MinMaxPrice yearPrice = new MinMaxPrice();
            yearPrice.setMaxOpen(priceRepositoryDao.getMaxOpenFromDateToDate(code, yearStartDate, yearEndDate));
            yearPrice.setMinOpen(priceRepositoryDao.getMaxOpenFromDateToDate(code, yearStartDate, yearEndDate));
            yearPrice.setMaxClose(priceRepositoryDao.getMaxOpenFromDateToDate(code, yearStartDate, yearEndDate));
            yearPrice.setMinClose(priceRepositoryDao.getMaxOpenFromDateToDate(code, yearStartDate, yearEndDate));
            yearPrice.setMaxHigh(priceRepositoryDao.getMaxOpenFromDateToDate(code, yearStartDate, yearEndDate));
            yearPrice.setMinHigh(priceRepositoryDao.getMaxOpenFromDateToDate(code, yearStartDate, yearEndDate));
            yearPrice.setMaxLow(priceRepositoryDao.getMaxOpenFromDateToDate(code, yearStartDate, yearEndDate));
            yearPrice.setMinLow(priceRepositoryDao.getMaxOpenFromDateToDate(code, yearStartDate, yearEndDate));
            yearPrice.setPeriod(localYear);
            minMaxPriceList.add(yearPrice);
        }
    }

    private void printPricesForSingleDate(HttpServletRequest request, String code) {
        LocalDate date = LocalDate.parse(request.getParameter("date"), DateTimeFormatter.ISO_DATE);
        request.getSession().setAttribute("date", date);
        Price price = priceRepositoryDao.getPriceFromDate(code, date);
        request.getSession().setAttribute("Open", price.getOpen());
        request.getSession().setAttribute("Low", price.getLow());
        request.getSession().setAttribute("High", price.getHigh());
        request.getSession().setAttribute("Close", price.getClose());
    }

    private void printPricesForLocalExtremes(HttpServletRequest request, String code) {
        LocalDate startDate = LocalDate.parse(request.getParameter("startDate"), DateTimeFormatter.ISO_DATE);
        LocalDate endDate = LocalDate.parse(request.getParameter("endDate"), DateTimeFormatter.ISO_DATE);
        request.getSession().setAttribute("startDate", startDate);
        request.getSession().setAttribute("endDate", endDate);
        printMinMaxValues(request, code, startDate, endDate);
    }

    private List<Price> getPricesBetweenDates(HttpServletRequest request, String code) {
        try {
            LocalDate startDate = LocalDate.parse(request.getParameter("startDate"), DateTimeFormatter.ISO_DATE);
            LocalDate endDate = LocalDate.parse(request.getParameter("endDate"), DateTimeFormatter.ISO_DATE);
            if (startDate.isBefore(endDate)) {
                request.getSession().setAttribute("startDate", startDate);
                request.getSession().setAttribute("endDate", endDate);
                List<Price> pricesBetweenDates = priceRepositoryDao.getPricesFromDateToDate(code, startDate, endDate);
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

    private List<Price> getPricesBetweenDatesSMA(HttpServletRequest request, String code) {
        try {
            LocalDate startDate = LocalDate.parse(request.getParameter("startDate"), DateTimeFormatter.ISO_DATE);
            LocalDate endDate = LocalDate.parse(request.getParameter("endDate"), DateTimeFormatter.ISO_DATE);
            int period = Integer.valueOf(request.getParameter("period"));
            int i = 1;
            ArrayList<BigDecimal> tmpOpen = new ArrayList<>();
            ArrayList<BigDecimal> tmpLow = new ArrayList<>();
            ArrayList<BigDecimal> tmpClose = new ArrayList<>();
            ArrayList<BigDecimal> tmpHigh = new ArrayList<>();
            ArrayList<BigDecimal> tmpVolume = new ArrayList<>();

            if (startDate.isBefore(endDate)) {
                request.getSession().setAttribute("startDate", startDate);
                request.getSession().setAttribute("endDate", endDate);
                request.getSession().setAttribute("period", period);

                List<Price> pricesBetweenDates = priceRepositoryDao.getPricesFromDateToDate(code, startDate, endDate);
                List<Price> pricesBetweenDatesSMA = new ArrayList<>();


                for (Price loopPrice : pricesBetweenDates) {
                    tmpOpen.add(loopPrice.getOpen());
                    tmpLow.add(loopPrice.getLow());
                    tmpHigh.add(loopPrice.getHigh());
                    tmpClose.add(loopPrice.getClose());
                    tmpVolume.add(loopPrice.getVolume());

                    if (i >= period) {
                        Price tmpPrice = new Price();
                        tmpPrice.setDate(loopPrice.getDate());
                        tmpPrice.setOpen((tmpOpen.stream().reduce(BigDecimal.ZERO, BigDecimal::add)).divide(BigDecimal.valueOf(period)));
                        tmpOpen.remove(0);
                        tmpPrice.setLow((tmpLow.stream().reduce(BigDecimal.ZERO, BigDecimal::add)).divide(BigDecimal.valueOf(period)));
                        tmpLow.remove(0);
                        tmpPrice.setClose((tmpClose.stream().reduce(BigDecimal.ZERO, BigDecimal::add)).divide(BigDecimal.valueOf(period)));
                        tmpClose.remove(0);
                        tmpPrice.setHigh((tmpHigh.stream().reduce(BigDecimal.ZERO, BigDecimal::add)).divide(BigDecimal.valueOf(period)));
                        tmpHigh.remove(0);
                        tmpPrice.setVolume((tmpVolume.stream().reduce(BigDecimal.ZERO, BigDecimal::add)).divide(BigDecimal.valueOf(period)));
                        tmpVolume.remove(0);
                        pricesBetweenDatesSMA.add(tmpPrice);
                    }
                    i++;
                }

/*
                Price a = new Price();
                a.setDate(LocalDate.parse("2018-01-01",DateTimeFormatter.ISO_DATE));
                a.setLow(BigDecimal.valueOf(1));
                a.setClose(BigDecimal.valueOf(2));
                a.setHigh(BigDecimal.valueOf(3));
                a.setOpen(BigDecimal.valueOf(4));
                a.setVolume(BigDecimal.valueOf(5));
                pricesBetweenDatesSMA.add(a);
*/


                return pricesBetweenDatesSMA;
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
    }


}
