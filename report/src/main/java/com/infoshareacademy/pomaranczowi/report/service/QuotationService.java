package com.infoshareacademy.pomaranczowi.report.service;

import com.infoshareacademy.pomaranczowi.report.model.Quotation;
import com.infoshareacademy.pomaranczowi.report.repository.QuotationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.Collection;

@Path("/")
public class QuotationService {

    private Logger LOG = LoggerFactory.getLogger(QuotationService.class);

    @Context
    private UriInfo uriInfo;

    @EJB
    QuotationRepository quotationRepository;

    public QuotationService() {
    }

    @GET
    @Path("/agent")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getUserAgent(@HeaderParam("user-agent") String userAgent) {
        LOG.info("User agent: {}", userAgent.toString());

        return Response.ok(userAgent).build();
    }

    @GET
    @Path("/quotations")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getQuotations() {

        Collection<Quotation> quotations = quotationRepository.getAllQuotationsList();
        if (quotations.isEmpty()) {
            return Response.noContent().build();
        }

        return Response.ok(quotations).build();
    }


    @POST
    @Path("/addquotation")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addQuotation(Quotation quotation) {

        Integer newId = quotationRepository.getTheNextFreeQuotationId();
        LOG.info("New ID: {}", newId);

        Quotation quotation1 = new Quotation(newId,
                quotation.getName(),
                quotation.getCode(),
                quotation.getQuotationType());

        quotationRepository.addOrUpdateQuotation(quotation1);

        return getQuotations();
    }

}
