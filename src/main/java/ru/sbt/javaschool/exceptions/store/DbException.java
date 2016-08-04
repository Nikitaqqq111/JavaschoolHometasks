package ru.sbt.javaschool.exceptions.store;

/**
 *
 * @author evstafiev
 */
public class DbException extends StoreException {

    public DbException(String message, Throwable cause) {
        super(message, cause);
    }

}
