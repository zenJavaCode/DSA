package designPatterns.builder;

public class Main {

CarBuilder carBuilder = new CarBuilderImpl();
Car car = carBuilder.setBrand("Totota").setColor("Black").setSeats(2).setTransmission("Auto").build();


}
