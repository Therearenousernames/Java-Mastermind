package za.co.wethinkcode.mastermind;

public class Mastermind {
    private final String code;
    private final Player player;


    public Mastermind(CodeGenerator generator, Player player){
        this.code = generator.generateCode();
        this.player = player;
    }


    public Mastermind(){this(new CodeGenerator(), new Player());}

// Runs game
    public void runGame(){
        System.out.println("4-digit Code has been set. Digits in range 1 to 8. You have 12 turns to break it.");
        while (!player.hasNoTurn()) {
            String guess = player.getGuess();
            if (player.wantsToQuit()) {
                break;
            } else if (guess.equals(this.code)) {
                evaluateCodeVsGuess(guess, code);
                System.out.println("Congratulations! You are a codebreaker!");
                System.out.println("The code was: " + code);
                break;
            } else {
                player.lostATurn();
                evaluateCodeVsGuess(guess, code);
                if (!player.hasNoTurn()) {
                    System.out.println("Turns left: "+ player.getTurns());
                } else if (player.hasNoTurn()) {
                    System.out.println("No more turns left.");
                    System.out.println("The code was: " + code);
                    break;
                }
            }
        }
    }

// Evaluates code vs guess
    public void evaluateCodeVsGuess(String guess, String code) {
        String messageCorrect = messagingAfterCorrectCorrect(guess,code);
        String messageIncorrect = messagingAfterCorrectIncorrect(guess, code);
        System.out.println(messageCorrect);
        System.out.println(messageIncorrect);
    }

// Calculates the number of correct values in incorrect places
    public static Integer correctValueInCorrectPlace(String guess, String code) {
        int correctIncorrectPlace = 0;
        int correctCorrectPlace= 0;
        for (int i = 0; i < code.length(); i++) {
            if (guess.charAt(i) == code.charAt(i)) {
                correctCorrectPlace ++;
            } else if (code.contains(String.valueOf(guess.charAt(i)))) {
                correctIncorrectPlace++;
            }
        }
        return correctIncorrectPlace;
    }

    // Calculates the number of correct values in correct places
    public static Integer correctValueCorrectPlace(String guess, String code) {
        int correctIncorrectPlace = 0;
        int correctCorrectPlace = 0;
        for (int i = 0; i < code.length(); i++) {
            if (guess.charAt(i) == code.charAt(i)) {
                correctCorrectPlace ++;
            } else if (code.contains(String.valueOf(guess.charAt(i)))) {
                correctIncorrectPlace ++;
            }
        }
        return correctCorrectPlace;
    }

// prints out the message for correct but incorrect place
    public static String messagingAfterCorrectIncorrect(String guess, String code) {
        int correctIncorrectPlace = correctValueInCorrectPlace(guess, code);
        return "Number of correct digits not in correct place: " + correctIncorrectPlace;
    }

// prints out the message for correct and correct place
    public static String messagingAfterCorrectCorrect(String guess, String code) {
        int correctCorrectPlace = correctValueCorrectPlace(guess, code);
        return "Number of correct digits in correct place: " + correctCorrectPlace;
    }

    public static void main(String[] args){
        Mastermind game = new Mastermind();
        game.runGame();
    }
}
