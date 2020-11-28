// Assignment 3
// Loops, value parameters, and graphics
// Part B: Cafewall Illusion

import java.awt.*;

public class CafeWall4 {

   public static final int MORTAR = 2;
   
   public static void main(String[] args) {
   
      DrawingPanel panel = new DrawingPanel(650, 400);
      Graphics g = panel.getGraphics();
      panel.setBackground(Color.GRAY);
      
      drawRow(g, 0, 0, 8, 20);               // Upper Left Row
      drawRow(g, 50, 70, 10, 30);            // Middle Left Row
      drawGrid(g, 10, 150, 8, 25, 0);        // Bottom Left Grid
      drawGrid(g, 250, 200, 6, 25, 10);      // Middle Bottom Grid
      drawGrid(g, 400, 20, 4, 35, 35);       // Top Right Grid
      drawGrid(g, 425, 180, 10, 20, 10);     // Bottom Right Grid                   
   }
      
   // Draws a grid containing a number of rows of box patterns
   public static void drawGrid(Graphics g, int x, int y, int row, int size, int offset) {
      for (int k = 0; k < row; k++) {
      
         int SPACING = k * (size + MORTAR);
         
         drawRow(g, x + (k%2 * offset), y + SPACING, row, size);
      }
   }   
   
   // Draws a row of boxes in pattern based on row value
   public static void drawRow(Graphics g, int x, int y, int row, int size) {
      
      for (int i = 0; i < row / 2; i++) {
 
         int SPACING = i * 2 * size;
         
         g.setColor(Color.BLACK);
         g.fillRect(x + SPACING, y, size, size); 
         
         g.setColor(Color.BLUE);
         g.drawLine(x + SPACING, y, x + SPACING + size, y + size);
         g.drawLine(x + SPACING, y + size, x + SPACING + size, y);  
         
         g.setColor(Color.WHITE);
         g.fillRect(x + SPACING + size, y, size, size);     
      }      
   }  
}