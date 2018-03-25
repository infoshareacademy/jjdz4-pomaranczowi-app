package com.infoshareacademy.pomaranczowi.financialanalyser.filters;

import com.auth0.SessionUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = {"/portal/*","/report"})
public class Auth0Filter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain next) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String accessToken = (String) SessionUtils.get(req, "accessToken");

        if (accessToken != null) {
            req.getSession().setAttribute("accessToken", accessToken);
        }

        String idToken = (String) SessionUtils.get(req, "idToken");
        if (accessToken == null && idToken == null) {
            res.sendRedirect("/login");
            return;
        }
        next.doFilter(request, response);
    }

    public void destroy() {
    }
}