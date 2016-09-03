package ru.sbt.javaschool.threads.executionmanager;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Никита on 03.09.2016.
 */
public class ThreadPool {
    private AtomicInteger completedTaskCount = new AtomicInteger(0);
    private AtomicInteger failedTaskCount = new AtomicInteger(0);
    private AtomicInteger interruptedTaskCount = new AtomicInteger(0);

    private final int taskCount;

    private AtomicBoolean finished = new AtomicBoolean(false);

    private final List<Thread> threadPool = new ArrayList<>();

    public ThreadPool(int taskCount) {
        this.taskCount = taskCount;
    }

    public void incCompletedTaskCount() {
        completedTaskCount.incrementAndGet();
    }

    public void incFailedTaskCount() {
        failedTaskCount.incrementAndGet();
    }

    public void incInterruptedTaskCount() {
        interruptedTaskCount.incrementAndGet();
    }

    public AtomicInteger getCompletedTaskCount() {
        return completedTaskCount;
    }

    public AtomicInteger getFailedTaskCount() {
        return failedTaskCount;
    }

    public AtomicInteger getInterruptedTaskCount() {
        return interruptedTaskCount;
    }

    public void addTask(Runnable runnable) {
        threadPool.add(new Thread(new CallbackRunnable(runnable, this)));
    }

    public void interrupt() {
        threadPool.stream().filter(Thread::isAlive).forEach(thread -> {
            thread.interrupt();
            incInterruptedTaskCount();
        });
    }

    public void start() {
        threadPool.forEach(Thread::start);
    }

    boolean isFinished() {
        return completedTaskCount.get() + interruptedTaskCount.get() + failedTaskCount.get() == taskCount;
    }

}
