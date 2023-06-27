package za.co.wethinkcode.mastermind;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    public void LengthUserInput() {
        Player player = new Player();

        assertTrue(player.checksLengthOfUserInput("1234"));
        assertFalse(player.checksLengthOfUserInput("abc"));
    }

    @Test
    public void WithinSpecifiedRange() {
        Player player = new Player();

        assertFalse(player.userInputWithinSpecifiedRange("9215"));
        assertFalse(player.userInputWithinSpecifiedRange("0123"));
        assertFalse(player.userInputWithinSpecifiedRange("9023"));
        assertTrue(player.userInputWithinSpecifiedRange("1234"));
    }

    @Test
    public void guessIntegers() {
        Player player = new Player();

        assertFalse(player.userInputTurnedIntoIntegers("abcd"));
        assertFalse(player.userInputTurnedIntoIntegers("ad3bd"));
        assertTrue(player.userInputTurnedIntoIntegers("1234"));
    }

    @Test
    public void guessEqualsQuit() {
        Player player = new Player();

        assertTrue(player.evaluateUserInputExitQuit("quit"));
        assertFalse(player.evaluateUserInputExitQuit("hello"));

    }

    @Test
    public void guessEqualsExit() {
        Player player = new Player();

        assertTrue(player.evaluateUserInputExitQuit("exit"));
        assertFalse(player.evaluateUserInputExitQuit("off"));
    }

    @Test
    public void ShouldStartWith12Turns() {
        Player player = new Player();
        assertEquals(12, player.getTurns());
    }

    @Test
    public void canLoseATurn() {
        Player player = new Player();
        int turns = player.getTurns();
        player.lostATurn();
        assertEquals(turns-1, player.getTurns());
    }

    @Test
    public void noMoreTurns() {
        Player player = new Player();
        int turns = player.getTurns();
        for (int i = 0; i < turns; i++) {
            assertFalse(player.hasNoTurn());
            player.lostATurn();
        }
    }

    @Test
    public  void cannotLoseTurnIfNoneAvailable() {
        Player player = new Player();
        int turns = player.getTurns();
        for (int i = 0; i < turns + 2; i++) {
            player.lostATurn();
        }
        assertEquals(0, player.getTurns());
    }


}