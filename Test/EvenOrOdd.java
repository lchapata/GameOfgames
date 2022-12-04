import java.io.*;
import java.util.Scanner;
import java.util.Random;

/** This class is for the mini-game Even or Odd, within the Game of Games
 * @author Eduardo Sanchez-Carrion
 * @Version 1.0, 12/4/2022
 */

public class EvenOrOdd {

  // INSTANCE VARIABLES
  private int bestOf;
  private String playerChoice;
  private String computerChoice;
  private int playerThrow;
  private int computerThrow;
  private int playerPoints;
  private int computerPoints;
  private int sum;
  private String winner;

  // Creates scanner for the game
  Scanner sc = new Scanner(System.in);

  // CONSTRUCTORS:
  /**
   * Constructor for EvenOrOdd
   */
  public EvenOrOdd() {
    bestOf = 0;
    playerChoice = "";
    computerChoice = "";
    playerThrow = 0;
    computerThrow = 0;
    playerPoints = 0;
    computerPoints = 0;
    sum = 0;
    winner = "";
  }

  // METHODS:
  /**
   * Randomply generates an integer between 1 and 5. This will be the throw for the computer in that round.
   * @return int          the computer's number thrown in the round
   */
  private int compThrow() {
    Random r = new Random();
    computerThrow = (r.nextInt(5)) + 1;                               // generates the computer's throw
    System.out.println("Computer's choice: " + computerThrow);        // display's the computer's throw
    return computerThrow;
  }

  /**
   * Calculates the sum between the user's throw and the computer's throw.
   * @return int        the sum of numbers thrown
   */
  private int setSum() {
    sum = computerThrow + playerThrow;                                  // sum of user's and computer's throws
    return sum;
  }

  /**
   * Checks the sum and sees if it's odd or even. A point is awared to the player with the correct choice.
   */
   private void checkSum() {
     if (sum % 2 == 0) {
       if (playerChoice.equals("E")) {                               // if the player chose even and it is even
         playerPoints += 1;
       }
       else {                                                        // if the sum is even and the player did not choose even
         computerPoints += 1;
       }
     }
     else {                                                          // if the sum is not even
       if (playerChoice.equals("O")) {
         playerPoints += 1;
       }
       else {
         computerPoints += 1;
       }
     }
     System.out.println("Player Points: " + playerPoints + ", Computer Points: " +computerPoints);
   }

  /**
   * Compares the user and computer points to the best out of number to see if one of them has reached it.
   * @return true  if best out of number was reached; false if another round has to be played
   */
  private boolean isFinished() {
    if ((playerPoints == (bestOf/2 +1)) || (computerPoints == (bestOf/2 +1))) {     // has one of the players gained enough points to win the game
      return true;
    }
    return false;
  }

  /**
   * Checks to see who reached the best out of number and returns the winner.
   * @return String  the winner of the game
   */
   public String getWinner() {
     if (playerPoints == (bestOf/2 +1)) {                                            // if the winner has more points
       winner = "User wins!";                                                        // set the user as the winner
     }
     else {
       winner = "Computer wins!";                                                    // otherwise, set the computer as the winner
     }

     return winner;
   }

  /**
   * Consists of the gamplay for the game even or odd. All the methods are incorporated within the play.
   * @return String  the winner of the game
   */
  public String play() {
    GetInput input = new GetInput();                                                // create a GetInput to use for the play

    // Game Description (S01)
    System.out.println("Welcome to Even and Odd! You will be prompted to choose an odd best out of number for how many rounds you are going to play. The user will choose to be either even or odd. The user will input an integer from 1-5 and the computer will do the same. The sum of those 2 numbers will be either even or odd and depending on what you chose to be, you will get the point. You will play till you have no more rounds left.");

    // S02-03
    bestOf = input.getBestOutOf();

    // S04-05
    playerChoice = input.getChoice();
    if (playerChoice.equals("E")) {
      computerChoice = "O";
    }
    else if (playerChoice.equals("O")) {
      computerChoice = "E";
    }

    do {
      // S06-12
      compThrow();
      playerThrow = input.userThrow();
      setSum();
      checkSum();
    } while (isFinished() == false);     // S13

    // S14-15
    System.out.println(getWinner());
    return getWinner();
  }

}
