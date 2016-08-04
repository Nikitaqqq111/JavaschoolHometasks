package ru.sbt.javaschool.exceptions.terminal;

/**
 * Created by Никита on 04.08.2016.
 */
public interface TerminalServer {
    void debitAccount(String client, double amount) throws TerminalServerException;
    void creditAccount(String client, double amount) throws TerminalServerException;
    double getBalanceOfAccount(String client) throws TerminalServerException;
}
