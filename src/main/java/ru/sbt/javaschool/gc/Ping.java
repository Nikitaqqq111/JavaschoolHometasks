package ru.sbt.javaschool.gc;

/**
 * Created by Никита on 19.09.2016.
 */
public class Ping implements Runnable {

    private final Object lock;

    public Ping(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (lock) {
                lock.notify();
                System.out.println("Ping");
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
