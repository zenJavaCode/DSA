package functional;

public class StringUpperCaseTransformer {



    public static void main(String[] args) {
        StringTransformer stringTransformer = (str) -> str.toUpperCase();
        System.out.println(stringTransformer.transform("piyush"));

        ValueSupplier valueSupplier = () -> "Hello, world!";
        System.out.println(valueSupplier.getValue());
    }


}
