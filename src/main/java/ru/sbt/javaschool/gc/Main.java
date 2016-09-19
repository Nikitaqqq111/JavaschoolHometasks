package ru.sbt.javaschool.gc;

/**
 * Created by Никита on 19.09.2016.
 */
public class Main {

    public static void main(String[] args) {
        Object lock = new Object();
        new Thread(new Ping(lock)).start();
        new Thread(new Pong(lock)).start();
    }


}
