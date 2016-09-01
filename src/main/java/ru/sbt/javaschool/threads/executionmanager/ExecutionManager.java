package ru.sbt.javaschool.threads.executionmanager;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by Никита on 01.09.2016.
 */
public interface ExecutionManager {

    Context execute(Runnable callback, Runnable... tasks);

}
