package ru.sbt.javaschool.exceptions.terminal;

import java.util.Map;
import java.util.Random;

/**
 * Created by Никита on 04.08.2016.
 */
public class TerminalServerImpl implements TerminalServer {

    private final Map<String, Account> accountBalanceOfClients;

    public TerminalServerImpl(Map<String, Account> accountBalanceOfClients) {
        this.accountBalanceOfClients = accountBalanceOfClients;
    }

    void chechAllRules(String client) throws TerminalServerException {
        Random random = new Random();
        if (random.nextInt(10) < 3) {
            throw new BadConnectionException("Ошибка подключения к серверу. Обратитесь в техническую поддержку банка");
        }
        if (accountBalanceOfClients.get(client).isLocked()) {
            throw new BlockedAccountException("Счет закрыт. Обратитесь в ближайшее отделение банка или позвоните в call центр");
        }
        if (accountBalanceOfClients.get(client).isClosed()) {
            throw new ClosedAccountException("Счет закрыт. Обратитесь в ближайшее отделение банка");
        }

    }

    @Override
    public void debitAccount(String client, double amount) throws TerminalServerException {
        try {
            chechAllRules(client);
            if (accountBalanceOfClients.get(client).getBalance() - amount < 0) {
                throw new OverdraftException("Овердрафт по счету. Недостаточно средств для выполнения операции");
            }
        } catch (TerminalServerException ex) {
            throw new TerminalServerException("Ошибка при работе с сервером: ", ex);
        }
        accountBalanceOfClients.get(client).setBalance(accountBalanceOfClients.get(client).getBalance() - amount);
    }

    @Override
    public void creditAccount(String client, double amount) throws TerminalServerException {
        try {
            chechAllRules(client);
        } catch (TerminalServerException ex) {
            throw new TerminalServerException("Ошибка при работе с сервером: ", ex);
        }
        accountBalanceOfClients.get(client).setBalance(accountBalanceOfClients.get(client).getBalance() + amount);
    }

    @Override
    public double getBalanceOfAccount(String client) throws TerminalServerException {
        try {
            chechAllRules(client);
        } catch (TerminalServerException ex) {
            throw new TerminalServerException("Ошибка при работе с сервером: ", ex);
        }
        return accountBalanceOfClients.get(client).getBalance();
    }

}

