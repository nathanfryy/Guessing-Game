import java.util.Scanner;

//The main has all of the methods that go into the game in a while loop. The while loop is for whether or not the user wants to
//play again or not. If they do, it has the program do the entire game over again without the introduction, starting from choosing
//the difficulty again.
class Main {
    public static void main( String args[] ) {
      intro();
      Scanner inputScanner = new Scanner(System.in);
      String userInput = "";
      do{
        int difficulty = get_difficulty();
        int randomInt = get_number(difficulty);
        String answer = "";
        int numGuesses = 0;
        int maxNumGuesses = 10;
        while ((answer != "Correct! Thanks for playing!") && (numGuesses < maxNumGuesses)){
          int userGuess;
          if (numGuesses > 0) {
            System.out.println("Try again");
          }
          userGuess = get_user_guess();
          numGuesses += 1;
          System.out.println("\n");
          System.out.println("You've used "+numGuesses+ " out of "+maxNumGuesses+ " guesses ");
          sleep_method();
          answer = check_guess(userGuess, randomInt);
          System.out.println(answer); 
          }
        if (numGuesses == maxNumGuesses) {
          failed_game(randomInt);
        }
        System.out.print("Do you want to play again? (y / n)? ");
        userInput = inputScanner.nextLine();
      } while (userInput.equals("y") || userInput.equals(""));
    }
      
  //This is just the introduction with the title and explanation to the game.
    public static void intro(){
      System.out.println(" ██████╗ ██╗   ██╗███████╗███████╗███████╗██╗███╗   ██╗ ██████╗      ██████╗  █████╗ ███╗   ███╗███████╗");
      sleep_method();
      System.out.println("██╔════╝ ██║   ██║██╔════╝██╔════╝██╔════╝██║████╗  ██║██╔════╝     ██╔════╝ ██╔══██╗████╗ ████║██╔════╝");
      sleep_method();
      System.out.println("██║  ███╗██║   ██║█████╗  ███████╗███████╗██║██╔██╗ ██║██║  ███╗    ██║  ███╗███████║██╔████╔██║█████╗  ");
      sleep_method();
      System.out.println("██║   ██║██║   ██║██╔══╝  ╚════██║╚════██║██║██║╚██╗██║██║   ██║    ██║   ██║██╔══██║██║╚██╔╝██║██╔══╝  ");
      sleep_method();
      System.out.println("╚██████╔╝╚██████╔╝███████╗███████║███████║██║██║ ╚████║╚██████╔╝    ╚██████╔╝██║  ██║██║ ╚═╝ ██║███████╗");
      sleep_method();
      System.out.println(" ╚═════╝  ╚═════╝ ╚══════╝╚══════╝╚══════╝╚═╝╚═╝  ╚═══╝ ╚═════╝      ╚═════╝ ╚═╝  ╚═╝╚═╝     ╚═╝╚══════╝");
      sleep_method();
      System.out.println("--------------------------------------------------------------------------------------------------------");
      System.out.println("\n");
      sleep_method();
      System.out.println("Welcome to my guessing game. Here you will be presented with 5 different difficulties. It goes from easy");
      System.out.println("to insane. There is also a choose your own upper limit difficulty if you'd like. You have 10 guesses no");
      System.out.println("matter what difficulty you choose. Good luck!");
      sleep_method();

      
    }

  //get_difficulty justs presents the user with the possible difficulties and gets the difficulty they choose.
  //It then returns it.
    public static int get_difficulty() {
      System.out.println();
      System.out.println("Choose your difficulty.");
      System.out.println();
      System.out.println("Easy: 1-10           (1)");
      System.out.println("Medium: 1-25         (2)");
      System.out.println("Hard: 1-50           (3)");
      System.out.println("Insane: 1-1000       (4)");
      System.out.println("Choose your own: 1-? (5)");
      int difficulty = 0;
      while(difficulty != 1 && difficulty != 2 && difficulty != 3 && difficulty != 4 && difficulty != 5) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Pick your difficulty: ");
        difficulty = scan.nextInt();
      }
      return difficulty;
    }
    
    //get_number takes the difficulty the user chose and generates a random number based on the users parameters and returns it.
     public static int get_number(int difficulty){
       int randomInt = 0;

      if (difficulty == 1){
        int min = 1;
        int max = 10;
        System.out.println("Guess a number between "+min+" through "+max+ ":");
        randomInt = (int)Math.floor(Math.random()*(max-min+1)+min);
      }     
      if (difficulty == 2){
        int min = 1;
        int max = 25;
        System.out.println("Guess a number between "+min+" through "+max+ ":");
        randomInt = (int)Math.floor(Math.random()*(max-min+1)+min);
      }
      if (difficulty == 3){
        int min = 1;
        int max = 50;
        System.out.println("Guess a number between "+min+" through "+max+ ":");
        randomInt = (int)Math.floor(Math.random()*(max-min+1)+min);
      }
      if (difficulty == 4){
        int min = 1;
        int max = 1000;
        System.out.println("Guess a number between "+min+" through "+max+ ":");
        randomInt = (int)Math.floor(Math.random()*(max-min+1)+min);
      }
      if (difficulty == 5){
        Scanner scan = new Scanner(System.in);
        int min = 1;
        System.out.print("Pick your upper limit: ");
        int max = scan.nextInt();
        System.out.println("Guess a number between "+min+" through "+max+ ":");
        randomInt = (int)Math.floor(Math.random()*(max-min+1)+min);
      }
      return randomInt;
      } 

  //get_user_guess just gets the user's guess on what the random number is and returns it.
    public static int get_user_guess() {
      Scanner scan = new Scanner(System.in);
      System.out.print("Guess the number: ");
      int userGuess = scan.nextInt();
      sleep_method();
      return userGuess; 
    }

  //check_guess sees if the user guess is higher, lower, or equal to the random integer generated and will either give
  //hints if the user is too high/low or tell them if they're correct.
    public static String check_guess(int userGuess, int randomInt) {
      if (userGuess > randomInt){
        return "Too high";
      }

      if (userGuess < randomInt) {
        return "Too low";
      }

      else {
        return "Correct! Thanks for playing!";
      }
    }

  //failed_game presents the user with the random integer that they failed to guess in time.
    public static void failed_game(int randomInt) {
      System.out.println("Dang, I guess you didn't get it. Better luck next time.");
      System.out.println("The number was "+randomInt);
    }

  //I created the sleep_method here and then implemented it around the program where it was needed so that
  //I didn't have to write this chunk of code each time I wanted to delay the program.
    public static void sleep_method(){
      try{
        Thread.sleep(500);
      }
      catch(InterruptedException ex){
        Thread.currentThread().interrupt();
      }
    }
    

}