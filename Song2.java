// Steven Cheng 
// 8/8/2020, CSE 142, Assignment #1
// Use static methods and println statements to produce a cumulative song

public class Song2 {
   public static void main(String[] args) {
      songFly();
      songSpider();
      songBird();
      songCat();
      songDog();
      songPig();
      songHorse();
   }
   
// Main verses
      
   public static void songFly() {
      System.out.println("There was an old woman who swallowed a fly.");
      swallowFly();
      System.out.println();
   }
   
   public static void songSpider() {
      System.out.println("There was an old woman who swallowed a spider,");
      System.out.println("That wriggled and iggled and jiggled inside her.");
      catchFly();
      swallowFly();
      System.out.println();
   }
   
   public static void songBird() {
      System.out.println("There was an old woman who swallowed a bird,");
      System.out.println("How absurd to swallow a bird.");
      catchSpider();
      swallowFly();
      System.out.println();
   }
   
   public static void songCat() {
      System.out.println("There was an old woman who swallowed a cat,");
      System.out.println("Imagine that to swallow a cat.");
      catchBird();
      swallowFly();
      System.out.println();
   }
   
   public static void songDog() {
      System.out.println("There was an old woman who swallowed a dog,");
      System.out.println("What a hog to swallow a dog.");
      catchCat();
      swallowFly();
      System.out.println();
   }
   
   public static void songPig() {
      System.out.println("There was an old woman who swallowed a pig,");
      System.out.println("What a waste of bacon to swallow a pig.");
      catchDog();
      swallowFly();
      System.out.println();
   }
   
   public static void songHorse() {
      System.out.println("There was an old woman who swallowed a horse,");
      System.out.println("She died of course.");
      System.out.println();
   }   
       
// Cumulative lines

   public static void swallowFly() {
      System.out.println("I don't know why she swallowed that fly,");
      System.out.println("Perhaps she'll die.");
   }
   
   public static void catchFly() {
      System.out.println("She swallowed the spider to catch the fly,");
   }
   
   public static void catchSpider() {
      System.out.println("She swallowed the bird to catch the spider,");
      catchFly();
   }
   
   public static void catchBird() {
      System.out.println("She swallowed the cat to catch the bird,");
      catchSpider();
   }
   
   public static void catchCat() {
      System.out.println("She swallowed the dog to catch the cat,");
      catchBird();
   }
   
   public static void catchDog() {
      System.out.println("She swallowed the pig to catch the dog,");
      catchCat();
   }
}
      