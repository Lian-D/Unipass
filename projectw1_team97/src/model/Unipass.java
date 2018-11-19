package model;

import java.util.Scanner;

public class Unipass {
    private String securityKey;
    private int tries;

    public Unipass() {
        this.securityKey = "passwords";
        this.tries = 3;
    }
    //Requires: non-null password
    //modifies: nothing
    //effects: verifies the password with the unipass password
    public boolean passwordVerificiation(String password){
        return (password.equals(this.securityKey));
    }

}
