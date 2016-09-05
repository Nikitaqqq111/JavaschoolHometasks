package ru.sbt.javaschool.javautilconcurrent;

/**
 * Created by Никита on 05.09.2016.
 */
public class ThreadPoolException extends RuntimeException {

    public ThreadPoolException(String message, Throwable cause) {
        super(message, cause);
    }

    public ThreadPoolException(Throwable cause) {
        super(cause);
    }
}
