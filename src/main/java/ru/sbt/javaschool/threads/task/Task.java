package ru.sbt.javaschool.threads.task;

import java.util.concurrent.Callable;

/**
 * Created by Никита on 31.08.2016.
 */
public class Task<T> {
    private final Callable<? extends T> callable;
    private volatile TaskException taskException;
    private volatile T result;

    public Task(Callable<? extends T> callable) {
        this.callable = callable;
    }

    public T get() {
        if (taskException != null) throw taskException;
        if (result != null) return result;
        synchronized (this) {
            try {
                return result = callable.call();
            } catch (Exception e) {
                taskException = new TaskException(e);
                throw taskException;
            }
        }
    }
}
