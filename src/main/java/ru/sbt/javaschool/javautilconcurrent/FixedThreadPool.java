package ru.sbt.javaschool.javautilconcurrent;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Никита on 05.09.2016.
 */
public class FixedThreadPool implements ThreadPool {

    private final BlockingQueue<Runnable> tasks = new LinkedBlockingQueue<>();
    private final int threadCount;

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
        tasks.add(task);
    }

    public class Worker extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    tasks.take().run();
                } catch (InterruptedException e) {
                    throw new WorkerException("Smth bad in task", e);
                } catch (Exception e) {
                    throw new ThreadPoolException(e);
                }
            }
        }
    }

}
