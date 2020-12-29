package views.dialogs;

public class CarData {
    private String modelName;
    private String licensePlate;
    private String color;

    CarData(String modelName, String licensePlate, String color) {
        this.modelName = modelName;
        this.licensePlate = licensePlate;
        this.color = color;
    }

    public String getModelName() {
        return modelName;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getColor() {
        return color;
    }
}
