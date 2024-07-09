package designPatterns.structural.adaptor.radioPhoneExample;

public class Main {

    public static void main(String[] args) {
        OldRadio radio = new SmartPhoneAdaptor(new SmartPhone());
        radio.playCassette();
    }
}
