/*

Servlet do testów bazy - zostanie usunięty

 */


package com.infoshareacademy.pomaranczowi.financialanalyser.servlets;

import com.infoshareacademy.pomaranczowi.financialanalyser.dao.PriceRepositoryDao;
import com.infoshareacademy.pomaranczowi.financialanalyser.dao.QuotationRepositoryDao;
import com.infoshareacademy.pomaranczowi.financialanalyser.domain.Price;
import com.infoshareacademy.pomaranczowi.financialanalyser.domain.Quotation;
import com.infoshareacademy.pomaranczowi.financialanalyser.domain.QuotationType;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@WebServlet(urlPatterns = "/price")
public class QuotAndPriceServlet extends HttpServlet {

    @EJB
    QuotationRepositoryDao quotationRepositoryDao;

    @EJB
    PriceRepositoryDao priceRepositoryDao;

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        addQuotation(req,res);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        addQuotation(req,res);
    }

    private void addQuotation(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        Price price = new Price();
        price.setId(1l);
        price.setClose(BigDecimal.valueOf(34.45));
        price.setDate(LocalDate.now());
        price.setHigh(BigDecimal.valueOf(35.78));
        price.setLow(BigDecimal.valueOf(34.78));
        price.setLow(BigDecimal.valueOf(35.23));
        price.setOpen(BigDecimal.valueOf(34.89));
        price.setVolume(BigDecimal.valueOf(0));
        priceRepositoryDao.addOrUpdatePrice(price);

        Price price2 = new Price();
        price2.setId(2l);
        price2.setClose(BigDecimal.valueOf(54.67));
        price2.setDate(LocalDate.now());
        price2.setHigh(BigDecimal.valueOf(54.09));
        price2.setLow(BigDecimal.valueOf(54.24));
        price2.setLow(BigDecimal.valueOf(54.17));
        price2.setOpen(BigDecimal.valueOf(54.58));
        price2.setVolume(BigDecimal.valueOf(0));
        priceRepositoryDao.addOrUpdatePrice(price2);

        Price price3 = new Price();
        price3.setId(3l);
        price3.setClose(BigDecimal.valueOf(23.67));
        price3.setDate(LocalDate.now());
        price3.setHigh(BigDecimal.valueOf(23.09));
        price3.setLow(BigDecimal.valueOf(23.24));
        price3.setLow(BigDecimal.valueOf(23.17));
        price3.setOpen(BigDecimal.valueOf(23.58));
        price3.setVolume(BigDecimal.valueOf(0));
        priceRepositoryDao.addOrUpdatePrice(price3);

        List<Price> priceList = new ArrayList<>();
        priceList.add(price);
        List<Price> priceList2 = new ArrayList<>();
        priceList2.add(price2);

        Quotation quotation = new Quotation();
        quotation.setId(1l);
        quotation.setName("Fundusz INVEST PRO");
        quotation.setPrices(priceList);
        quotation.setCode("INV001");
        quotation.setQuotationType(QuotationType.FUNDINVESTMENT);
        quotationRepositoryDao.addOrUpdateQuotation(quotation);

        Quotation quotation2 = new Quotation();
        quotation2.setId(2l);
        quotation2.setName("Fundusz Akcjki Krakowiak PZU");
        quotation2.setPrices(priceList2);
        quotation2.setCode("PZU001");
        quotation2.setQuotationType(QuotationType.CURRENCY);
        quotation2.setQuotationType(QuotationType.valueOf("CURRENCY"));
        quotationRepositoryDao.addOrUpdateQuotation(quotation2);

        List<Price> priceList3 = new ArrayList<>();
        priceList3.add(price3);
        quotation2.setPrices(priceList2);
        //quotationRepositoryDao.addPriceToQuotation(2l, priceList3);
        quotationRepositoryDao.addOrUpdateQuotation(quotation2);

        Price price4 = new Price();
        price4.setId(4l);
        price4.setClose(BigDecimal.valueOf(23.67));
        price4.setDate(LocalDate.now());
        price4.setHigh(BigDecimal.valueOf(23.09));
        price4.setLow(BigDecimal.valueOf(23.24));
        price4.setLow(BigDecimal.valueOf(23.17));
        price4.setOpen(BigDecimal.valueOf(23.58));
        price4.setVolume(BigDecimal.valueOf(0));
        priceRepositoryDao.addOrUpdatePrice(price4);

        Price price5 = new Price();
        price5.setId(5l);
        price5.setClose(BigDecimal.valueOf(23.67));
        price5.setDate(LocalDate.now());
        price5.setHigh(BigDecimal.valueOf(23.09));
        price5.setLow(BigDecimal.valueOf(23.24));
        price5.setLow(BigDecimal.valueOf(23.17));
        price5.setOpen(BigDecimal.valueOf(23.58));
        price5.setVolume(BigDecimal.valueOf(0));
        priceRepositoryDao.addOrUpdatePrice(price5);

        List<Price> priceList45 = new ArrayList<>();
        priceList45.add(price4);
        priceList45.add(price5);

        List<Price> newList345 = Stream.of(priceList3,priceList45)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        quotation2.setPrices(newList345);
        quotationRepositoryDao.addOrUpdateQuotation(quotation2);

        List<Price> newList12 = Stream.of(priceList,priceList2)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        quotation.setPrices(newList12);
        quotationRepositoryDao.addOrUpdateQuotation(quotation);

        List<Price> priceListFromDate = priceRepositoryDao.getPricesFromDate("PZU001", LocalDate.now());
        for(Price priceFor : priceListFromDate) System.out.println("Price open: " + priceFor.getOpen());

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/analysis.jsp");
        requestDispatcher.forward(req, resp);
    }
}
