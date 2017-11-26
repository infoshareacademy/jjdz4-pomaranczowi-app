package com.infoshareacademy.pomaranczowi.financialanalyser;

class MenuPosition {

    private String label;
    private int id;

    MenuPosition(int id, String label) {
        this.id = id;
        this.label = label;
    }

    void show() {
        System.out.println(id+") "+label);
    }
}