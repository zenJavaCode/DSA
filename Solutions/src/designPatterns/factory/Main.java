package designPatterns.factory;

public class Main {

    public static void main(String[] args) {
        Shape circle = ShapeFactory.createShape(2.5);
        Shape ractangle = ShapeFactory.createShape(8,9);
        System.out.println("Circle area : "+ShapeCalculater.getArea(circle));
        System.out.println( "Ractangle Area : "+ShapeCalculater.getArea(ractangle));
        //System.out.println("circle area : "+circle.);
    }
}
