package ru.sbt.javaschool.exceptions.terminal;

/**
 * Created by Никита on 04.08.2016.
 */
public class NoSuchClientException extends PinValidatorException {
    public NoSuchClientException(String message) {
        super(message);
    }
}
