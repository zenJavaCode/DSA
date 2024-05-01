package designPatterns.builder;

public interface CarBuilder {

    CarBuilder setBrand(String brand);
    CarBuilder setModel(String model);
    CarBuilder setColor(String color);
    CarBuilder setTransmission(String transmission);
    CarBuilder setSeats(int seats);
    Car build();
}
