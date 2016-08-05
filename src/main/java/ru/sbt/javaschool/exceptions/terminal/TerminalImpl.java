package ru.sbt.javaschool.exceptions.terminal;

/**
 * Created by Никита on 05.08.2016.
 */
public class TerminalImpl implements Terminal {

    private final PinValidator pinValidator;

    private final TerminalServer terminalServer;

    private boolean isLogOn;

    public TerminalImpl(PinValidator pinValidator, TerminalServer terminalServer) {
        this.pinValidator = pinValidator;
        this.terminalServer = terminalServer;
        this.isLogOn = false;
    }

    @Override
    public void logOn(String client, String password) {
        try {
            pinValidator.validate(client, password);
            System.out.println("Вход в систему выполнен");
            isLogOn = true;
        } catch (PinValidatorException e) {
            System.err.println(e.getMessage());
            System.err.println(e.getCause().getMessage());
        }
    }

    private void isLogOnWithException() throws NotLogOnException {
        if (!isLogOn) {
            throw new NotLogOnException("Был не выполнен вход в систему");
        }
    }

    @Override
    public void balanceOfAcc(String client) {
        try {
            isLogOnWithException();
            System.out.println(terminalServer.getBalanceOfAccount(client));
        } catch (TerminalServerException e) {
            System.err.println(e.getMessage());
            System.err.println(e.getCause().getMessage());
        } catch (TerminalException e) {
            System.err.println(e.getMessage());
        } finally {
            isLogOn = false;
        }
    }

    @Override
    public void debitAcc(String client, int amount) {
        try {
            isLogOnWithException();
            isAmoundMod(amount);
            terminalServer.debitAccount(client, amount);
        } catch (TerminalServerException e) {
            System.err.println(e.getMessage());
            System.err.println(e.getCause().getMessage());
        } catch (TerminalException e) {
            System.err.println(e.getMessage());
        } finally {
            isLogOn = false;
        }
    }

    @Override
    public void creditAcc(String client, int amount) {
        try {
            isLogOnWithException();
            isAmoundMod(amount);
            terminalServer.creditAccount(client, amount);
        } catch (TerminalServerException e) {
            System.err.println(e.getMessage());
            System.err.println(e.getCause().getMessage());
        } catch (TerminalException e) {
            System.err.println(e.getMessage());
        } finally {
            isLogOn = false;
        }
    }

    private void isAmoundMod(int amount) throws NotModAmountException {
        if (amount % 100 != 0) {
            throw new NotModAmountException("Сумма не кратна 100");
        }
    }
}
