package designPatterns.factory;

public class  ShapeCalculater {

    public static double getArea(Shape shape) {
        return shape.calculateArea();
    }
}
