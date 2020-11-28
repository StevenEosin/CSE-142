// Assignment 5
import java.util.*;

public class Admission {
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      
      intro();
      
      // Ask user for SAT or ACT scores.
      String testType = promptTestType(input);
         if (testType.equalsIgnoreCase("sat")) {
            double firstScore = findSatScoreWithGpa(input);
         } else {
            double firstScore = findActScoreWithGpa(input);
         }
         
      String testType2 = promptTestType(input);
         if (testType.equalsIgnoreCase("sat")) {
            double secondScore = findSatScoreWithGpa(input);
         } else {
            double secondScore = findActScoreWithGpa(input);
         }
         
      compareFirstAndSecondScore(firstScore, secondScore);
   }
   
   public static void intro() {
      System.out.println("This program compares two applicants to");
      System.out.println("determine which one seems like the stronger");
      System.out.println("applicant. For each candidate I will need");
      System.out.println("either SAT or ACT scores plus a weighted GPA.");
      System.out.println();
   }
   
   public static String promptTestType(Scanner input) {
      System.out.println("Do you have SAT or ACT scores?");
      
      boolean correctInput = false;
      while (correctInput != true) {
         String userTest = input.nextLine();
         if (userTest.equalsIgnoreCase("sat|act")) {
            correctInput = true;
            return userTest;
         } else {
            System.out.println("Please enter either SAT or ACT.");
         }        
      }
      return "";
   }
   
   public static double findSatScoreWithGpa(Scanner input) {
      System.out.println("SAT Math score?");
      double math = input.nextDouble();    
      
      System.out.println("SAT critical reading score?");
      double reading = input.nextDouble();   
      
      System.out.println("SAT writing score?");
      double writing = input.nextDouble();
      System.out.println();   
       
      double SAT = (2 * math + reading + writing) / 32;
      System.out.printf("Exam score = %.1f\n", SAT);
      return SAT;    
   }  
   
   public static double findActScoreWithGpa(Scanner input) {
      System.out.println("ACT English score?");
      double english = input.nextDouble();
      
      System.out.println("ACT Math score?");
      double math = input.nextDouble();
      
      System.out.println("ACT Reading score?");
      double reading = input.nextDouble();
      
      System.out.println("ACT Science score?");
      double science = input.nextDouble();
      
      double ACT = (english + 2 * math + reading + science) / 1.8;
      System.out.printf("Exam score = %.1f\n", ACT); 
      return ACT;
   }
   
   public static void compareFirstAndSecondScore(double score1, double score2) {
      System.out.printf("First applicant overall score = %.1f\n", score1);
      System.out.printf("Second applicant overall score = %.1f\n", score2);
      if (score1 > score2) {
         System.out.println("The first applicant seems to be better.");
      } else if (score2 > score1) {
         System.out.println("The second applicant seems to be better.");
      } else {
         System.out.println("Both applicants seem to be equal.");
      }
   }
}
      
      
      
      