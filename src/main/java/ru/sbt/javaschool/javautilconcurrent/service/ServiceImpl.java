package ru.sbt.javaschool.javautilconcurrent.service;

import java.util.HashMap;
import java.util.Map;
import java.util.jar.Pack200;

/**
 * Created by Никита on 12.09.2016.
 */
public class ServiceImpl implements Service {

    private final Map<Object, Object> locks = new HashMap<>();

    private final Object mutex = new Object();

    public static void main(String[] args) {
        System.out.println(0xa-0b10);
    }

    @Override
    public void run(Object o) {
        synchronized (mutex) {
            if (!locks.containsKey(o)) locks.put(o, new Object());
        }
        synchronized (locks.get(o)) {
            //doSmth
        }

        try {

        } catch (NullPointerException ex) {
            throw new NullPointerException();
        }

        (new Object()).toString();
        int a = 2 + new Integer(1);
        Class<?> clazz = float.class;
    }
}
