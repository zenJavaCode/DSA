package functional;

@FunctionalInterface
public interface StringTransformer {
String transform(String str);
}

//public class UpperCaseTransformer{
//
//    public static void main(String[] args) {
//        // Lambda expression to convert to uppercase
//        StringTransformer toUpperCase = String::toUpperCase;
//
//        // Test the lambda
//        System.out.println(toUpperCase.transform("hello")); // HELLO
//        System.out.println(toUpperCase.transform("java")); // JAVA
//    }
//
//}
