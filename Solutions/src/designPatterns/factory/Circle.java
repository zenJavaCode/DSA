package designPatterns.factory;

public class Circle extends Shape {
    double radius;

public Circle(double radius) {
    this.radius = radius;
}
    @Override
    double calculateArea() {
       return Math.PI * radius * radius;
    }
}
