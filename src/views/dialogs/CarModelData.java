package views.dialogs;

public class CarModelData {
    private String name;
    private double cost;

    CarModelData(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }

    public double getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }
}
