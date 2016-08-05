package ru.sbt.javaschool.exceptions.terminal;

/**
 * Created by Никита on 05.08.2016.
 */
public class TerminalException extends Exception {

    public TerminalException(String message) {
        super(message);
    }

    public TerminalException(String message, Throwable cause) {
        super(message, cause);
    }
}
