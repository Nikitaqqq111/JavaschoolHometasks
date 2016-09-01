package ru.sbt.javaschool.threads.executionmanager;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by Никита on 01.09.2016.
 */
public class ContextImpl implements Context {
    private final InfinityThreadPool infinityThreadPool;

    private int completedTaskCount;
    private int failedTaskCount;
    private int interruptedTaskCount;

    private Object lockForCompletedTaskCount = new Object();
    private Object lockForFailedTaskCount = new Object();
    private Object lockForInterruptedTaskCount = new Object();

    public ContextImpl(InfinityThreadPool infinityThreadPool) {
        this.infinityThreadPool = infinityThreadPool;
    }

    @Override
    public int getCompletedTaskCount() {
        return completedTaskCount;
    }

    @Override
    public int getFailedTaskCount() {
        return failedTaskCount;
    }

    @Override
    public int getInterruptedTaskCount() {
        return interruptedTaskCount;
    }

    @Override
    public void interrupt() {

    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
