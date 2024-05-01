package designPatterns.builder;
class CarBuilderImpl implements CarBuilder {
    private String brand;
    private String model;
    private String color;
    private String transmission;
    private int seats;

    @Override
    public CarBuilder setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    @Override
    public CarBuilder setModel(String model) {
        this.model = model;
        return this;
    }

    @Override
    public CarBuilder setColor(String color) {
        this.color = color;
        return this;
    }

    @Override
    public CarBuilder setTransmission(String transmission) {
        this.transmission = transmission;
        return this;
    }

    @Override
    public CarBuilder setSeats(int seats) {
        this.seats = seats;
        return this;
    }

    @Override
    public Car build() {
        return new Car(brand, model, color, transmission, seats);
    }
}
