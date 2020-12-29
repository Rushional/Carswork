package views.dialogs;

public class ServiceData {
    private String name;
    private double price;

    ServiceData(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}
