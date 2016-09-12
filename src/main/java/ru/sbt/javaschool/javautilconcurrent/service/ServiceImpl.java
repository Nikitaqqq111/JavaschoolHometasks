package ru.sbt.javaschool.javautilconcurrent.service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Никита on 12.09.2016.
 */
public class ServiceImpl implements Service {

    private final Map<Object, Object> locks = new HashMap<>();

    private final Object mutex = new Object();

    @Override
    public void run(Object o) {
        synchronized (mutex) {
            if (!locks.containsKey(o)) locks.put(o, new Object());
        }
        synchronized (locks.get(o)) {
            //doSmth
        }

    }
}
