package designPatterns.structural.facade;

public class Projector {

    public void on() {
        System.out.println("Projector is on");
    }
    public void off() {
        System.out.println("Projector is off");
    }
    public void lowerScreen() {
        System.out.println("Projector screen is lowered");
    }
}
