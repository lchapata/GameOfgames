import java.io.*;
import java.util.Scanner;
import java.util.Random;

/** This class includes the methods needed to play the mini-game of Game of Games, Find the Thimble.
  * @author Eduardo Sanchez-Carrion
  * @Version 1.0, 12/4/2022
 */

public class FindTheThimble {

  // INSTANCE VARIABLES
  private int bestOf;
  private String hand;
  private String playerChoice;
  private int playerPoints;
  private int computerPoints;
  private String winner;

  // create a scanner for the game
  Scanner sc = new Scanner(System.in);

  // CONSTRUCTORS
  /**
   * Constructor for FindTheThimble
   */
  public FindTheThimble() {
    bestOf = 0;
    hand = "";
    playerChoice = "";
    playerPoints = 0;
    computerPoints = 0;
    winner = "";
  }

  // METHODS
  /**
   * Places the thimble on the left or right side.
   */
  private void placeThimble() {
    String[] choice = {"L", "R"};

    Random r = new Random();
    hand = choice[r.nextInt(choice.length)];                  // randomly generates which side the thimble is on
  }

  /**
   * Checks the user's guess to the correct hand that contains the thimble.
   */
  public void checkGuess() {
    if (playerChoice.equals(hand)) {
      playerPoints += 1;
    }
    else {
      computerPoints += 1;
    }
    System.out.println("Player Points: " + playerPoints + ", Computer Points: " +computerPoints);
  }

  /**
   * Compares the user and computer points to the best out of number to see if one of them has reached it.
   * @return true         if best out of number was reached; false if another round has to be played
   */
  private boolean isFinished() {
    if ((playerPoints == (bestOf/2 +1)) || (computerPoints == (bestOf/2 +1))) {
      return true;
    }
    return false;
  }

  /**
   * Checks to see who reached the best out of number and returns the winner.
   * @return String           the winner of the game
   */
  public String getWinner() {
    if (playerPoints == (bestOf/2 +1)) {
      winner = "User wins!";
    }
    else {
      winner = "Computer wins!";
    }

    return winner;
  }

  /**
   * Consists of the gamplay for the game find the thimble. All the methods are incorporated within the play.
   * @return String  the winner of the game
   */
  public String play() {
    GetInput input = new GetInput();

    // Game Description (S01)
    System.out.println("Welcome to Find the Thimble! You will be prompted to choose an odd best out of number for how many rounds you are going to play. You will choose the left or right hand to find the thimble. You will play till you have no more rounds left.");

    // S02
    bestOf = input.getBestOutOf();

    do {
      // S03-08
      placeThimble();
      playerChoice = input.setGuess();
      checkGuess();
    } while (isFinished() == false);     // S13

    // S09-10
    System.out.println(getWinner());
    return getWinner();
  }

}
