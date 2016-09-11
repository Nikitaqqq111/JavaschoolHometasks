package ru.sbt.javaschool.sockets.domain;

/**
 * Created by Никита on 09.09.2016.
 */
public class ConcatinationImpl implements Concatination {
    @Override
    public String concate(String a, String b) {
        return a + b;
    }
}
