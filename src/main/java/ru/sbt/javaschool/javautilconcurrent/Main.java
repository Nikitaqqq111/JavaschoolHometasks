package ru.sbt.javaschool.javautilconcurrent;

import ru.sbt.javaschool.jmm.*;

/**
 * Created by Никита on 05.09.2016.
 */
public class Main {
    public static void main(String[] args) {
        Runnable task1 = () -> {
            try {
                System.out.println("Task1 started");
                Thread.sleep(1000);
                System.out.println("Task1 completed");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
        Runnable task2 = () -> {
            try {
                System.out.println("Task2 started");
                Thread.sleep(1000);
                System.out.println("Task2 completed");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
        Runnable task3 = () -> {
            try {
                System.out.println("Task3 started");
                Thread.sleep(3000);
                System.out.println("Task3 completed");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
        Runnable task4 = () -> {
            try {
                System.out.println("Task4 started");
                Thread.sleep(4000);
                System.out.println("Task4 completed");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        Runnable task6 = task2, task7 = task2, task8 = task2, task9 = task2;

        ThreadPool threadPool = new FixedThreadPool(2);
        threadPool.start();
        threadPool.execute(task1);
        threadPool.execute(task2);
        threadPool.execute(task3);
        threadPool.execute(task4);
        threadPool.execute(task6);
        threadPool.execute(task7);
        threadPool.execute(task8);
        threadPool.execute(task9);

    }
}