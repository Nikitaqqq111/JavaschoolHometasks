package ru.sbt.javaschool.threads.task;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Никита on 31.08.2016.
 */
public class TaskTest {
    @Test
    public void get() throws Exception {
        Task<Integer> task = new Task<>(() -> {
            for (int i = 0; i < 1_000_000_000; i++);
            return 123;
        });

        Runnable run = () ->
                System.out.println(task.get() + " " + Thread.currentThread().getName() + " " + Thread.currentThread().getPriority());

        for (int i = 0; i < 5; i++) {
            new Thread(run).start();
        }
    }
}