package accountType;

import interfaces.AccountGetters;
import interfaces.AccountMods;

import java.util.Objects;

public abstract class GeneralAccount implements AccountMods, AccountGetters {
    private String host;
    private String user;
    private String pass;

    //REQUIRES: String, String, String, detailing the host, username and password
    //MODIFIES: The Account List
    //EFFECTS: constructs the Account, passing the Host, Username and Password
    public GeneralAccount(String host, String user, String pass) {
        this.host = host;
        this.user = user;
        this.pass = pass;
    }

    //REQUIRES: Nothing
    //MODIFIES: Nothing
    //EFFECTS: prints the user data of said account
    public void printuserdata() {
        System.out.println("Host: " + host);
        System.out.println("Account: " + user);
        System.out.println("Pass: " + pass);
    }

    //REQUIRES: Nothing
    //MODIFIES: Nothing
    //EFFECTS: returns the host of said account
    public String getHost() {
        return host;
    }

    //REQUIRES: Nothing
    //MODIFIES: Nothing
    //EFFECTS: returns the user of said account
    public void setHost(String host) {
        this.host = host;
    }


    //REQUIRES: Nothing
    //MODIFIES: Nothing
    //EFFECTS: returns the user of said account
    public String getUser() {
        return user;
    }

    //REQUIRES: Nothing
    //MODIFIES: Nothing
    //EFFECTS: sets the user of said account
    public void setUser(String user) {
        this.user = user;
    }

    //REQUIRES: Nothing
    //MODIFIES: Nothing
    //EFFECTS: returns the password of said account
    public String getPass() {
        return pass;
    }

    //REQUIRES: Nothing
    //MODIFIES: Nothing
    //EFFECTS: sets the password of said account
    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GeneralAccount that = (GeneralAccount) o;
        return Objects.equals(host, that.host) &&
                Objects.equals(user, that.user) &&
                Objects.equals(pass, that.pass);
    }

    @Override
    public int hashCode() {

        return Objects.hash(host, user, pass);
    }

    @Override
    public String toString() {
        return "GeneralAccount{" +
                "host='" + host + '\'' +
                '}';
    }
}
