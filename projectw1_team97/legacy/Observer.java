package ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Observer implements java.util.Observer {
    public List<Observable> storedAccounts = new ArrayList<>();


    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Accessing: "+arg);

    }
    public List<Observable> getStoredAccounts() {
        return storedAccounts;
    }
}
