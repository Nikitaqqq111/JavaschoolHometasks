package ru.sbt.javaschool.threads.executionmanager;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Никита on 01.09.2016.
 */
public class InfinityThreadPool {
    private final List<Thread> pool = new ArrayList<>();

    private AtomicInteger completedTaskCount;
    private AtomicInteger failedTaskCount;
    private AtomicInteger interruptedTaskCount;

    public void add(Runnable runnable) {
        pool.add(new Thread(runnable));
    }

    public void start() {
        pool.forEach(Thread::start);
    }

    public void interrupt() {
        pool.stream().filter(Thread::isAlive).forEach(thread -> {
            thread.interrupt();
            interruptedTaskCount.incrementAndGet();
        });
    }

}
