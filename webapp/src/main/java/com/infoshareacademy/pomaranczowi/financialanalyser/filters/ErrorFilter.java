package com.infoshareacademy.pomaranczowi.financialanalyser.filters;

import com.infoshareacademy.pomaranczowi.financialanalyser.dao.PriceRepositoryDao;
import com.infoshareacademy.pomaranczowi.financialanalyser.domain.Price;

import javax.ejb.EJB;
import javax.ejb.EJBTransactionRolledbackException;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@WebFilter(urlPatterns = "/portal/home")
public class ErrorFilter implements Filter {

    @EJB
    private PriceRepositoryDao priceRepositoryDao;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        httpServletRequest.getSession().setAttribute("action", httpServletRequest.getParameter("action"));
        try {
            setErrorMessage(httpServletRequest);
        } catch (NullPointerException e) {
            e.getMessage();
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    private void setErrorMessage(HttpServletRequest httpServletRequest) throws NullPointerException {
        if (httpServletRequest.getParameter("step").equals("3")) {

            switch (httpServletRequest.getParameter("action")) {
                case "localExtremes":
                    setLocalExtremesErrorMessage(httpServletRequest);
                    break;
                case "singleDate":
                    setSingleDateErrorMessage(httpServletRequest);
                    break;
            }
        } else {
            setNullForInputError(httpServletRequest);
        }
    }

    private void setSingleDateErrorMessage(HttpServletRequest httpServletRequest) {
        try {
            LocalDate date = LocalDate.parse(httpServletRequest.getParameter("date"), DateTimeFormatter.ISO_DATE);
            Price price = priceRepositoryDao.getPriceFromDate((String) httpServletRequest.getSession()
                    .getAttribute("code"), date);
            setNullForInputError(httpServletRequest);
        } catch (EJBTransactionRolledbackException e) {
            httpServletRequest.setAttribute("inputError", "singleDate.noQuotesError");
        } catch (DateTimeParseException e) {
            httpServletRequest.setAttribute("inputError", "singleDate.enterDateError");
        }
    }

    private void setNullForInputError(HttpServletRequest httpServletRequest) {
        httpServletRequest.getSession().setAttribute("inputError", null);
    }

    private void setLocalExtremesErrorMessage(HttpServletRequest httpServletRequest) {
        try {
            LocalDate startDate = LocalDate.parse(httpServletRequest.getParameter("startDate"), DateTimeFormatter.ISO_DATE);
            LocalDate endDate = LocalDate.parse(httpServletRequest.getParameter("endDate"), DateTimeFormatter.ISO_DATE);

            if (startDate.isAfter(endDate)) {
                httpServletRequest.getSession().setAttribute("inputError", "localExtremes.chronologyError");
            } else if (startDate.isEqual(endDate)) {
                httpServletRequest.getSession().setAttribute("inputError", "localExtremes.sameDateError");
            } else {
                setNullForInputError(httpServletRequest);
            }
        } catch (DateTimeParseException e) {
            httpServletRequest.getSession().setAttribute("inputError", "localExtremes.noDateError");
        }
    }

    @Override
    public void destroy() {

    }
}
