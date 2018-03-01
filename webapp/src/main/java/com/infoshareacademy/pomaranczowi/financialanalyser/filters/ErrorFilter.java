package com.infoshareacademy.pomaranczowi.financialanalyser.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebFilter(urlPatterns = "/portal/home")
public class ErrorFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        try {
            if (servletRequest.getParameter("step").equals("3")) {
                LocalDate startDate = LocalDate.parse(servletRequest.getParameter("startDate"), DateTimeFormatter.ISO_DATE);
                LocalDate endDate = LocalDate.parse(servletRequest.getParameter("endDate"), DateTimeFormatter.ISO_DATE);

                if (startDate.isAfter(endDate)) {
                    httpServletRequest.getSession().setAttribute("inputError", "localExtremes.chronologyError");
                    //System.out.println(httpServletRequest.getParameter("action"));
                }
            }
        } catch (NullPointerException e) {
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
