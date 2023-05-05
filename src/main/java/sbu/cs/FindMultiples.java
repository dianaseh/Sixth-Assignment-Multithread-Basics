package java.sbu.cs;
import java.util.*;
/*
    In this exercise, you must write a multithreaded program that finds all
    integers in the range [1, n] that are divisible by 3, 5, or 7. Return the
    sum of all unique integers as your answer.
    Note that an integer such as 15 (which is a multiple of 3 and 5) is only
    counted once.

    The Positive integer n > 0 is given to you as input. Create as many threads as
    you need to solve the problem. You can use a Thread Pool for bonus points.

    Example:
    Input: n = 10
    Output: sum = 40
    Explanation: Numbers in the range [1, 10] that are divisible by 3, 5, or 7 are:
    3, 5, 6, 7, 9, 10. The sum of these numbers is 40.

    Use the tests provided in the test folder to ensure your code works correctly.
 */

import java.util.ArrayList;

public class FindMultiples
{
    // TODO create the required multithreading class/classes using your preferred method.
    public class search implements Runnable {
        private int n ;
        private int prime;
        public ArrayList<Integer> paddles = new ArrayList<Integer>();
        public search(int n , int prime ) {
            this.n= n ;
            this.prime = prime ;
        }

        @Override
        public void run() {
            for(int i=1 ; i<=n ; i++){
                if(this.n % this.prime == 0 ){
                    paddles.add(i);
                }
            }
        }
    }

    /*
    The getSum function should be called at the start of your program.
    New Threads and tasks should be created here.
    */
    public int getSum(int n) throws InterruptedException {
        int sum = 0;
        search search3 = new search(n , 3);
        search search5 = new search(n , 5);
        search search7 = new search(n , 7);
        Thread t3 = new Thread(search3);
        Thread t5 = new Thread(search5);
        Thread t7 = new Thread(search7);
        t3.start();
        t5.start();
        t7.start();

        t3.join();
        t5.join();
        t7.join();
        ArrayList<Integer> results = new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();
        results.addAll(search3.paddles);
        results.addAll(search5.paddles);
        results.addAll(search7.paddles);

        Collections.sort(results);

        for(int i=0 ; i<results.size()-1 ; i++){
            if(results.get(i) != results.get(i+1))
                res.add(results.get(i));
            else if(results.get(i) == results.get(i+1));
        }
        for(int i =0 ; i<res.size() ; i++){
            sum += res.get(i);
        }
        return sum;
    }

    public static void main(String[] args) throws InterruptedException {
    }
}
