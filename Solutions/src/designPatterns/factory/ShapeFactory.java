package designPatterns.factory;

import java.awt.*;

public class ShapeFactory {

    public static Shape createShape(double radius){
        return new Circle(radius);
    }

    public static Shape createShape(double width, double height){
        return new Ractengal(width, height);
    }

    /*TODO : */
}
