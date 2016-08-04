package ru.sbt.javaschool.exceptions.terminal;

/**
 * Created by Никита on 04.08.2016.
 */
public class BadConnectionException extends TerminalServerException {

    public BadConnectionException(String message) {
        super(message);
    }

    public BadConnectionException(String message, Throwable cause) {
        super(message, cause);
    }

}

