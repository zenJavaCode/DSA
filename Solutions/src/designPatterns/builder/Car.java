package designPatterns.builder;

public class Car {

    private String brand;
    private String model;
    private String color;
    private String transmission;
    private int seats;

    public Car(String brand, String model, String color, String transmission, int seats) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.transmission = transmission;
        this.seats = seats;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }
}
