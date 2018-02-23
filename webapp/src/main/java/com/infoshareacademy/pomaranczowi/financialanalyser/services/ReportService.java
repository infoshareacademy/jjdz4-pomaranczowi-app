package com.infoshareacademy.pomaranczowi.financialanalyser.services;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class ReportService {

    public static final String ADDRESS = "http://127.0.0.1:8081/web-app/";

    public String getUserAgent() {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(ADDRESS + "agent");
        Response response = target.request().get();

        return response.toString();
    }
}
