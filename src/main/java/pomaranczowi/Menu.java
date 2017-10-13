package pomaranczowi;

import java.util.ArrayList;


public class Menu {

    private ArrayList<MenuPosition> menuPositions = new ArrayList<>();
    private String title;

    public Menu(String title) {
        this.title = title;
    }

    public void add(String label) {
        menuPositions.add(new MenuPosition(label));
    }

    public int Show() {
        System.out.println("||| ANALIZATOR FINANSOWY ||||\n");
        for (MenuPosition menuPosition : menuPositions) {
            menuPosition.show();
        }

        System.out.println();

        return 0;
    }
}