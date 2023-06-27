package za.co.wethinkcode.mastermind;

import java.io.InputStream;
import java.util.Scanner;

public class Player {
    private final Scanner inputScanner;
    private boolean quit = false;
    private int numberGuesses = 12;

    public int getTurns() {return numberGuesses;}

    public void lostATurn() {
        if (!this.hasNoTurn()) {
            this.numberGuesses --;
        }
    }

    public boolean hasNoTurn() {return this.getTurns() == 0;}

    public Player(){
        this.inputScanner = new Scanner(System.in);
    }

    public Player(InputStream inputStream){
        this.inputScanner = new Scanner(inputStream);
    }

    /**
     * Gets a guess from user via text console.
     * This must prompt the user to re-enter a guess until a valid 4-digit string is entered, or until the user enters `exit` or `quit`.
     *
     * @return the value entered by the user
     */
    public String getGuess() {
        while (true) {
            System.out.println("Input 4 digit code:");
            String guess = inputScanner.nextLine();
            if (evaluateUserInputExitQuit(guess)) {
                this.quit = true;
                return guess;
            }
            else if (checksLengthOfUserInput(guess) && userInputTurnedIntoIntegers(guess)
            && userInputWithinSpecifiedRange(guess)) {
                return guess;
            } else {
                System.out.println("Please enter exactly 4 digits (each from 1 to 8).");
            }
        }

    }
// Checks if userinput is quit or exit
    public boolean evaluateUserInputExitQuit(String guess) {
        return guess.equalsIgnoreCase("quit")
                || guess.equalsIgnoreCase("exit");
    }

    public boolean wantsToQuit() { return this.quit;}

// Checks the length of the user input
    public boolean checksLengthOfUserInput(String guess) {
        return guess.length() == 4;
    }

// Checks if the userinput is a number
    public boolean userInputTurnedIntoIntegers(String guess) {
        try { Integer.parseInt(guess);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
// Checks if the userinput is in the specified range
    public boolean userInputWithinSpecifiedRange(String guess) {
        return !(guess.contains("0") || guess.contains("9"));
    }

}
