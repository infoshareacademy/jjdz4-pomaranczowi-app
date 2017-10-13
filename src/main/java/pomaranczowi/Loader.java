package pomaranczowi;

import java.util.ArrayList;
import java.util.List;

class Loader {

    static  List<Quotation> getQuotationsList(String filePath) {

        QuotationCreate quotationData = new QuotationCreate();
        quotationData.loadDataFromFile("" + filePath);

        List<Quotation> quotations = new ArrayList<>();
        for (int i = 0; i < quotationData.getNumberOfQuotations(); i++) {
            quotations.add(quotationData.getQuotation(i));
        }
        return quotations;
    }

}
