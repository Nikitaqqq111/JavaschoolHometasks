package ru.sbt.javaschool.exceptions.terminal;

/**
 * Created by Никита on 04.08.2016.
 */
public class OverdraftException extends TerminalServerException {
    public OverdraftException(String message) {
        super(message);
    }

    public OverdraftException(String message, Throwable cause) {
        super(message, cause);
    }

}
