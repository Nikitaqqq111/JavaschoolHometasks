package ru.sbt.javaschool.exceptions.terminal;

/**
 * Created by Никита on 04.08.2016.
 */
public class ClosedAccountException extends TerminalServerException {

    public ClosedAccountException(String message) {
        super(message);
    }

    public ClosedAccountException(String message, Throwable cause) {
        super(message, cause);
    }

}
