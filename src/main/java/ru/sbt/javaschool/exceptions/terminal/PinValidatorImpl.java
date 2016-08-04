package ru.sbt.javaschool.exceptions.terminal;

import java.util.HashMap;

/**
 * Created by Никита on 04.08.2016.
 */
public class PinValidatorImpl implements PinValidator{
    private final HashMap<String, String> clientsAndPasswords;

    public PinValidatorImpl(HashMap<String, String> clientsAndPasswords) {
        this.clientsAndPasswords = clientsAndPasswords;
    }

    @Override
    public void validate(String client, String password) throws PinValidatorException {
        try {
            checkClient(client);
            checkPassword(client, password);
        } catch (PinValidatorException ex) {
            throw new PinValidatorException("Ошибка валидатора: ", ex);
        }
    }

    private void checkPassword(String client, String password) throws PinValidatorException {

    }

    private void checkClient(String client) throws PinValidatorException {
        if (!clientsAndPasswords.containsKey(client)) {
            throw new NoSuchClientException("Данного клиента не существует. Проверьте правильность написания");
        }
    }
}
