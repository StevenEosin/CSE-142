import java.io.*;
import java.util.*;
import java.awt.*;

public class Names {

   public static final int NUM_OF_DECADES = 14;
   public static final int STARTING_YEAR = 1880;
   public static final int DECADE_WIDTH = 70;
   
   public static void main(String[] args) 
      throws FileNotFoundException { Scanner input = new Scanner(new File("names.txt"));
      
      Scanner console = new Scanner(System.in);
      
      intro();
      
      String name = getName(console);
      String gender = getGender(console);
      
      String nameData = findNameGenderData(input, name, gender);
      if (nameData != "") {
         plotGraph(nameData);
      } else {
         System.out.println("Match not found.");
      } 
   } 
   
   public static void intro() {
      System.out.println("This program allows you to search through the");
      System.out.println("data from the Social Security Administration");
      System.out.println("to see how popular a particular name has been");
      System.out.println("since 1920.");
      System.out.println();   
   }
   
   public static String getName(Scanner console) {
      System.out.println("Please enter a valid name.");
      String nameEntry = console.nextLine();
      return nameEntry;
   }
   
   public static String getGender(Scanner console) {
      System.out.println("Please enter a gender.");
      String genderEntry = console.nextLine();
      return genderEntry;
   }
   
   public static String findNameGenderData(Scanner input, String name, String gender) {
      
      while (input.hasNextLine()) {
         String line = input.nextLine();
         boolean data = readLine(line, name, gender);
         if (data == true) {
            return line;
            }
         }
         return "";
      }         
   
   public static boolean readLine(String line, String name, String gender) {
      Scanner checkNameAndGender = new Scanner(line);
         String nameCheck = checkNameAndGender.next();
         if (nameCheck.equalsIgnoreCase(name)) {
            String genderCheck = checkNameAndGender.next();
            if (genderCheck.equalsIgnoreCase(gender)) {
               return true;
            } else {
               return false;
            }
         } else {
            return false; 
         }             
   } 
   
   public static void plotGraph(String nameData) {
      Scanner readNameData = new Scanner(nameData);
      DrawingPanel panel = new DrawingPanel(DECADE_WIDTH * NUM_OF_DECADES, 550);
      Graphics g = panel.getGraphics(); 
      
      // Horizontal Lines
      g.setColor(Color.BLACK);
      g.drawLine(0, 25, DECADE_WIDTH * NUM_OF_DECADES, 25);
      g.drawLine(0, 525, DECADE_WIDTH * NUM_OF_DECADES, 525);
      
      // Vertical Lines
      for (int k = 0; k < NUM_OF_DECADES; k++) {
         g.drawLine(k * DECADE_WIDTH, 0, k * DECADE_WIDTH, 550);
      }
      
      // Decade Indicators
      for (int j = 0; j < NUM_OF_DECADES; j++) {
         g.drawString(String.valueOf(STARTING_YEAR + j * 10), DECADE_WIDTH * j, 550);
      }
      
      String name = readNameData.next();
      String gender = readNameData.next();
      
      // Plotting the data
      g.setColor(Color.RED);
      int CurrentValue = readNameData.nextInt();
      if (CurrentValue != 0) {
         CurrentValue = CurrentValue / 2 + 24; 
      } else {
         CurrentValue = 525;
      }
      
      for (int i = 0; i < NUM_OF_DECADES-1; i++) {
         int NextValue = readNameData.nextInt();
         if (NextValue != 0) {
            NextValue = NextValue / 2 + 24;
         } else {
            NextValue = 525;
         }
         
         g.drawLine(i * DECADE_WIDTH, CurrentValue, (i + 1) * DECADE_WIDTH, NextValue);
         CurrentValue = NextValue; 
     
         if (CurrentValue != 525) {
            g.drawString(name + " " + gender + " " + CurrentValue, i * DECADE_WIDTH, CurrentValue);
         } else {
            g.drawString(name + " " + gender + " " + 0, i * DECADE_WIDTH, CurrentValue);
         }
      }     
   }         
} 
      