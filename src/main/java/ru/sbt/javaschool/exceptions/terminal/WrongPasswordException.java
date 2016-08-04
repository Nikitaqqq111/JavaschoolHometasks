package ru.sbt.javaschool.exceptions.terminal;

/**
 * Created by Никита on 04.08.2016.
 */
public class WrongPasswordException extends PinValidatorException {
    public WrongPasswordException(String message) {
        super(message);
    }
}
