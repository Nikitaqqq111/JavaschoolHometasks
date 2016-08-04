package ru.sbt.javaschool.exceptions.terminal;

/**
 * Created by Никита on 04.08.2016.
 */
public class BlockedAccountException extends TerminalServerException {

    public BlockedAccountException(String message) {
        super(message);
    }

    public BlockedAccountException(String message, Throwable cause) {
        super(message, cause);
    }

}
