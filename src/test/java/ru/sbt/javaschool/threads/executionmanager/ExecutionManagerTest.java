package ru.sbt.javaschool.threads.executionmanager;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Никита on 03.09.2016.
 */
public class ExecutionManagerTest {
    ExecutionManager executionManager;
    Runnable task1, task2, task3, task4, callback;

    @Before
    public void setUp() throws Exception {
        executionManager = new ExecutionManagerImpl();
        task1 = () -> {
            try {
                System.out.println("Task1");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
        task2 = () -> {
            try {
                System.out.println("Task2");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
        task3 = () -> {
            try {
                System.out.println("Task3");
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
        task4 = () -> {
            System.out.println("Task4");
            if (true) throw new RuntimeException();
        };
        callback = () -> {
            try {
                System.out.println("Callback");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

    }

    @Test
    public void execute() throws Exception {
        Context context = executionManager.execute(callback, new Runnable[]{task1, task2, task3, task4});
        Thread.sleep(3000);
        context.interrupt();
        System.out.println("completedTaskCount: " + context.getCompletedTaskCount() + ", interruptedTaskCount: " + context.getInterruptedTaskCount() + ", failedTaskCount: " + context.getFailedTaskCount() + ", isFinished: " + context.isFinished());
        Thread.sleep(3000);
        System.out.println("completedTaskCount: " + context.getCompletedTaskCount() + ", interruptedTaskCount: " + context.getInterruptedTaskCount() + ", failedTaskCount: " + context.getFailedTaskCount() + ", isFinished: " + context.isFinished());
        Thread.sleep(3000);
        System.out.println("completedTaskCount: " + context.getCompletedTaskCount() + ", interruptedTaskCount: " + context.getInterruptedTaskCount() + ", failedTaskCount: " + context.getFailedTaskCount() + ", isFinished: " + context.isFinished());
        Thread.sleep(3000);
        System.out.println("completedTaskCount: " + context.getCompletedTaskCount() + ", interruptedTaskCount: " + context.getInterruptedTaskCount() + ", failedTaskCount: " + context.getFailedTaskCount() + ", isFinished: " + context.isFinished());
    }

}