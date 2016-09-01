package ru.sbt.javaschool.threads.executionmanager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Никита on 01.09.2016.
 */
public class ExecutionManagerImpl implements ExecutionManager {

    private final List<Runnable> tasks = new ArrayList<>();

    private final Context context = new ContextImpl();

    @Override
    public Context execute(Runnable callback, Runnable... tasks) {
/*        this.tasks.addAll(Arrays.asList(tasks));
        return null;*/
    }
}
