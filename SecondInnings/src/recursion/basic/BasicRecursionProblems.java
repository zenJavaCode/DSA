package recursion.basic;

import java.util.ArrayList;
import java.util.List;

public class BasicRecursionProblems {
    public static void main(String[] args) {
BasicRecursionProblems bs = new BasicRecursionProblems();
bs.printNosReverse(6);
    }

    /*TODO print 1 to N*/
    public void printNos(int N)
    {
        //Your code here
        if(N > 0)//The loop runs till N>1
        {
            printNos(N-1);//We keep on recursing till the end as we want to pritn from 1 to N
            System.out.print(N+" ");//When recursion is done then print N
        }
        return;


    }

    /* TODO Print GFG N Times*/
    void printGfg(int N) {
        // code here
        if(N>0){
            printGfg(N-1);
            System.out.print("GFG ");
        }

    }

    /*TODO Print N to 1*/

    void printNosReverse(int N) {
        // code here
       if(N>=1){
           System.out.print(N+ " ");
           printNosReverse(N-1);
       }
    }

    /*TODO Factorial of a number using recursion banner
            A number N is called a factorial number if it is the factorial of a positive integer. For example,
            the first few factorial numbers are 1, 2, 6, 24, 120,
            Given a number N, the task is to return the list/vector of the factorial numbers
            smaller than or equal to N.*/

    static ArrayList<Long> factorialNumbers(long N){
        ArrayList<Long> list = new ArrayList<>();
        for (long i = 1; i <= N; i++) {
            list.add(factorialNumber(i));
        }
        return list;
    }

    private static long factorialNumber(long n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * factorialNumber(n - 1);
        }
    }
}

