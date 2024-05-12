import Printer.Printer;

import java.util.concurrent.locks.ReentrantLock;

public class Main {
    static int n;
    int counter=0;
    public static void main(String[] args) {
        n=10;
        Main poe=new Main();

        Thread t1=new Thread(new Runnable() {
            public void run() {
                poe.printOddNumber();
            }
        },"Thread-1");

        Thread t2=new Thread(new Runnable() {
            public void run() {
                poe.printEvenNumber();
            }
        },"Thread-2");

        t1.start();
        t2.start();

    }

    public void printOddNumber() {
        synchronized (this) {
            while(counter <n) {
                while(counter%2==0) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName()+"   "+counter);
                counter++;
                notify();
            }
        }
    }

    public void printEvenNumber() {
        synchronized (this) {
            while(counter <n) {
                while(counter%2!=0) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName()+"   "+counter);
                counter++;
                notify();
            }
        }
    }

}
