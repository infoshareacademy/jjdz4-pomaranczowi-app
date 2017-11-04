package com.infoshareacademy.pomaranczowi.financialanalyser;

import lombok.Setter;

public class MenuPosition {

    @Setter private String label;
    private int id;

    public MenuPosition(int id, String label) {
        this.id = id;
        this.label = label;
    }

    public void show() {
        System.out.println(getId()+") "+getLabel());
    }

    public String getLabel() {
        return label;
    }

    public int getId() {
        return id;
    }

}