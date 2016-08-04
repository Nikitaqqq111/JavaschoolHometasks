package ru.sbt.javaschool.exceptions.terminal;

/**
 * Created by Никита on 04.08.2016.
 */
public class PinValidatorException extends Exception {

    public PinValidatorException(String message) {
        super(message);
    }

    public PinValidatorException(String message, Throwable cause) {
        super(message, cause);
    }
}
