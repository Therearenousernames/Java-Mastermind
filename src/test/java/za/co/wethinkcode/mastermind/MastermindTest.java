package za.co.wethinkcode.mastermind;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static za.co.wethinkcode.mastermind.Mastermind.*;


public class MastermindTest {

    @Test
    public void checkingCorrectValueInCorrectPlace() {
        assertEquals(0,correctValueInCorrectPlace("5678", "1234"));
        assertEquals(2, correctValueInCorrectPlace("7345", "2417"));

    }

    @Test
    public void checkingCorrectValueCorrectPlace() {
        assertEquals(1, correctValueCorrectPlace("1234","2136"));
        assertEquals(2, correctValueCorrectPlace("4593", "6893"));
    }

    @Test
    public void outputMessageCorrectPlace() {
        assertEquals("Number of correct digits in correct place: " + 2, messagingAfterCorrectCorrect("1234", "1265"));
        assertEquals("Number of correct digits in correct place: " + 4, messagingAfterCorrectCorrect("1234", "1234"));
        assertEquals("Number of correct digits in correct place: " + 1, messagingAfterCorrectCorrect("5678", "5234"));
    }

    @Test
    public void outputMessageIncorrectPlace() {
        assertEquals("Number of correct digits not in correct place: "+ 3, messagingAfterCorrectIncorrect("1234", "2345"));
        assertEquals("Number of correct digits not in correct place: "+1, messagingAfterCorrectIncorrect("1234","7189"));
    }

    @Test
    public void simulatingTheGame() {

    }

}
