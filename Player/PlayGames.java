import java.io.*;
import java.util.Scanner;

/**
  * This is the class for the Game of Games. Provides access to the games: GuessTheNumber, FindTheThimble, FindRedThread, CoinFlip, and EvenOrOdd
  * @author Eduardo Sanchez-Carrion
  * @author Sarah Durkee
  * @author Lincoln Chapata
  * @author Pranick Chamlagai
  * @Version 1.0, 12/4/2022
  */

public class PlayGames {

  // INSTANCE VARIABLES
  private static int userPoints;
  private static int computerPoints;
  private static String continueChoice;
  private static int gameChoice;
  private static String winner;

  // create scanner for this class
  Scanner sc = new Scanner(System.in);

  /**
   * Constructs a new PlayGames instance.
   */
  public PlayGames() {
    userPoints = 0;
    computerPoints = 0;
    continueChoice = "";
    gameChoice = 0;
    winner = "";
  }

  /**
   * Displays the overall scoreboard after a game is played.
   */
  private void displayScoreboard(){
    System.out.println("Scoreboard:");
    System.out.println("\tUser: " + userPoints + " points");
    System.out.println("\tComputer: " + computerPoints + " points");
  }

  /**
   * Displays the winner of Game of Games.
   */
  private void displayWinner() {
    if (userPoints > computerPoints) {
      System.out.println("User wins!");
    }
    else if (userPoints < computerPoints) {
      System.out.println("Computer wins!");
    }
    else {
      System.out.println("It's a tie!");
    }
  }

  /**
   * Main method. Plays through the Game of Games.
   */
  public static void main(String[] args) {
    PlayGames gameOfGames = new PlayGames();
    GetInput input = new GetInput();
    System.out.println("Welcome to the Game Of Games.");

    do {
      gameChoice = input.selectGame();
      System.out.println("");

      if (gameChoice == 1) {
        FindTheThimble game = new FindTheThimble();
        winner = game.play();
      }
      else if (gameChoice == 2) {
        CoinFlip game = new CoinFlip();
        winner = game.play();
      }
      else if (gameChoice == 3) {
        GuessTheNumber game = new GuessTheNumber();
        winner = game.play();
      }
      else if (gameChoice == 4) {
        EvenOrOdd game = new EvenOrOdd();
        winner = game.play();
      }
      else if (gameChoice == 5) {
        FindRedThread game = new FindRedThread();
        winner = game.play();
      }

      if (winner == "User wins!") {
        userPoints += 1;
      }
      else {
        computerPoints += 1;
      }
      gameOfGames.displayScoreboard();
      continueChoice = input.continuePlaying();

    } while (continueChoice.equals("Y"));

    gameOfGames.displayWinner();
  }
}
