package pomaranczowi;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Menu {

    private ArrayList<MenuPosition> menuPositions = new ArrayList<>();
    private String title;

    public Menu(String title) {
        this.title = title;
    }

    public void add(String label) {
        menuPositions.add(new MenuPosition(label));
    }

    public int Init() {
        System.out.println("\n"+title+"\n");
        for (MenuPosition menuPosition : menuPositions) {
            menuPosition.show();
        }

        System.out.println("\nWybierz pozycję (podaj liczbę): ");

        Scanner input = new Scanner(System.in);
        boolean correct = false;

        while (!correct) {
            try {
                Integer option = input.nextInt();
                correct = true;
            } catch (InputMismatchException e) {
                System.out.println("Podaj liczbę!");
                input.next();
            }
        }

        return 0;
    }
}