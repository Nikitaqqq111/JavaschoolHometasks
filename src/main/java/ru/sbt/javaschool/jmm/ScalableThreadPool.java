package ru.sbt.javaschool.jmm;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import static java.lang.Integer.min;

/**
 * Created by Никита on 05.09.2016.
 */
public class ScalableThreadPool implements ThreadPool {
    private final int minThreadCount;
    private final int maxThreadCount;

    private final Queue<Runnable> tasks = new ArrayDeque<>();
    private final List<Worker> workers = new ArrayList<>();

    private final Object lock = new Object();

    public ScalableThreadPool(int minThreadCount, int maxThreadCount) {
        if (minThreadCount > maxThreadCount || minThreadCount < 1)
            throw new IllegalArgumentException("Check parameters in constructor of ScalableThreadPool");
        this.minThreadCount = minThreadCount;
        this.maxThreadCount = maxThreadCount;
    }

    @Override
    public void start() {
        for (int i = 0; i < minThreadCount; i++) {
            workers.add(new Worker());
        }
        workers.forEach(Worker::start);
        new Thread(() -> checkThreads()).start();
    }

    @Override
    public void execute(Runnable task) {
        synchronized (lock) {
            tasks.add(task);
            lock.notify();
        }
    }

    private void checkThreads() {
        while (true) {
            synchronized (lock) {
                List<Integer> indexesOfSleepingWorkers = new ArrayList<>();
                int currentThread = workers.size();
                for (int i = 0; i < workers.size(); i++) {
                    if (workers.get(i).isSleeping()) {
                        indexesOfSleepingWorkers.add(i);
                    }
                }

                for (int i = 0; i < min(indexesOfSleepingWorkers.size(), currentThread - minThreadCount); i++) {
                    workers.get(indexesOfSleepingWorkers.get(i)).interrupt();
                    workers.remove((int) indexesOfSleepingWorkers.get(i));
                }

                for (int i = 0; i < min(tasks.size(), maxThreadCount - currentThread); i++) {
                    workers.add(new Worker());
                    workers.get(workers.size() - 1).start();
                }
            }
        }
    }

    public class Worker extends Thread {
        private boolean sleeping = false;

        public boolean isSleeping() {
            synchronized (lock) {
                return sleeping;
            }
        }

        @Override
        public void run() {
            while (true) {
                Runnable task;
                synchronized (lock) {
                    while (tasks.isEmpty()) {
                        try {
                            sleeping = true;
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new ThreadPoolException("Killed by ScalableThreadPool", e);
                        }
                    }
                    sleeping = false;
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
