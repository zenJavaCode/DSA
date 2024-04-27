package basic;

public class BasicMaths {

    public static void main(String[] args) {

    }

    /* TODO : You are given a number ’n’.
Find the number of digits of ‘n’ that evenly divide ‘n’.
Note:
A digit evenly divides ‘n’ if it leaves no remainder when dividing ‘n’.*/

    public static int countDigits(int n){
        int rem =0;
        int num = n;
        int count =0;
        while(num >0){
            rem = num%10;
            if( num !=0 &&num %rem ==0){
                count++;
            }
            num /=10;
        }
        return count;
    }


    /*TODO : There is a song concert going to happen in the city.
       The price of each ticket is equal to the number obtained
       after reversing d integer ‘n’.*/
    public static int  reversNum  (int n ){
        int temp= n;
        int reverse =0;
        while(temp !=0){
            int remainder  = temp %10;
            reverse = reverse *10+remainder;
            temp /=10;
        }
        return reverse;
    }

    /*TODO : GCD*/

    public static int calcGCD(int n, int m){
        // Write your code here.

        if(n%m ==0){
            return m;
        }
        if(m%n ==0){
            return n;
        }
        if(n>m){
            return  calcGCD(n%m,m);
        }
        return calcGCD(n,m%n);
    }


    /*TODO : GCD BASIC*/

    public static int gcd (int n,int m){

        int gcd = 1;
        for(int i =2;i<= n && i <=m;i++){

            if(n%i ==0 && m%i ==0){
                gcd = i;
            }
        }
        return gcd;
    }

    /*TODO : Palindrome*/

    public static boolean palindromeNumber(int n){
        // Write your code here.
        int dup=n;
        int rev=0;
        int lastdigit=0;
        while(n>0){
            lastdigit= n%10;
            n=n/10;
            rev=(rev*10)+lastdigit;
        }
        if (dup==rev) return true;
        else return false;
    }


    /*TODO SUM OF ALL DiVISORS*/

    public static int sumOfAllDivisors(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                // Directly add divisor and its pair (n/i)
                sum += i + n / i;
            }
        }
        return sum;
    }

    /*TODO: Prime Number */
    public static boolean isPrime(int num) {
        //Your code goes here
        if(num <0 || num ==1 || num ==2){
            return false;
        }else{
            for(int i =2;i*i<num;i++){
                if(num % i ==0){
                    return false;
                }
            }
        }
        return true;
    }


    /*TODO MORE OPTIMISED IS PRIME */

    public static boolean isPrimeOptimised(int num) {
        if (num <= 1) {
            return false; // 0 and 1 are not prime
        } else if (num <= 3) {
            return true; // 2 and 3 are prime
        } else if (num % 2 == 0 || num % 3 == 0) {
            return false; // Even numbers except 2 and multiples of 3 are not prime
        }
        for (int i = 5; i * i <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    /*TODO Arm Strong number */
    /*TODO: You are given an integer 'n'. Return 'true' if 'n' is an Armstrong number, and 'false' otherwise.
          An Armstrong number is a number (with 'k' digits) such that the sum of its digits raised to 'kth' power is equal
            to the number itself. For example, 371 is an Armstrong number because 3^3 + 7^3 + 1^3 = 371*/

    public static boolean isArmStrongNum(int n){

        if (n == 1) {
            return true;
        }
        int powCount = 0;
        int temp = n;
        while(temp !=0){
            temp /=10;
            powCount++;
        }
        System.out.println("the  power count is :"+powCount);
        int rem = 0;
        temp = n;
        int num =0;
        while(n >0){
             rem = n % 10;
            if(rem !=0) {
                num += Math.pow(rem, powCount);
            }
            n /=10;
        }
        if(num ==temp){
            return true;
        }
        return false;
    }



}
