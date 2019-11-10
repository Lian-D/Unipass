package ui;

public class ConsoleUtil {
    static String separationlines = "==================================================";
    static String horizontallines = "||";

    //REQUIRES: nothing
    //MODIFIES: nothing
    //EFFECTS: prints a locked display
    public static void lockdisplay() {
        System.out.println(separationlines);
        System.out.println(horizontallines+"              Welcome to Start                "+horizontallines);
        System.out.println(separationlines);
        System.out.println(horizontallines+"    please verify your security key below     "+horizontallines);
        System.out.println(separationlines);
    }

    //REQUIRES: nothing
    //MODIFIES: nothing
    //EFFECTS: prints an unlocked display
    public static void unlockeddisplay() {
        System.out.println(separationlines);
        System.out.println(horizontallines+"              Welcome to Start                 "+horizontallines);
        System.out.println(separationlines);
        System.out.println(horizontallines+"    accountdata      lock       addaccount     "+horizontallines);
        System.out.println(separationlines);
    }



    
    //REQUIRES: nothing
    //MODIFIES: nothing
    //EFFECTS: prints an access page
    public static void useraccess() {
        System.out.println(separationlines);
        System.out.println(horizontallines+"              Welcome to Start              "+horizontallines);
        System.out.println(separationlines);
        System.out.println(horizontallines+"Account Data selected, please enter your host "+horizontallines);
        System.out.println(separationlines);
        System.out.println("Current Stored Data on Hosts ");
    }



}
