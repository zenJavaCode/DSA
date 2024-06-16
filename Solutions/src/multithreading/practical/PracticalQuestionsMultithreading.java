package multithreading.practical;

import multithreading.Thread1;

public class PracticalQuestionsMultithreading {

/*TODO Write a program that creates two threads. One thread prints even numbers from 0 to 10, and the other thread prints odd numbers from 1 to 9.*/

    public static void main(String[] args) {
        Thread oddThread = new Thread(new Odd());
        Thread evenThread = new Thread(new Thread2());
        evenThread.start();
        oddThread.start();
    }

}
