package ru.sbt.javaschool.exceptions.terminal;

/**
 * Created by Никита on 04.08.2016.
 */
public class Account {
    private final String account;
    private final boolean locked;
    private final boolean closed;
    private double balance;

    public Account(String account, boolean locked, boolean closed, double balance) {
        this.account = account;
        this.locked = locked;
        this.closed = closed;
        this.balance = balance;
    }

    public String getAccount() {
        return account;
    }

    public boolean isLocked() {
        return locked;
    }

    public boolean isClosed() {
        return closed;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
