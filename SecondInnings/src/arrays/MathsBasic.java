package arrays;

public class MathsBasic {

    //TODO Evenly Divide
    public static void main(String[] args) {
        //evenlyDivides(12);
        reverse(1534236469);
    }

    static int evenlyDivides(int N) {
        // code here
        int temp = N;
        int result = 0;
        while (temp > 0) {
            int digit = temp % 10;
            System.out.println("the digit is " + digit);
            if (N % digit == 0) {
                result++;
            }
            temp = temp / 10;

        }
        return result;
    }

    /*TODO Reverse a number.*/
    public static int reverse(int x) {
        int result = 0;
        int temp;
        if (x < 0) {
            temp = (x * -1);
        } else {
            temp = x;
        }
        while (temp > 0) {
            int digit = temp % 10;
            result = result * 10 + digit;
            temp = temp / 10;
        }
        System.out.println(result);
        if (x < 0) {
            return result * -1;
        }
        return result;
    }

    /*TODO isPalinDrome*/

    public boolean isPalindrome(int x) {
        int reverse = 0;
        int temp;
        if (x < 0) {
            temp = (x * -1);
        } else {
            temp = x;
        }
        while (temp > 0) {
            int digit = temp % 10;
            reverse = reverse * 10 + digit;
            temp = temp / 10;
        }
        return reverse == x;
    }

    /*TODO LCM HCF*/

    static Long[] lcmAndGcd(Long A, Long B) {
        Long gcd = gcd(A, B);
        Long lcm = (A * B) / gcd;
        return new Long[]{lcm, gcd};
    }

    static Long gcd(Long a, Long b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    /*TODO ArmStrong Number*/
    public static boolean isArmstrong(int num) {
        int originalNum = num;
        int digits = countDigits(num);
        int sum = 0;

        while (num > 0) {
            int remainder = num % 10;
            sum += Math.pow(remainder, digits);
            num = num / 10;
        }
        return sum == originalNum;
    }

    public static int countDigits(int num) {
        int count = 0;
        while (num > 0) {
            count++;
            num = num / 10;
        }
        return count;
    }

    /* TODO:SumOfAllDivisors*/

    /*TODO IsPrime*/
    static boolean checkPrime(int n) {
        if (n <= 1) {
            return false; // Numbers less than or equal to 1 are not prime
        }
        if (n <= 3) {
            return true; // 2 and 3 are prime
        }

        // Check for divisibility starting from 2 to sqrt(n)
        int count = 0;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                count++;
            }
        }

        // If count is 0, it means the number is prime
        return count == 0;

    }
}
