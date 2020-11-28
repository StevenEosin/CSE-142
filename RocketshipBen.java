// Ben refactor
// Assignment #2 Loops and static methods
// Part B: ASCII rocketship art
// 8/11/2020

public class RocketshipBen {
   
   public static final int SIZE = 6;
   
   public static final int TOP_HEIGHT = SIZE * 2;
   public static final int ROCKET_LINE = SIZE * 2;
   public static final int ROCKET_HEIGHT = SIZE;
   
   public static void main(String[] args) {
      topTriangle();
      rocketHorizontalLine();
      rocketUpperBody();
      rocketHorizontalLine();
      rocketBottomBody();
      rocketHorizontalLine();
      topTriangle();
   }

   public static void topTriangle() {

      for (int i = 1; i <= TOP_HEIGHT - 1; i++) {
         for (int j = TOP_HEIGHT; j > i; j--) {
            System.out.print(' ');
         }
         
         for (int k = 1; k <= i; k++) {
            System.out.print('/');
         }
         
         for (int j = 1; j <= 2; j++) {
            System.out.print('*');
         }
         
         for (int k = 1; k <= i; k++) {
            System.out.print('\\');
         }

         System.out.println();
      }

   }

   public static void rocketHorizontalLine() {

      System.out.print('+');

      for (int i = 1; i <= ROCKET_LINE; i++) {
         System.out.print("=*");
      }

      System.out.println('+');
   }

   public static void rocketBodyTopDiamondHalf() {

      for (int i = 1; i <= ROCKET_HEIGHT; i++) {
         System.out.print('|');
         
         for (int k = 1; k <= ROCKET_HEIGHT-i; k++) {
            System.out.print('.');
         }
         
         for (int j = 1; j <= i; j++) {
            System.out.print("/\\");
         }
         
         for (int k = 0; k < ROCKET_HEIGHT*2 - i*2; k++) {
            System.out.print('.');
         }
         
         for (int j = 1; j <= i; j++) {
            System.out.print("/\\");
         }
         
         for (int k = 1; k <= ROCKET_HEIGHT - i; k++) {
            System.out.print('.');
         }
         
         System.out.println('|');
      }
   }

   public static void rocketBodyBottomDiamondHalf() {
      for (int i = 1; i <= ROCKET_HEIGHT; i++) {
         System.out.print('|');
         
         for (int k = 1; k < i; k++) {
            System.out.print('.');
         }
         
         for (int j = 0; j <= ROCKET_HEIGHT-i; j++) {
            System.out.print("\\/");
         }
         
         for (int k = 1; k <= (2 * i) - 2; k++) {
            System.out.print('.');
         }
         
         for (int j = 0; j <= ROCKET_HEIGHT -i ; j++) {
            System.out.print("\\/");
         }
         
         for (int k = 1; k < i; k++) {
            System.out.print('.');
         }
         
         System.out.println('|');
      }
   }

   public static void rocketUpperBody() {
      rocketBodyTopDiamondHalf();
      rocketBodyBottomDiamondHalf();
   }

   public static void rocketBottomBody() {
      rocketBodyBottomDiamondHalf();
      rocketBodyTopDiamondHalf();
   }
}