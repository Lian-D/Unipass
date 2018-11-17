package ui;
import exceptionClasses.TooManyCharactersException;
import exceptionClasses.OutOfTriesException;
import model.Unipass;

public class Start {
    public static void main(String[] args) throws Exception {
        try {
            wikiSearch wiki = new wikiSearch();
            wiki.parseWikiJson(wiki.aquireJsonfromWeb("Communism"));
            new Unipass();
        } catch (OutOfTriesException e) {
            System.out.println("You are out of attempts");
        } catch (TooManyCharactersException e) {
            System.out.println("You Exceeded Amount Of Characters");
        } finally {
            System.out.println("Please recheck your security key and attempt to solve this program again");
        }
    }
}
