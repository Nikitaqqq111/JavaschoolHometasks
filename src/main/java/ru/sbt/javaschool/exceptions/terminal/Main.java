package ru.sbt.javaschool.exceptions.terminal;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Никита on 05.08.2016.
 */
public class Main {
    private static PinValidator pinValidator;
    private static TerminalServer terminalServer;
    private static Terminal terminal;

    private static void initializePinValidatorAndTerminalServer() {
        Map<String, String> loginsAndPasswords = new HashMap<>();
        loginsAndPasswords.put("Nikita", "12345");
        loginsAndPasswords.put("Alex", "77777");
        loginsAndPasswords.put("Mary", "54321");
        loginsAndPasswords.put("Ed", "00000");
        pinValidator = new PinValidatorImpl(loginsAndPasswords);
        Account accountOfNikita = new Account("42300000000000000000", false, false, 200);
        Account accountOfAlex = new Account("42300000000000000001", true, false, 50);
        Account accountOfMary = new Account("42300000000000000000", false, true, 100);
        Account accountOfEd = new Account("42300000000000000000", true, true, 100);
        Map<String, Account> accountBalanceOfClients = new HashMap<>();
        accountBalanceOfClients.put("Nikita", accountOfNikita);
        accountBalanceOfClients.put("Alex", accountOfAlex);
        accountBalanceOfClients.put("Mary", accountOfMary);
        accountBalanceOfClients.put("Ed", accountOfEd);
        terminalServer = new TerminalServerImpl(accountBalanceOfClients);
        terminal = new TerminalImpl(pinValidator, terminalServer);
    }

    public static void main(String[] args) {
        //initializePinValidatorAndTerminalServer();
        /*terminal.balanceOfAcc("Nikita"); //err: Был не выполнен вход в систему
        terminal.logOn("Nikita", "12345"); //out: Вход в систему выполнен
        terminal.balanceOfAcc("Nikita");
        terminal.creditAcc("Nikita", 100); //err: Был не выполнен вход в систему Необходимо снова логиниться, чтобы снять деньги*/
        /*terminal.logOn("Nikita", "12345"); //out: Вход в систему выполнен
        terminal.balanceOfAcc("Nikita");
        terminal.logOn("Nikita", "12345"); //out: Вход в систему выполнен
        terminal.creditAcc("Nikita", 100); //без ошибок
        terminal.logOn("Nikita", "12345"); //out: Вход в систему выполнен
        terminal.balanceOfAcc("Nikita");   //реально зачислили 100, могут быть рандомные ошибки, связанные с подключением*/
        /*terminal.logOn("Nikita", "12345"); //out: Вход в систему выполнен
        terminal.debitAcc("Nikita", 100); //без ошибок
        terminal.logOn("Nikita", "12345");
        terminal.balanceOfAcc("Nikita");  //реально сняли 100*/
        //terminal.logOn("Sam", "12345"); //err: Данного клиента не существует

        /*terminal.logOn("Ed", "gdfgdfgdfgdfg");
        terminal.logOn("Ed", "gdfgdfgdfgdfg");
        terminal.logOn("Ed", "gdfgdfgdfgdfg");
        terminal.logOn("Ed", "gdfgdfgdfgdfg"); //Три раза был веден неправильный пароль. Время разлочения __
        terminal.logOn("Ed", "gdfgdfgdfgdfg"); //Три раза был веден неправильный пароль. Время разлочения __
        terminal.logOn("Ed", "gdfgdfgdfgdfg"); //Три раза был веден неправильный пароль. Время разлочения __
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            //не должно такого быть =)
        }
        terminal.logOn("Ed", "00000"); //ждемс, а потом вход в систему выполнен*/

        /*terminal.logOn("Mary", "54321");
        terminal.creditAcc("Mary", 100); //счет заблочен, обращаемся в банк*/

        /*terminal.logOn("Alex", "77777");
        terminal.creditAcc("Alex", 400); //счет закрыт, обращаемся в call центр*/

        /*terminal.logOn("Nikita", "12345"); //out: Вход в систему выполнен
        terminal.debitAcc("Nikita", 1000); //овердрафт*/

    }}
