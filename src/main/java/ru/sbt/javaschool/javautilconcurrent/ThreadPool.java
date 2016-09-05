package ru.sbt.javaschool.javautilconcurrent;

/**
 * Created by Никита on 05.09.2016.
 */
public interface ThreadPool {

    void start();

    void execute(Runnable task);

}
