package ru.sbt.javaschool.exceptions.terminal;

/**
 * Created by Никита on 04.08.2016.
 */
public class TerminalServerException extends Exception {

    public TerminalServerException(String message) {
        super(message);
    }

    public TerminalServerException(String message, Throwable cause) {
        super(message, cause);
    }

}
