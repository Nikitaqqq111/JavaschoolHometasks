package ru.sbt.javaschool.jmm;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by Никита on 05.09.2016.
 */
public class FixedThreadPool implements ThreadPool {

    private final Queue<Runnable> tasks = new ArrayDeque<>();
    private final int threadCount;
    private final Object lock = new Object();

    public FixedThreadPool(int threadCount) {
        this.threadCount = threadCount;
    }

    @Override
    public void start() {
        for (int i = 0; i < threadCount; i++) {
            new Worker().start();
        }
    }

    @Override
    public void execute(Runnable task) {
        synchronized (lock) {
            tasks.add(task);
            lock.notify();
        }
    }

    public class Worker extends Thread {
        @Override
        public void run() {
            while (true) {
                Runnable task = null;
                synchronized (lock) {
                    while (tasks.isEmpty()) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new ThreadPoolException(e);
                        }
                    }
                    task = tasks.poll();
                }
                try {
                    task.run(); // handle exception
                } catch (Exception e) {
                    throw new WorkerException("Smth bad in task", e);
                }
            }
        }
    }
}
