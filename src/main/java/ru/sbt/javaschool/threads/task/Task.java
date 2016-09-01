/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sbt.javaschool.threads.task;

import java.util.concurrent.Callable;

/**
 *
 * @author evstafiev
 */
public class Task<T> {
    private final Callable<? extends T> callable;
    private volatile TaskException taskException;
    private volatile boolean isFinished;
    private volatile T result;
    private final Object lock = new Object();
    
    
    public Task(Callable<? extends T> callable) {
        this.callable = callable;
    }
    
    private void checkException() {
        if (taskException != null) throw taskException;
    }
    
    public T get() {
        checkException();
        if (isFinished) return result;
        synchronized (lock) {
            checkException();
            if (isFinished) return result;
            try {
                result = callable.call();
                isFinished = true;
                return result;
            } catch (Exception ex) {
                taskException = new TaskException(ex);
                throw taskException;
            }
        }
    }
    
}
