package com.infoshareacademy.pomaranczowi.financialanalyser.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@WebFilter(urlPatterns = "/portal/home")
public class ErrorFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
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
            }
        } else {
            httpServletRequest.getSession().setAttribute("inputError", null);
        }
    }

    private void setLocalExtremesErrorMessage(HttpServletRequest httpServletRequest) {
        try {
            LocalDate startDate = LocalDate.parse(httpServletRequest.getParameter("startDate"), DateTimeFormatter.ISO_DATE);
            LocalDate endDate = LocalDate.parse(httpServletRequest.getParameter("endDate"), DateTimeFormatter.ISO_DATE);

            if (startDate.isAfter(endDate)) {
                httpServletRequest.getSession().setAttribute("inputError", "localExtremes.chronologyError");
            } else if (startDate.isEqual(endDate)) {
                httpServletRequest.getSession().setAttribute("inputError", "localExtremes.sameDateError");
            }
        } catch (DateTimeParseException e) {
            httpServletRequest.getSession().setAttribute("inputError", "localExtremes.noDateError");
        }
    }

    @Override
    public void destroy() {

    }
}
