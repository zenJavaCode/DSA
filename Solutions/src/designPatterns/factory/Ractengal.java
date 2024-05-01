package designPatterns.factory;

public class Ractengal extends Shape{
    double length;
    double width;

    public Ractengal(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    double calculateArea() {
       return length * width;
    }
}
