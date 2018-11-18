package model;

import accountType.Account;
import interfaces.AccountLists;

import java.util.List;

public class ListOfAccounts implements AccountLists {
    private List<Account> savedAccounts;

    public ListOfAccounts(List<Account> savedAccounts) {
        this.savedAccounts = savedAccounts;
    }

    //MODIFIES: The Account List
    //EFFECTS: ADDS the Account, passing the Host, Username and Password
    public void addAccount(String host, String user, String pass) {
        Account newAccount = new Account(host, user, pass);
        savedAccounts.add(newAccount);
    }

    public void listdata() {
        for (Account s : savedAccounts) {
            String saved = s.getHost();
            System.out.println(saved);
        }
    }

    public List<Account> getSavedAccounts() {
        return savedAccounts;
    }

    public void setSavedAccounts(List<Account> savedAccounts) {
        this.savedAccounts = savedAccounts;
    }
}





