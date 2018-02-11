package com.infoshareacademy.pomaranczowi.financialanalyser.services;

import com.infoshareacademy.pomaranczowi.financialanalyser.domain.User;

import javax.ejb.Stateless;
import javax.servlet.ServletConfig;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

@Stateless
public class UserService {

    private ServletConfig config;

    public UserService() {
    }

    public UserService(ServletConfig config) {
        this.config = config;
    }

    public User getUserInfo(String accessToken) {

        String url = "https://"+config.getServletContext().getInitParameter("com.auth0.domain")+"/userinfo";

        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target(url);
        Response response = webTarget.request().header("Authorization","Bearer "+accessToken).get();

        return response.readEntity(User.class);
    }
}
