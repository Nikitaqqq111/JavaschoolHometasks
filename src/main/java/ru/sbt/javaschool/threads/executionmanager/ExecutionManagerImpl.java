package ru.sbt.javaschool.threads.executionmanager;

/**
 * Created by Никита on 03.09.2016.
 */
public class ExecutionManagerImpl implements ExecutionManager {
    @Override
    public Context execute(Runnable callback, Runnable... tasks) {
        return new ContextImpl(new ThreadPool(tasks.length + 1), callback, tasks);
    }
}
