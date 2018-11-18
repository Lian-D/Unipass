package Tests;

import accountType.Account;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountTests {
    @BeforeEach
    public void runBeforeAccountTests() {
        Account tester = new Account("testerhost", "testeruser", "testerpass");
    }

    @Test
    public void testprintuserdata() {
        Account tester = new Account("testerhost", "testeruser", "testerpass");
        String host = tester.getHost();
        String user = tester.getUser();
        String password = tester.getPass();
        assertEquals(host, "testerhost", "host function does not match");
        assertEquals(user, "testeruser", "user function does not match");
        assertEquals(password, "testerpass", "password function does not match");
    }

    @Test
    public void testsetuserdata() {
        Account tester = new Account("testerhost", "testeruser", "testerpass");
        //Checks initial string correct
        String host = tester.getHost();
        String user = tester.getUser();
        String password = tester.getPass();
        assertEquals(host, "testerhost");
        assertEquals(user, "testeruser");
        assertEquals(password, "testerpass");

        //checks for string correct after changing
        tester.setHost("testerhostchanged");
        tester.setUser("testeruserchanged");
        tester.setPass("testerpasschanged");
        String newhost = tester.getHost();
        String newuser = tester.getUser();
        String newpassword = tester.getPass();
        assertEquals(newhost, "testerhostchanged", "host was not changed");
        assertEquals(newuser, "testeruserchanged", "user was not changed");
        assertEquals(newpassword, "testerpasschanged", "password was not changed");
    }



}
