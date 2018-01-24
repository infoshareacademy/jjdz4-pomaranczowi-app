package com.infoshareacademy.pomaranczowi.financialanalyser.servlets;

import com.infoshareacademy.pomaranczowi.financialanalyser.dao.PriceRepositoryDao;
import com.infoshareacademy.pomaranczowi.financialanalyser.dao.QuotationRepositoryDao;
import com.infoshareacademy.pomaranczowi.financialanalyser.domain.Price;
import com.infoshareacademy.pomaranczowi.financialanalyser.domain.Quotation;
import com.infoshareacademy.pomaranczowi.financialanalyser.domain.QuotationType;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet(urlPatterns = "/addprice")
public class AddPrice extends HttpServlet {

    @EJB
    QuotationRepositoryDao quotationRepositoryDao;

    @EJB
    PriceRepositoryDao priceRepositoryDao;

    Long nextFreeQuot = 1l; //quotationRepositoryDao.getTheNextFreeQuotationId();
    Long nextFreePrice = 1l; //priceRepositoryDao.getTheNextFreePriceId();

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        addPrice(req, res);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        addPrice(req, res);
    }

    private void addPrice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        File folder = new File("/home/mateusz/projects/jjdz4-pomaranczowi-app/cli/data/currency");
        File[] listOfFiles = folder.listFiles();

        String quotationCode;

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                System.out.println("File " + listOfFiles[i].getName());

        quotationCode = listOfFiles[i].getName().substring(0, listOfFiles[i].getName().length() - 4);

        File file = listOfFiles[i];

        nextFreeQuot = quotationRepositoryDao.getTheNextFreeQuotationId();
        nextFreePrice = priceRepositoryDao.getTheNextFreePriceId();

        SaveToDatabase(file, quotationCode, nextFreeQuot, nextFreePrice);


            } else if (listOfFiles[i].isDirectory()) {
                System.out.println("Directory " + listOfFiles[i].getName());
            }
        }

    }


    private void SaveToDatabase(File file, String quotationCode, Long quotId, Long priceId) throws FileNotFoundException {
        Scanner fileScanner = new Scanner(file);

        Pattern pattern = Pattern.compile("^([A-Z]{3}),([0-9]{8}),([0-9]\\.[0-9]{4}),([0-9]\\.[0-9]{4}),([0-9]\\.[0-9]{4}),([0-9]\\.[0-9]{4}),([0-9]+.?[0-9]*)$");

        Quotation quotation = new Quotation();
        quotation.setId(quotId);
        quotation.setName(quotationCode);
        quotation.setCode(quotationCode);
        quotation.setQuotationType(QuotationType.CURRENCY);
        quotationRepositoryDao.addOrUpdateQuotation(quotation);

        try {
            while (fileScanner.hasNextLine()) {

                Matcher matcher = pattern.matcher(fileScanner.nextLine());
                if (matcher.matches()) {


                    Price price = new Price();

                    price.setId(priceId);
                    price.setDate(LocalDate.parse(matcher.group(2), formatter));
                    price.setOpen(new BigDecimal(matcher.group(3)));
                    price.setHigh(new BigDecimal(matcher.group(4)));
                    price.setLow(new BigDecimal(matcher.group(5)));
                    price.setClose(new BigDecimal(matcher.group(6)));
                    price.setVolume(new BigDecimal(matcher.group(7)));
                    price.setQuotationCode(quotation.getCode());
                    price.setQuotation(quotation);
                    priceRepositoryDao.addOrUpdatePrice(price, quotationCode);

                    System.out.println(price.toString());

                    priceId+=1;
                }
            }
        } catch (NullPointerException e) {
            System.out.println("Wystąpił błąd przy wczytywaniu pliku!");
        }
        //nextFreeQuot = quotId + 1;
        quotId+=1;
        quotationRepositoryDao.addOrUpdateQuotation(quotation);
    }
}