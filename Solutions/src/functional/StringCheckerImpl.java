package functional;

public class StringCheckerImpl {

    public static void main(String[] args) {
        StringChecker isPalindrome = (str) -> {
            String reversed = new StringBuilder(str).reverse().toString();
            return str.equals(reversed);
        };
    }
}
