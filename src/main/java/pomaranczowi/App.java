package pomaranczowi;

import java.time.LocalDate;


public class App
{
    public static void main( String[] args ) {

        //private static final String DATE_FORMAT = "yyyyMMdd";
        //private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);

        //Currency class example of use
        Currency aud = new Currency("data/currency/AUD.txt");
        String date = "20160414";
        System.out.println("Wczytano notowania dla "+aud.countPrices()+" dni.");
        System.out.println("Data pierwszego wczytanego notowania to: "+aud.firstDate());
        System.out.println("Data ostatniego wczytanego notowania to: "+aud.lastDate()+"\n");
        System.out.println("Wartość open dla notowania z dnia "+date+" wynosi: "+aud.getOpen(date));
        System.out.println("Wartość high dla notowania z dnia "+date+" wynosi: "+aud.getHigh(date));
        System.out.println("Wartość low dla notowania z dnia "+date+" wynosi: "+aud.getLow(date));
        System.out.println("Wartość close dla notowania z dnia "+date+" wynosi: "+aud.getClose(date));

        /*//FoundInvestment class example of use
        FundInvestment pzu001 = new FundInvestment("data/fund/PZU001.txt");
        String fundDate = "20160414";
        System.out.println("Wczytano notowania dla "+pzu001.countPrices()+" dni.");
        System.out.println("Data pierwszego wczytanego notowania to: "+pzu001.firstDate());
        System.out.println("Data ostatniego wczytanego notowania to: "+pzu001.lastDate()+"\n");
        System.out.println("Wartość open dla notowania z dnia "+fundDate+" wynosi: "+pzu001.getOpen(fundDate));
        System.out.println("Wartość high dla notowania z dnia "+fundDate+" wynosi: "+pzu001.getHigh(fundDate));
        System.out.println("Wartość low dla notowania z dnia "+fundDate+" wynosi: "+pzu001.getLow(fundDate));
        System.out.println("Wartość close dla notowania z dnia "+fundDate+" wynosi: "+pzu001.getClose(fundDate));*/


        System.out.printf("\n\n\nInne podejście:\n");
        /*QuotationCreate quotationCreate = new QuotationCreate();
        quotationCreate.loadDataFromFile("data/fund/PZU001.txt");
        int numberOfQuotations = quotationCreate.getNumberOfQuotations();
        System.out.printf("\nLiczba Quotations: " + numberOfQuotations);*/

        Loader loader = new Loader();

        //Investment investment = new Investment(1,"Krakowiak", loader.getQuotationsList("data/fund/PZU001.txt"));

        //System.out.printf("\nName: " + investment.getName());
        System.out.println(loader.getQuotationsList("data/fund/PZU002.txt").get(3).getName());
        Investment investment = new Investment(Loader.getQuotationsList("data/fund/PZU002.txt").get(0).getName(), Loader.getQuotationsList("data/fund/PZU002.txt"));

        System.out.println(investment.getName());
        System.out.println(Loader.getQuotationsList("data/fund/PZU002.txt").size());

        LocalDate localDateAfter = LocalDate.of(2017,02,28);
        LocalDate localDateBefore = LocalDate.of(2017,04,01);


        //public List<Quotation> quotations = new ArrayList<>();
        System.out.println("Marzec: ");
        for (Quotation quotation : investment.getQuotations()){
            if (quotation.getDate().isAfter(localDateAfter) && quotation.getDate().isBefore(localDateBefore)) {
                System.out.printf(quotation.getDate()+ " ");
            }
        }
    }
}
