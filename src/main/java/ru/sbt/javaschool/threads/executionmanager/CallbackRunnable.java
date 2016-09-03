package ru.sbt.javaschool.threads.executionmanager;

/**
 * Created by Никита on 03.09.2016.
 */
public class CallbackRunnable implements Runnable {

    private final Runnable runnable;

    private final ThreadPool threadPool;

    public CallbackRunnable(Runnable runnable, ThreadPool threadPool) {
        this.runnable = runnable;
        this.threadPool = threadPool;
    }

    @Override
    public void run() {
        try {
            runnable.run();
            threadPool.incCompletedTaskCount();
        } catch (Exception e) {
            threadPool.incFailedTaskCount();
        }
    }
}
