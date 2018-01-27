/*
Serwlet wrzucający do bazy wartości fnduszy inwestycyjnych
 */

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
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet(urlPatterns = "/addinv")
public class AddInvestment extends HttpServlet {

    @EJB
    QuotationRepositoryDao quotationRepositoryDao;

    @EJB
    PriceRepositoryDao priceRepositoryDao;

    Long nextFreeQuot = 36l; //quotationRepositoryDao.getTheNextFreeQuotationId();
    Long nextFreePrice = 136418l; //priceRepositoryDao.getTheNextFreePriceId();
    public Map fundCodeName = new TreeMap();
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

        loadInvestmentNameFromFile("/home/mateusz/projects/jjdz4-pomaranczowi-app/cli/data/fund/omegafun.lst");


        File folderInv = new File("/home/mateusz/projects/jjdz4-pomaranczowi-app/cli/data/fund");
        File[] listOfFilesInv = folderInv.listFiles();

        String quotationCode;

        for (int i = 0; i < listOfFilesInv.length; i++) {
            if (listOfFilesInv[i].isFile() && !listOfFilesInv[i].getName().equals("omegafun.lst") && !listOfFilesInv[i].getName().equals("CZK.txt")) {
                System.out.println("File " + listOfFilesInv[i].getName());

        quotationCode = listOfFilesInv[i].getName().substring(0, listOfFilesInv[i].getName().length() - 4);

        //File fileInv = listOfFilesInv[i];

        nextFreeQuot = quotationRepositoryDao.getTheNextFreeQuotationId();
        nextFreePrice = priceRepositoryDao.getTheNextFreePriceId();

        saveToDatabase(listOfFilesInv[i], quotationCode, nextFreeQuot, nextFreePrice);
            } else if (listOfFilesInv[i].isDirectory()) {
                System.out.println("Directory " + listOfFilesInv[i].getName());
            }
        }

    }

    public void loadInvestmentNameFromFile(String filepath) {
        File fileName = new File(filepath);
        Scanner fileScanner = null;
        try {
            fileScanner = new Scanner(fileName);
        } catch (FileNotFoundException e) {
            System.out.println("\n\n\nNie znaleziono pliku: " + filepath + " zawierającego listę funduszy inwestycyjnych.");
        }

        Pattern pattern = Pattern.compile("([0-9]{4}-[0-9]{2}-[0-9]{2}) *([0-9]{2}:[0-9]{2}) *(\\d*) (\\w*) *(\\w*)(.\\w*) *(.*)");

        try {
            while (fileScanner != null && fileScanner.hasNextLine()) {
                Matcher matcher = pattern.matcher(fileScanner.nextLine());
                if (matcher.matches()) {
                    fundCodeName.put(matcher.group(5), matcher.group(7));
                }
            }
        } catch (NullPointerException exception) {
            System.out.println("Wystąpił problem z wczytaniem listy funduszy inwestycyjnych.");
        }
    }

    private void saveToDatabase(File file, String quotationCode, Long quotId, Long priceId) throws FileNotFoundException {
        //Scanner fileScanner = new Scanner(file);


        Scanner scanner = new Scanner(new FileReader(file));

        //Pattern pattern = Pattern.compile("^([A-Z]{6}),([0-9]{8}),([0-9]\\.[0-9]{4}),([0-9]\\.[0-9]{4}),([0-9]\\.[0-9]{4}),([0-9]\\.[0-9]{4}),([0-9]+.?[0-9]*)$");

        Quotation investment = new Quotation();
        investment.setId(quotId);
        investment.setName(fundCodeName.get(quotationCode).toString());
        investment.setCode(quotationCode);
        investment.setQuotationType(QuotationType.FUNDINVESTMENT);

        if (investment.getCode()!="CZK") quotationRepositoryDao.addOrUpdateQuotation(investment);

        try {
            scanner.nextLine();
            while (scanner.hasNextLine()) {

                    Price price = new Price();
                    String data[] = scanner.nextLine().split(",");
                    price.setId(priceId);
                    price.setDate(LocalDate.parse(data[1], formatter));
                    price.setOpen(new BigDecimal(data[2]));
                    price.setHigh(new BigDecimal(data[3]));
                    price.setLow(new BigDecimal(data[4]));
                    price.setClose(new BigDecimal(data[5]));
                    price.setVolume(new BigDecimal(data[6]));
                    price.setQuotationCode(investment.getCode());
                    price.setQuotation(investment);
                    priceRepositoryDao.addOrUpdatePrice(price, quotationCode);

                    //System.out.println(price.toString());

                    priceId+=1;

            }
        } catch (NullPointerException e) {
            System.out.println("Wystąpił błąd przy wczytywaniu pliku!");
        }
        //nextFreeQuot = quotId + 1;
        quotId+=1;

    }
}