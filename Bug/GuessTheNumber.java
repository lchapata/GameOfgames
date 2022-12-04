import java.util.Scanner;
import java.util.Random;

/*
 * This class is for the mini-game GuessTheNumber, within the Game of Games
 * @author Pranick Chamlagai
 * @Version 1.0, 12/4/2022
 */

public class GuessTheNumber{

    // INSTANCE VARIABLES
    int range_num;
    int totalGuesses;
    int playerGuess;
    int number;
    String winner;

    // CONSTRUCTORS
    /**
     * This is a constructor for GuessTheNumber
     */
    public GuessTheNumber(){
        range_num = 0;
        totalGuesses = 0;
        playerGuess = 0;
        number = 0;
        winner = "";
    }

    /**
     * Gets the random number betweem 1 and the max of range
     * @return int, the random number between 1 and max of range
    */
    public int ComputerNumber(int range_return){
        //assigning random number
        Random rand = new Random();
        number = rand.nextInt((range_return - 1) + 1) + 1;                      //assigning random number
        System.out.println("Random number: " + number);

        return number;
    }


    /**
     * Implements the game and then returns the winner of the game
     * param1: int, random number between 1 and max of range
     * param2: int, no of guesses allowed
     * param3: int, guess made by the player
     *@return String, the winner of the game
     */
    public String implement(int randomNum_return, int guess_return, int player_return){
         number = randomNum_return;
         int attempts = guess_return;
         int guessed_num;

         for (int i = 0; i < attempts - 1; i++) {
             guessed_num = player_return;

             if ((guessed_num == number)){
                 winner = "User wins!";
                 break;
             }
             else if ((i == attempts - 2) && (guessed_num != number)){
                winner = "Computer wins!";
             }
         }
        return winner;
     }

     /**
      * Consists of the gamplay for the game guess the number. All the methods are incorporated within the play.
      * @return String  the winner of the game
      */
    public String play(){
        String final_winner = "";
        GetInput player_input = new GetInput();
        System.out.println("Welcome to Guess the Number! You will be prompted to choose the range of numbers you want it to go to. You then will choose the number of guesses you get for the game. You win the game if you guess the number before you run out of guesses.");
        int range_return = player_input.GetRangeNumber();
        int guess_return = player_input.GetGuessNumber();
        int randomNum_return = ComputerNumber(range_return);
        int attempts = guess_return;

        for (int i = 0; i < attempts ; i++){
            int player_return = player_input.GetPlayerNumber();
            final_winner = implement(randomNum_return, guess_return, player_return);
            if (final_winner.equals("User wins!")){
                break;
            }
        }
        System.out.println(final_winner);
        return final_winner;
    }
}
