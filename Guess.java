/* Assignment 5 - Guessing game

   Having trouble figuring out how to store values for reporting results in the 3rd method.
   I need to figure out how to store a value for total # of guesses, total # of games, and the lowest guess value over every game (best score).
   
*/

import java.util.*;

public class Guess {
   
   public static void main(String[] args) {
      
      Scanner console = new Scanner(System.in);  
      intro();
      
      int totalGuess = 0;
      int totalGames = 0;
      int bestScore = 100;
      int playAgain = 1;
      
      while (playAgain != 0) {
         int guesses = playGame(console);
         totalGuess += guesses;
         totalGames++;   
         if (guesses < bestScore) {
            bestScore = guesses;
         }
         
      System.out.println("Would you like to play again? Y/N");   
      String newGame = console.nextLine();
      newGame = console.nextLine();
      newGame = newGame.toUpperCase();
      
      if (newGame.contains("Y")) {
         playAgain = 1;
      } else if (newGame.contains("N")) {
         playAgain = 0;
         
         } 
      }
      
      reportResults(totalGuess, totalGames, bestScore);   
   }
   
   public static void intro() {
      System.out.println("This program allows you to play a guessing.");
      System.out.println("I will think of a number between 1 and");
      System.out.println("100 and will allow you to guess until");
      System.out.println("you get it. For each guess, I will tell you");
      System.out.println("whether the right answer is higher or lower");
      System.out.println("than your guess.");
      System.out.println();
      System.out.println("I'm thinking of a number between 1 and 100...");
   }
   
   public static int playGame(Scanner console) {
   
      Random random = new Random();
   
      int randomNum = random.nextInt(100)+1;          
      int guessCount = 0;
      int guess = -1;
      
      System.out.println("Your guess?"); 
      
      while (guess != randomNum) {           
         guess = console.nextInt();         
            if (guess < randomNum) {
               System.out.println("The number is higher.");    
            } else if (guess > randomNum) {                
               System.out.println("The number is lower.");
            }           
         guessCount++;
      }
      
      if (guessCount == 1) {
         System.out.println("Wow you got it right in 1 try!");
         System.out.println();
         
      } else { 
         System.out.println("You got it right in " + guessCount + " guesses.");
         System.out.println();  
      }   
         return guessCount;
      }
         
      
   public static void reportResults(int guessCount, int gameCount, int bestScore) {
      
      System.out.println("Overall results:");
      System.out.println("Total guess = " + guessCount);
      System.out.println("Total games = " + gameCount);
      System.out.println("Guesses per game average = " + guessCount / (float) gameCount);
      System.out.println("Best game = " + bestScore);           
   }
}

   
 