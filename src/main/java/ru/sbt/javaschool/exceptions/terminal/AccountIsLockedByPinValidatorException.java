package ru.sbt.javaschool.exceptions.terminal;

/**
 * Created by Никита on 04.08.2016.
 */
public class AccountIsLockedByPinValidatorException extends PinValidatorException {

    public AccountIsLockedByPinValidatorException(String message) {
        super(message);
    }
}
