package com.infoshareacademy.pomaranczowi.financialanalyser.services;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public class ReportService {

    public static final String ADDRESS = "http://127.0.0.1:8082/report/";

    public String getUserAgent() {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(ADDRESS + "agent");
        Response response = target.request().get();

        return response.toString();
    }

    public QuotationReport getQuotation(Integer id) {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(ADDRESS + "quotation" + "?id=" + id);
        Response response = target.request().get();

        QuotationReport quotationReport = response.readEntity(QuotationReport.class);

        response.close();

        if (quotationReport != null) {
            return quotationReport;
        }

        throw new IllegalArgumentException("Unkown quotation - " + quotationReport.getName() + ".");
    }

    public List<QuotationReport> getAllQuotations() {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(ADDRESS + "quotations");
        Response response = target.request().get();

        List<QuotationReport> quotationReportList = response.readEntity(getListType(QuotationReport.class));
        return quotationReportList;
    }

    private GenericType<List<QuotationReport>> getListType(final Class<QuotationReport> clazz) {
        ParameterizedType genericType = new ParameterizedType() {
            public Type[] getActualTypeArguments() {
                return new Type[]{clazz};
            }

            public Type getRawType() {
                return List.class;
            }

            public Type getOwnerType() {
                return List.class;
            }
        };
        return new GenericType<List<QuotationReport>>(genericType) {
        };
    }


    public List<QuotationReport> addQuotationToRaport(QuotationReport quotationReport) {

        String address = ADDRESS + "addquotation";


        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target(address);


        Response response = webTarget.request().post(Entity.entity(quotationReport, MediaType.APPLICATION_JSON_TYPE));

        if (response.getStatus() == 200) {
            List<QuotationReport> responseValue = response.readEntity(getListType(QuotationReport.class));
            response.close();
            return responseValue;
        } else return null; //TODO add Exception

    }
}
