package ru.sbt.javaschool.threads.executionmanager;

/**
 * Created by Никита on 03.09.2016.
 */
public class ContextImpl implements Context {

    private final ThreadPool threadPool;

    public ContextImpl(ThreadPool threadPool, Runnable callback, Runnable... tasks) {
        this.threadPool = threadPool;
        for (Runnable task : tasks) threadPool.addTask(task);
        new Thread(() -> {
            threadPool.start();
            while (!(threadPool.getCompletedTaskCount().get() + threadPool.getFailedTaskCount().get() + threadPool.getInterruptedTaskCount().get() == tasks.length)) {
            }
            new Thread(new CallbackRunnable(callback, this.threadPool)).start();
        }).start();

    }

    @Override
    public int getCompletedTaskCount() {
        return threadPool.getCompletedTaskCount().get();
    }

    @Override
    public int getFailedTaskCount() {
        return threadPool.getFailedTaskCount().get();
    }

    @Override
    public int getInterruptedTaskCount() {
        return threadPool.getInterruptedTaskCount().get();
    }

    @Override
    public void interrupt() {
        threadPool.interrupt();
    }

    @Override
    public boolean isFinished() {
        return threadPool.isFinished();
    }
}
