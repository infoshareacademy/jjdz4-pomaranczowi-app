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

   // @Inject
   // private QuotationStore quotationStore;

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

        //Collection<Quotation> quotations = quotationStore.getBase().values();
        Collection<Quotation> quotations = quotationRepository.getAllQuotationsList();
        if (quotations.isEmpty()) {
            return Response.noContent().build();
        }

        return Response.ok(quotations).build();
    }

   /* @GET
    @Path("/quotation")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getQuotation(@QueryParam("id") Integer id) {
        Optional<Quotation> quotation = quotationStore.findById(id);
        if (quotation.isPresent()) {
            return Response.ok(quotation.get()).build();
        }

        return Response.status(Response.Status.NOT_FOUND).build();
    }*/

    @POST
    @Path("/addquotation")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addQuotation(Quotation quotation) {



        //Integer newId = quotationStore.getNewId();
        Integer newId = quotationRepository.getTheNextFreeQuotationId();
        LOG.info("New ID: {}", newId);
        //TODO ustawić query na następny numer

        Quotation quotation1 = new Quotation(newId, //quotationRepository.getTheNextFreeQuotationId(),
                quotation.getName(),
                quotation.getCode(),
                quotation.getQuotationType());
        /*Quotation quotation1 = new Quotation();
        quotation1.setId(quotationRepository.getTheNextFreeQuotationId());
        quotation1.setName(quotation.getName());
        quotation1.setCode(quotation.getCode());
        quotation1.setQuotationType(quotation.getQuotationType());*/

        //quotationStore.add(quotation1);
        quotationRepository.addOrUpdateQuotation(quotation1);

        return getQuotations();
    }

}
