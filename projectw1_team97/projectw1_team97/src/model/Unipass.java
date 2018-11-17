package model;

import exceptionClasses.TooManyCharactersException;
import exceptionClasses.OutOfTriesException;
import accountType.Account;
import ui.ConsoleUtil;
import ui.Observer;

import java.util.Map;
import java.util.Observable;
import java.util.Scanner;
import java.io.IOException;

public class Unipass extends Observable{
    private String Securitykey;
    private int tries;
    Scanner scanner = new Scanner(System.in);

    //REQUIRES: nothing
    //MODIFIES: nothing
    //EFFECTS: prints the home screen and allows you to move through the screen,
    //test for the password string to unlock next screen
    public Unipass() throws OutOfTriesException, TooManyCharactersException {
        addObserver(new Observer());
        setTries(0);
        String securitykey = "";
        ConsoleUtil.lockdisplay();
        setSecuritykey("passwords");
        secuityMenuOptions();
        System.out.println("terminating........");
        ConsoleUtil.lockdisplay();
    }

    public void secuityMenuOptions() throws OutOfTriesException, TooManyCharactersException {
        securityMenusVerificiations();
    }

    public void securityMenusVerificiations() throws OutOfTriesException, TooManyCharactersException {
        String securitykey;
        while (true) {
            System.out.println("Please enter your security key");
            System.out.println("Attempts Left " + (3 - tries));
            securitykey = scanner.nextLine();
            int code = securitykey.length();
            if (code < 10) {
                if (tries < 3) {
                    if (securitykey.equals(Securitykey)) {
                        System.out.println("unlock successful");
                        unlocked();
                    } else if (securitykey.equals("quit")) {
                        break;
                    } else
                        System.out.println("incorrect key");
                    tries++;
                } else throw new OutOfTriesException();
            }
            else throw new TooManyCharactersException();
        }
    }

    public boolean optionSelect(String option) {
        if (option.equals("accountdata")) {
            searchaccounts();
        } else if (option.equals("lock")) {
            return true;

        } else if (option.equals("lock")) {
            return true;

        } else
            System.out.println("invalid option");
        return false;
    }

    //REQUIRES: nothing
    //MODIFIES: nothing
    //EFFECTS: prints the unlock and allows you to move through the screen,
    //test for the accountadata or lock string to unlock next screen
    public void unlocked() {
        String option = "";
        ConsoleUtil.unlockeddisplay();
        while (true) {
            System.out.println("Please select your option");
            option = scanner.nextLine();

            if (optionSelect(option)) break;
        }
        System.out.println("locking....");
        ConsoleUtil.lockdisplay();
    }


    //REQUIRES: nothing
    //MODIFIES: nothing
    //EFFECTS: prints the account and allows you to move through the screen,
    //test for the host string to unlock next details
    public void searchaccounts() {
        String passcode = "";
        ConsoleUtil.useraccess();

        Map<String, Account> Accounts = null;
        try {
            Accounts = FileReader.createFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String key :  Accounts.keySet()) {
            System.out.println(key);
        }
        searchOptions(Accounts);
        return;

    }

    public void searchOptions(Map<String, Account> accounts) {
        String passcode;
        while (true) {
            passcode = scanner.nextLine();

            for (Account s :  accounts.values()) {
                String accountvalue = s.getHost();

                if (passcode.equals(accountvalue)) {
                    s.printuserdata();
                    setChanged();
                    notifyObservers(s);
                } else if (passcode.equals("back")) {
                    System.out.println("exiting......");
                    ConsoleUtil.unlockeddisplay();
                    break;
                }
            }
        }
    }

    public void ExceptionTestMethod(String securitykey) throws OutOfTriesException, TooManyCharactersException{
        int tries = 0;
        if (securitykey.length() < 10) {
            if (tries < 3) {
                if (securitykey.equals("passwords")) {
                    System.out.println("unlock successful");
                } else
                    System.out.println("incorrect key");
                tries++;
            } else throw new OutOfTriesException();

        }
        throw new TooManyCharactersException();
    }

    public void setSecuritykey(String securitykey) {
        Securitykey = securitykey;
    }

    public void setTries(int tries) {
        this.tries = tries;
    }
}
