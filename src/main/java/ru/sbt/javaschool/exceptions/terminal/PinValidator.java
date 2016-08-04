package ru.sbt.javaschool.exceptions.terminal;

/**
 * Created by Никита on 04.08.2016.
 */
public interface PinValidator {
    void validate(String client, String password) throws PinValidatorException;
}
