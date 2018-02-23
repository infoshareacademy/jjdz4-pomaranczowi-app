package com.infoshareacademy.pomaranczowi.financialanalyser.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Singleton;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Singleton
public class QuotationStore {

    private Logger LOG = LoggerFactory.getLogger(QuotationStore.class);

    private Map<Long, Quotation> base;

    public Map<Long, Quotation> getBase() {
        return base;
    }

    public QuotationStore(){
        base = new HashMap<Long, Quotation>();

        Quotation quotation1 = new Quotation(1l,"PZU Akcji Krakowiak", "PZU001", QuotationType.FUNDINVESTMENT);
        Quotation quotation2 = new Quotation(2l,"EURO", "EURO", QuotationType.CURRENCY);

        base.put(1l,quotation1);
        base.put(2l,quotation2);
    }

    public long getNewId() {
        return  base.keySet().stream()
                .mapToLong(i -> i)
                .max().orElse(0) + 1;
    }

    public void add(Quotation quotation) {
        LOG.info("Adding to store: " + quotation.toString());
        base.put(quotation.getId(), quotation);
    }

    public Optional<Quotation> findById(Long id) {
        return Optional.ofNullable(base.get(id));
    }
}
