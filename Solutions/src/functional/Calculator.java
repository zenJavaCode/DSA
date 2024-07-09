package functional;

public class Calculator {

    public static void main(String[] args) {


        MathOperation module = new MathOperation() {
            @Override
            public int operate(int a, int b) {
                return a % b;
            }
        };


        MathOperation addition = (a,b) -> a+b;
        MathOperation subtraction = (a,b) -> a-b;
        MathOperation multiplication = (a,b) -> a*b;
        MathOperation division = (a,b) -> a/b;

        System.out.println("Addition: " + addition.operate(5, 3)); // Addition: 8
        System.out.println("Subtraction: " + subtraction.operate(5, 3)); // Subtraction: 2
        System.out.println("Multiplication: " + multiplication.operate(5, 3)); // Multiplication: 15
        System.out.println("Division: " + division.operate(6, 3)); // Division:

    }
}
