package model;


import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import accountType.Account;

public class FileReader {
    //REQUIRES: Nothing
    //MODIFIES: SaveData.txt
    //EFFECTS: Reads the file and creates the account objects from the file
    public static Map createFile() throws IOException {
        //Intializes the fields we require
        Map<String , Account> AccountsData = new HashMap<>();
        List<String> lines = Files.readAllLines(Paths.get("savedata.txt"));
        PrintWriter writer = new PrintWriter("savedata.txt", "UTF-8");
        Encryption encryptor = new Encryption("GenerateCodeHere");
//
//        lines.add("Google " + encryptor.encrypt("Username1") + " " + encryptor.encrypt("Password1"));
//        lines.add("Snapchat " + encryptor.encrypt("Username2") + " " + encryptor.encrypt("Password2"));
//        lines.add("Facebook " + encryptor.encrypt("Username3") + " " + encryptor.encrypt("Password3"));
//        lines.add("Instagram " + encryptor.encrypt("Username4") + " " + encryptor.encrypt("Password4"));

        for (String line : lines) {
            ArrayList<String> partsOfLine = splitOnSpace(line);
            String h = partsOfLine.get(0);
            String u = partsOfLine.get(1);
            String p = partsOfLine.get(2);
            Account newacc = new Account(h , encryptor.decrypt(u), encryptor.decrypt(p));
            writer.println(line);
            AccountsData.put(h,newacc);
        }
        writer.close();
        return AccountsData;
    }
    //REQUIRES: Nothing
    //MODIFIES: SaveData.txt
    //EFFECTS: Reads the file and adds the account objects from the file
    public static void addnewaccountdata(Account acc) throws  IOException {
        while (true) {
            List<String> lines = Files.readAllLines(Paths.get("savedata.txt"));
            PrintWriter writer = new PrintWriter("savedata.txt", "UTF-8");
            Encryption encryptor = new Encryption("GenerateCodeHere");

            String storedata = acc.getHost() + " " + encryptor.encrypt(acc.getUser()) + " " + encryptor.encrypt(acc.getPass());
            lines.add(storedata);
            writer.close();
        }
    }

    public static ArrayList<String> splitOnSpace(String line) {
        String[] splits = line.split(" ");
        return new ArrayList<>(Arrays.asList(splits));
    }
}