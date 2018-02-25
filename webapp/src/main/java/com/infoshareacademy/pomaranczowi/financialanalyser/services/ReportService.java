package com.infoshareacademy.pomaranczowi.financialanalyser.services;

import com.infoshareacademy.pomaranczowi.financialanalyser.domain.Quotation;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import java.util.List;

public class ReportService {

    public static final String ADDRESS = "http://127.0.0.1:8081/web-app/";

    public String getUserAgent() {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(ADDRESS + "agent");
        Response response = target.request().get();

        return response.toString();
    }

    public QuotationReport getQuotation(Integer id){
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(ADDRESS + "quotation");
        Response response = target.request().get();

        QuotationReport quotationReport = response.readEntity(QuotationReport.class);

        response.close();

        if (quotationReport != null){
            return quotationReport;
        }

        throw new IllegalArgumentException("Unkown quotation - " + quotationReport.getName() + ".");
    }

    public List<Quotation> getAllQuotations() {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(ADDRESS + "quotations");
        Response response = target.request().get();

        //MultipleStatesResponse statesResponse = response.readEntity(MultipleStatesResponse.class);
        QuotationReport quotationReport = response.readEntity(QuotationReport.class);
        return null;
    }
}
