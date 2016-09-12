package ru.itis.infrom;

public class Main {
    public static void main(String[] args){
        MyThread mythread = new MyThread();

        mythread.setName(1);
        Thread t1 = new Thread(mythread);

        mythread.setName(2);
        Thread t2 = new Thread(mythread);

        mythread.setName(3);
        Thread t3 = new Thread(mythread);

        mythread.setName(4);
        Thread t4 = new Thread(mythread);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
