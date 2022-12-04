import java.util.Random;
import java.util.Scanner;

/** This class is for the mini-game FindRedThread, within the Game of Games
 * @author Sarah Durkee
 * @Version 1.0, 12/4/2022
 */

public class FindRedThread {

  // instance variables:
  int spoolsPerGuess;
  String winner;
  int red;
  boolean found;

  // CONSTRUCTORS:
  /**
   * Constructor for CoinFlip
   */
  public FindRedThread() {
    Random rand = new Random();
    red = rand.nextInt(19);      //randomly generates what int will be represented for the red spool
    System.out.println("The red spool is at index: " + red);
    spoolsPerGuess = -1;
    winner = "";
    found = false;
    }

    // METHODS
    /**
     * Runs through the turn of the player
     * @param guesses        this integer array represents the guesses the user inputed
     */
    private void playerTurn(int[] guesses) {
      for (int i=0; i<guesses.length; i++){
        if(guesses[i]==red){                          // if they guessed the red thimble
          System.out.println("User wins!");           // the user wins
          winner = "User wins!";
          found = true;
        }
      }
    }

    /**
     * Runs through the turn of the computer
     */
    private void computerTurn() {
      Random rand = new Random();
      int[] guesses = new int[spoolsPerGuess];        // create an array to hold the guesses in
      for(int i=0; i<spoolsPerGuess; i++){
        guesses[i] = rand.nextInt(19);                // randomly generate the computer's guesses
        for(int j=0; j<i; j++){
          if(guesses[j]==guesses[i]){                 // if they have already guessed a number
            guesses[i] = rand.nextInt(19);            // generate another random number instead
          }
        }
        System.out.print(guesses[i] + " ");           // display the computer's guesses
      }
      System.out.println();

      for(int i=0; i<guesses.length; i++){
        if(guesses[i]==red){                          // if the computer guessed the red thread
          System.out.println("Computer wins!");
          winner = "Computer wins!";                  // the computer wins
          found = true;
        }
      }
    }

    /**
    * Finds the winner of the game
    * @return String              the winner of the game (either "user" or "computer")
    */
    private String getWinner(){
      return winner;
    }

    /**
     * Consists of the gamplay for the Find the Red Thread. All the methods are incorporated within the play.
     * @return String           the winner of the game
     */
    public String play() {

      Scanner sc = new Scanner(System.in);
      GetInput input = new GetInput();

      // Display the description
      System.out.println("Welcome to Find the Red Thread!");
      System.out.println("The user will be prompted to input an integer from 1-10 for the range of threads to be puled from the box.");
      System.out.println("The user will then be asked to input an integer from 1-10 to chose the number of spools to be pulled each round.");
      System.out.println("The computer will then choose a valid integer from 1-10 as well.");
      System.out.println("If the user's guess includes the red thimble, the user will win.");
      System.out.println("Otherwise if the computer's guess includes the red thimble, the computer wins.");
      System.out.println();

      // Get the number of spools that can be picked
      System.out.println("Enter a specific integer between 1 and 10 to represent the range of threads to be pulled from the box");
      spoolsPerGuess = input.getNumOfSpools();

      // until the red thread is found, alternate the user and computer's turn to pick spools
      while (found != true){
        System.out.println("Enter your valid guesses based on the number of spools drawn within the valid range:");
        playerTurn(input.spoolGuesses());

        if (found != true) {
          System.out.println();
          System.out.println("It is the computer's turn. The computer chooses spool(s): ");
          computerTurn();
        }
      }
      return getWinner();                   // return the winer of the game
    }

    }
