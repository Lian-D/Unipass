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
        System.out.println("Storing Account Data");
        List<String> lines = Files.readAllLines(Paths.get("savedata.txt"));
        PrintWriter writer = new PrintWriter("savedata.txt", "UTF-8");
        Encryption encryptor = new Encryption("GenerateCodeHere");

        lines.add(acc.getHost() + " " + encryptor.encrypt(acc.getUser()) + " " + encryptor.encrypt(acc.getPass()));

        for (String line : lines) {
            ArrayList<String> partsOfLine = splitOnSpace(line);
            writer.println(line);
        }
        writer.close();
    }

    public static ArrayList<String> splitOnSpace(String line) {
        String[] splits = line.split(" ");
        return new ArrayList<>(Arrays.asList(splits));
    }
}