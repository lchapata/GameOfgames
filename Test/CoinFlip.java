//package coinflip;
import java.util.Scanner;
import java.util.Random;

/** This class is for the mini-game CoinFlip, within the Game of Games
 * @author Lincoln Chapata
 * @author Pranick Chamlagai
 * @Version 1.0, 12/4/2022
 */

public class CoinFlip {

    // INSTANCE VARIABLES
    int bestOf;
    int computerPoints;
    int playerPoints;
    int result;
    char heads;
    char tails;
    String H;
    String T;
    int winningPoints;
    String winner;

    // CONSTRUCTORS:
    /**
     * Constructor for CoinFlip
     */
    public CoinFlip(){
        bestOf = 0;
        computerPoints = 0;
        playerPoints = 0;
        heads = 'H';
        tails = 'T';
        H = String.valueOf(heads);
        T = String.valueOf(tails);
        winningPoints = 0;
        winner = "";
    }

    // METHODS:
    /**
     * Plays through the game
     * @return String        winner of the game
     */
    public String play(){
        // game description:
        System.out.println("Welcome to Coin Flip! You will be prompted to choose an odd best out of number for how many rounds you are going to play. You will choose either heads or tails and the computer will default to whichever side you don’t choose. You will play till you have no more rounds left.");
        GetInput user_Input = new GetInput();
        Random randomNum = new Random();                        // generate the result randomly
        int return_value = (user_Input.getBestOutOf()+1)/2;

        result = randomNum.nextInt(2);
        if (result==0)
          System.out.println("The coin is going to land on heads.");
        else
          System.out.println("The coin is going to land on tails.");
        String guess = user_Input.getCoinGuess();
        playGame(return_value, guess);
        return getWinner();
    }


    /**
     * Plays through the game
     * @param winningPoints        the amount needed to win the game (more than half the best of number)
     * @param guesses              the player's guess (i.e. Heads or Tails)
     */
    public void playGame(int winningPoints, String guess){
       //checkk if the bestof is odd

            GetInput user_Input = new GetInput();                                        // create a GetInput for receiving values from the user

           if (guess.equals(H) || guess.equals(T) ){
               System.out.println("Fliping coin....: ");                                // flip the coin

               if ((result==0)&&(guess.equals(H))){
                   System.out.println("It's heads!:Player won a point. ");
                   playerPoints++;
               }
               else if ((result==0)&&(guess.equals(T))){
                   System.out.println("It's heads!:Computer won a point. ");
                   computerPoints++;
               }
               else if ((result==1)&&(guess.equals(T))){
                   System.out.println("It's tails!:Player won a point. ");
                   playerPoints++;
               }
               else if ((result==1)&&(guess.equals(H))){
                   System.out.println("It's tails!:computer won a point. ");
                   computerPoints++;
               }
           }


            while ((playerPoints < winningPoints) && (computerPoints < winningPoints)){  // keep playing until someone has enough points to win
               String new_guess = user_Input.getCoinGuess();
               playGame(winningPoints, new_guess);
            }

        }

        /**
        * Finds the winner of the game
        * @return String              the winner of the game (either "user" or "computer")
        */
        public String getWinner(){
          if (computerPoints>playerPoints){                                             // if the computer won
            System.out.println("Computer wins! ");
            winner = "Computer wins!";
          }

          if (computerPoints<playerPoints){                                             // if the user won
            System.out.println("User wins! ");
            winner = "User wins!";
          }
          return winner;                                                                // returns the winner
        }
}
