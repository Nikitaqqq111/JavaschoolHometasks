package ru.sbt.javaschool.threads.executionmanager;

/**
 * Created by Никита on 01.09.2016.
 */
public interface Context {

    int getCompletedTaskCount();

    int getFailedTaskCount();

    int getInterruptedTaskCount();

    void interrupt();

    boolean isFinished();
}
