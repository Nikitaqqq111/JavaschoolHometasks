package ru.sbt.javaschool.exceptions.terminal;

/**
 * Created by Никита on 05.08.2016.
 */
public interface Terminal {

    void logOn(String client, String password);

    void balanceOfAcc(String client);

    void debitAcc(String client, int amount);

    void creditAcc(String client, int amount);
}
