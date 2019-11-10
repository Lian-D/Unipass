import exceptionClasses.TooManyCharactersException;
import exceptionClasses.OutOfTriesException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class ExceptionsTest {

    public String ExceptionTestMethod(String securitykey, Integer tries) throws OutOfTriesException, TooManyCharactersException {
        if (securitykey.length() < 10) {
            if (tries < 3) {
                if (securitykey.equals("passwords")) {
                    return "1";
                } else
                    return "2";
            } else throw new OutOfTriesException();
        }
        throw new TooManyCharactersException();
    }

    @Test
    public void TestForCorrectPass() {
        try {
            String value = ExceptionTestMethod("passwords", 0);
            assertEquals("1", value);

        } catch (TooManyCharactersException e) {
           fail("Something went wrong with too many characters");

        } catch (OutOfTriesException e) {
            fail("Something went wrong with too many tries");
        }
        finally {
            System.out.println("Solved!");
        }
    }

    @Test
    public void TestForTooManyCharacters() {
        String key = "passwordsaretoolong";
        try {
            String value = ExceptionTestMethod(key, 4);
        } catch (TooManyCharactersException e) {
            assertEquals(1,1);
        } catch (OutOfTriesException e) {
            fail("Something went wrong with too many tries");
        }
        finally {
            System.out.println("Solved!");
        }
    }

    @Test
    public void TestForTooManyTries() {
        String key = "passwords";
        try {
            String value = ExceptionTestMethod(key, 4);
        } catch (TooManyCharactersException e) {
            fail("Something Went Wrong with too many characters");
        } catch (OutOfTriesException e) {
            assertEquals(1,1);
        }
        finally {
            System.out.println("Solved!");
        }
    }
}

