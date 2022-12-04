import java.io.*;
import java.util.Scanner;

/**
 * This class includes the methods for all the inputs in Game of Games
 * @author Eduardo Sanchez-Carrion
 * @author Sarah Durkee
 * @author Lincoln Chapata
 * @author Pranick Chamlagai
 * @Version 1.0, 12/4/2022
 */
public class GetInput {

  // INSTANCE VARIABLES
  private int gameChoice;
  private String continueChoice;
  private int bestOf;
  private String playerChoice;
  private int playerThrow;
  private String thimbleChoice;
  private int range_num;
  private int totalGuesses;
  private int playerGuess;
  private int numOfSpools;
  String guess;

  // creates a scanner for the class
  Scanner sc = new Scanner(System.in);

  // CONSTRUCTORS
  /**
   * Constructor for GetInput
   */
  public GetInput() {
    gameChoice = 0;
    continueChoice = "";
    bestOf = 0;
    playerChoice = "";
    playerThrow = 0;
    thimbleChoice = "";
    range_num = 0;
    totalGuesses = 0;
    playerGuess = 0;
    numOfSpools = 0;
    guess = "";
  }

  /**
   * Used in the Play Games class
   * Prompts the user to pick an integer between 1 and 5. This will the game they will play in the corresponding round.
   * @return int          the number of game to be played
   */
  public int selectGame() {
    System.out.print("To play the games, the user must enter 1 for Find the Thimble, 2 for Coin Flip, 3 for Guess the Number, 4 for Even and Odd, or 5 for Find the Red Thread. ");
    do {
      if ((sc.hasNextInt()) && (gameChoice = sc.nextInt()) >= 2 || ((gameChoice > 5) || (gameChoice < 1))) {
        if ((gameChoice < 6) && (gameChoice > 0)) { }
        else {
          System.out.print("Error: Enter a valid integer from 1 to 5. ");
        }
      }
      sc.nextLine();
    } while (gameChoice > 5 || gameChoice < 1);
    return gameChoice;
  }

  /**
   * Used in the Play Games class
   * Prompts the user if the want to continue and play a new game or quit.
   * @return          String  the user’s choice to keep on playing Game of Games or quit
   */
  public String continuePlaying() {
    System.out.print("Would you like to play again? Enter ‘Y’ to continue playing or ‘N’ to stop playing. ");
    do {
      continueChoice = sc.nextLine();

      if (!(continueChoice.equals("Y") || continueChoice.equals("N"))) {
        System.out.print("Error: Enter either ‘Y’ to continue playing or ‘N’ to stop playing. ");
      }

    } while (!(continueChoice.equals("Y") || continueChoice.equals("N")));
    return continueChoice;
  }


  /**
   * Used in the Even or Odd and Find the Thimble classes
   * Prompts the user to select a negative odd best out of number.
   * @return int          the best out of number to be played
   */
  public int getBestOutOf() {
    System.out.print("Choose an odd best out of number. ");
    do {
      if ((sc.hasNextInt()) && (bestOf = sc.nextInt()) >= 2 || (bestOf < 1)) {
        if (bestOf % 2 == 0 && bestOf > 0) { }
        else {
          System.out.print("Error: Enter an odd integer above 1 for the best out of number. ");
        }
      }
      sc.nextLine();
    } while (bestOf < 1);
    return bestOf;
  }

  /**
   * Used in the Even or Odd class
   * Prompts the user to select even or odd. The remaining choice is assigned to the computer.
   * @return String       the user’s choice of even or odd
   */
  public String getChoice() {
    System.out.print("Would you like to be even or odd? Enter ‘E’ for even or ‘O’ for odd. ");
    //playerChoice = sc.nextLine();
    do {
      playerChoice = sc.nextLine();
      if (!(playerChoice.equals("E") || playerChoice.equals("O"))) {
        System.out.print("Error: Enter character ‘E’ or ‘O’. ");
      }
    } while (!(playerChoice.equals("E") || playerChoice.equals("O")));
    return playerChoice;
  }

  /**
   * Used in the Even or Odd class
   * Prompts the user to pick an integer between 1 and 5. This will be their throw for the round.
   * @return int  the user’s number thrown in the round
   */
  public int userThrow() {
    System.out.print("Choose a number from 1 to 5. ");
    do {
      if ((sc.hasNextInt()) && (playerThrow = sc.nextInt()) >= 2 || (playerThrow > 5)) {
        if (playerThrow < 6) { }
        else {
          System.out.print("Error: Enter valid integer between 1-5 ");
        }
      }
      sc.nextLine();

    } while (playerThrow > 5);

    return playerThrow;
  }

  /**
   * Used in the Find the Thimble class
   * Prompts the user to select left or right for a guess to find the thimble.
   * @return String  the user’s guess for where the thimble is
   */
  public String setGuess() {
    System.out.print("Enter ‘L’ or ‘R’ to guess which hand the thimble is in. ");
    thimbleChoice = sc.nextLine();
    while (!(thimbleChoice.equals("L") || thimbleChoice.equals("R"))) {

      if (!(thimbleChoice.equals("L") || thimbleChoice.equals("R"))) {
        System.out.print("Error: Please enter ‘L’ for left hand and ‘R’ for right hand. ");
      }
      thimbleChoice = sc.nextLine();
    }
    return thimbleChoice;
  }

  /**
   * Used in the Guess the Number class
   * This method prompts the user to enter the max of range.
   *@return int, the max of range
   */
  public int GetRangeNumber(){

      Scanner user_input = new Scanner(System.in);
      System.out.println("Enter an integer above or including 2 to represent the range of values to pick your numbers from. Example: If the integer 8 is entered, the range is 1-8.");

      if ((user_input.hasNextInt()) && (range_num = user_input.nextInt()) >= 2){
          ;
      }
      else if (range_num < 2){
          System.out.println("Error: Enter valid range number");
          GetRangeNumber();
      }
      else {
          System.out.println("Error: Enter valid range number");
          GetRangeNumber();
      }

      return range_num;
  }

  /**
   * Used in the Guess the Number class
   * This method prompts the user to enter the no of guesses allowed
   * @return int, no of guesses allowed
   */
  public int GetGuessNumber(){
      Scanner GuessNumber = new Scanner(System.in);
      System.out.println("Enter number of guesses for the game");

      if ((GuessNumber.hasNextInt()) && ((totalGuesses = GuessNumber.nextInt()) >= 1) && (totalGuesses < range_num)){
          System.out.println("Total guess: " + totalGuesses);
      }

      return totalGuesses;
  }


  /**
   * Used in the Guess the Number class
   * This method prompts the user to enter their guess number
   *@return int, the player's guess no
   */
  public int GetPlayerNumber(){
      Scanner PlayerGuessNumber = new Scanner(System.in);
      System.out.println("Guess number in range.");

      if ((PlayerGuessNumber.hasNextInt()) && (playerGuess = PlayerGuessNumber.nextInt()) >= 1 && (playerGuess <= range_num)){
          ;
      }
      else if (playerGuess < 1) {
          System.out.println("Error: Please enter valid number in range.");
          GetPlayerNumber();
      }
      else {
          System.out.println("Error: Please enter valid number in range.");
          GetPlayerNumber();
      }
      return playerGuess;
  }

  /**
   * Used in the Find the Red Thread class
   * Collects the user's input for how many spools can be pulled each turn
   * @return int     the amount of spools that a player can pull each turn
   */
  public int getNumOfSpools(){
    Scanner input = new Scanner(System.in);
    if (input.hasNextInt()) {
      numOfSpools = input.nextInt();
      if (numOfSpools < 0 || numOfSpools > 10){
        System.out.println("Error: Enter a valid integer of threads to be pulled between 1-10.");
        getNumOfSpools();
      }
    } else {
      System.out.println("Error: Enter a valid integer of threads to be pulled between 1-10.");
      getNumOfSpools();
    }
    return numOfSpools;
  }

  /**
   * Used in the Find the Red Thread class
   * Collects the user's guesses (i.e. what spools the user is picking)
   * @return int[]  an integer array of the different spools the user has guessed
   */
  public int[] spoolGuesses(){
    Scanner input = new Scanner(System.in);
    int[] guesses = new int[numOfSpools];
    int guess = -1;
    for (int i=0; i<numOfSpools; i++){
      if(input.hasNextInt() && (guess = input.nextInt()) <= 20 && guess >= 0){
        guesses[i] = guess;
      } else {
        System.out.println("Error: Enter a valid integer to guess the red thread.");
        return spoolGuesses();
      }
    }
    return guesses;
  }

  /**
   * Used in the CoinFlip class
   * Gets the guess from the user (can be only 'H' or 'T')
   * @return String   the user's guess
   */
  public String getCoinGuess(){
      Scanner scan2 = new Scanner(System.in);
      System.out.println("Enter 'H' for heads and 'T' for tails: ");
      guess = scan2.nextLine();

      if (guess.equals("H") || guess.equals("T")){
          ;
      }
      else {
          System.out.println("Error: Please enter 'H' for heads or 'T' for tails.: ");
          return getCoinGuess();
      }

      return guess;
  }

}
