package com.infoshareacademy.pomaranczowi.financialanalyser.services;

import com.infoshareacademy.pomaranczowi.financialanalyser.domain.QuotationType;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
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

    public QuotationReport getQuotation(Integer id){
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(ADDRESS + "quotation" + "?id=" + id);
        Response response = target.request().get();

        QuotationReport quotationReport = response.readEntity(QuotationReport.class);

        response.close();

        if (quotationReport != null){
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

    //public QuotationReport addQuotationToRaport(String name, String code, QuotationType quotationType) {
    public QuotationReport addQuotationToRaport(String name, String code, QuotationType quotationType) {

        String address = ADDRESS + "addquotation";

        Form form = new Form();
        form.param("name", name);
        form.param("code", code);
        form.param("quotationType", quotationType.toString());

        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target(address);

       // String input = "{\"name\":USD,\"code\":\"USD\",\"quotationType\":\"CURRENCY\"}";


        Response response = webTarget.request().accept("co").accept(MediaType.APPLICATION_JSON_TYPE).post(Entity.form(form));
        QuotationResponse responseValue = response.readEntity(QuotationResponse.class);
        response.close();
        return responseValue.getData().get(0);



     /*   Response response = webTarget.request().post(Entity.form(form));
        QuotationReport responseValue = response.readEntity(QuotationReport.class);
        response.close();
        return responseValue;
        */


        /*if (response.getStatus() == 200) {
            TranslateResponse result = response.readEntity(TranslateResponse.class);
            response.close();

            return result.getData().getTranslations().get(0).getTranslatedText();
        } else {
            ErrorResponse result = response.readEntity(ErrorResponse.class);
            response.close();

            throw new RuntimeException(result.getError().getMessage());
        }*/
    }
}
