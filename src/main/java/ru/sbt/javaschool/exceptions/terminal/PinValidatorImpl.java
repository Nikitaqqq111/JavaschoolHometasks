package ru.sbt.javaschool.exceptions.terminal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * Created by Никита on 04.08.2016.
 */
public class PinValidatorImpl implements PinValidator {

    private final Map<String, String> clientsAndPasswords;

    private final static int DELTA_OF_TIME_BLOCKING = 5000;

    private int countOfAttempts;

    private final static int COUNT_OF_MAXIMUM_ATTEMPTS = 3;

    private Date timeBlocking;

    public PinValidatorImpl(Map<String, String> clientsAndPasswords) {
        this.clientsAndPasswords = clientsAndPasswords;
        this.timeBlocking = new Date(0);
        this.countOfAttempts = 0;
    }

    @Override
    public void validate(String client, String password) throws PinValidatorException {
        try {
            checkTimeOfBlocking();
            checkClient(client);
            checkPassword(client, password);
        } catch (PinValidatorException ex) {
            throw new PinValidatorException("Ошибка валидатора: ", ex);
        }
    }

    private void checkTimeOfBlocking() throws PinValidatorException {
        Date currentTime = new Date();
        if (timeBlocking.getTime() + DELTA_OF_TIME_BLOCKING > currentTime.getTime()) {
            throw new AccountIsLockedByPinValidatorException("Три раза был введен неправильный пароль. Время разлочения: " + getTimeOfUnlock());
        }
    }

    private String getTimeOfUnlock() {
        return new SimpleDateFormat("hh:mm").format(timeBlocking.getTime() + DELTA_OF_TIME_BLOCKING);
    }

    private void checkClient(String client) throws PinValidatorException {
        if (!clientsAndPasswords.containsKey(client)) {
            throw new NoSuchClientException("Данного клиента не существует");
        }
    }

    private void checkPassword(String client, String password) throws PinValidatorException {
        if (clientsAndPasswords.get(client) != password) {
            countOfAttempts++;
            if (countOfAttempts == COUNT_OF_MAXIMUM_ATTEMPTS) {
                countOfAttempts = 0;
                timeBlocking = new Date();
            }
            throw new WrongPasswordException("Неверный пароль");
        }
    }

}
