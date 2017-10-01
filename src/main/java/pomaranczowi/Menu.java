package pomaranczowi;

import java.util.ArrayList;


public class Menu {

    ArrayList<String> list = new ArrayList<>();
    // TODO: 02.10.17 change ArrayList to work on MenuPosition objects

    public void add(String label) {
        list.add(label);
    }

    public int Show() {
        System.out.println("||| ANALIZATOR FINANSOWY ||||\n");
        for (String menuPosition : list) {
            // TODO: 02.10.17 complete the loop to print out all menu positions
        }

        MenuPosition menu1 = new MenuPosition("Waluta");
        MenuPosition menu2 = new MenuPosition("Giełda");
        MenuPosition menu3 = new MenuPosition("Wyjście");

        menu1.Show();
        menu2.Show();
        menu3.Show();

        System.out.println();

        return 0;
    }
}