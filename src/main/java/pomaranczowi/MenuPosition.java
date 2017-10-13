package pomaranczowi;

public class MenuPosition {

    static int counter;
    private String label;
    private Boolean active;
    private int id;

    public MenuPosition(String label) {
        id = counter;
        this.label = label;
        counter++;
    }

    public void setLabel(String label) {
        this.label = "( ) "+label;
    }

    public void Active(boolean isactive) {
        this.setActive(isactive);
    }

    public void show() {
        System.out.println(getId()+") "+getLabel());
    }

    public String getLabel() {
        return label;
    }

    public Boolean isActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public int getId() {
        return id;
    }

}