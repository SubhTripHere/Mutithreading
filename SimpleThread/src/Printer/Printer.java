package Printer;

import java.util.concurrent.locks.ReentrantLock;

public class Printer {
    static int counter = 1;

    public synchronized void printOdd(int i){
        while(counter%2==0){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(i+ Thread.currentThread().getName());
        counter++;
        notifyAll();
    }

    public synchronized void printEven(int i){
        while(counter%2==1){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(i+ Thread.currentThread().getName());
        counter++;
        notifyAll();
    }
}
