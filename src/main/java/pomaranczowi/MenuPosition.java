package pomaranczowi;

public class MenuPosition {

    static int counter;
    private String label;
    private Boolean active;
    private int id;

    public MenuPosition(String label) {
        id = counter;
        this.label = "( ) "+label;
        counter++;
    }

    public void setLabel(String label) {
        this.label = "( ) "+label;
    }

    public void Active(boolean isactive) {
        this.active = isactive;
    }

    public void show() {
        System.out.println(label);
    }

}