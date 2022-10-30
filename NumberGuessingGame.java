
/*

		Developed by -> Aditya Govinda Kalaskar
		Task 2 - Number Guessing game 
		
*/

import java.util.Random;
import java.util.*;

class Play
{
  int num;

  void StartGame()
  {
	Scanner sc = new Scanner(System.in);

	Random rand = new Random();
    	num = rand.nextInt(100);

		int input,counter=0;
		int life=5,lives=5,score=20;
  	 
   
    for(int i=1; i<=life; i++)
    {
      System.out.print("\nEnter any number between 1 to 100 : ");
      input = sc.nextInt();
      counter++;
      
      if(input>100)
      {
        System.out.println("Number is not between 1 to 100");
        System.out.println("Again start the game");

        System.out.println("\nDo you want to play game again ? ");
	System.out.println(" If Yes then enter choice : 1");
        
	System.out.println("DO you want to see the rules ?  ");
	System.out.println(" If Yes then enter choice : 2");

        System.out.println("Do you want to Exit the Game ? ");
	System.out.println(" If Yes then enter choice : 3");
        break;
      }
      else if(input == num)
      {
        score = score * counter;
        System.out.println("\n----------------------------------------");
        System.out.println("Result :---->");
        System.out.println("You Win!");
        System.out.println("Your Try Count : "+counter);
        System.out.println("Your Score : "+score+" % ");
        System.out.println("------------------------------------------");
       
        System.out.println("\nDo you want to play game again ? ");
	System.out.println(" If Yes then enter choice : 1");
        
	System.out.println("DO you want to see the rules ?  ");
	System.out.println(" If Yes then enter choice : 2");
       
        System.out.println("Do you want to Exit the Game ? ");
	System.out.println(" If Yes then enter choice : 3");
        break;
      }
      else if(input>num)
      {
        System.out.println("The number you guess is higher. \nGuess Again......");
        lives = lives-1;
        System.out.println("Lives remaining : "+ lives);
      }
      else if(input<num)
      {
        System.out.println("The number you guess is smaller. \nGuess Again......");
        lives = lives-1;
        System.out.println("Lives remaining : "+ lives);
      }


      if(i==life && input!=num)
      {
        System.out.println("\nYour 5 attempts are Over");

        System.out.println("\n---------------------------------");
        System.out.println(" Result :---->");
        System.out.println("You Lose!!!");
        System.out.println("Your Score : "+"0");
        System.out.println("The number was " +num);
        System.out.println("---------------------------------");

     	System.out.println("\nDo you want to play game again ? ");
	System.out.println(" If Yes then enter choice : 1");
        
	System.out.println("DO you want to see the rules ?  ");
        System.out.println(" If Yes then enter choice : 2");

        System.out.println("Do you want to Exit the Game ? ");
	System.out.println(" If Yes then enter choice : 3");
      }
    }
  }

  
  void rules()
  {
    System.out.println("\n**************** Rules **************  ");
    System.out.println("a) The number should be between given range (1 to 100)");
    System.out.println("b) The Game will end afters 5 attempts.");
    System.out.println("c) If Player Failed to guess a number then the player loose the game.");
    System.out.println("d) There is 20 points for per counter");

        System.out.println("\nDo you want to play game:: ? ");
	System.out.println(" If Yes then enter: 1");
  
  }
 
}


class NumberGuessingGame
{
 	  public static void main(String args[])
	  {
  		int choice;
 		Scanner sc = new Scanner(System.in);
	    	System.out.println("\n#### Number Guessing Game ####\n");
    		System.out.println("1)Start Game");
		System.out.println("2)Rules");
		System.out.println("3)Exit");
   
   
		 Play obj = new Play();
    
    while(true)
    {
    
	 System.out.print("\nEnter your Choice: ");
     	 choice = sc.nextInt();
      
	switch(choice)
        {
     
        case 1:
		 obj.StartGame();
                 break;
        case 2: 
		 obj.rules();
                 break;
        case 3: 
		 System.out.println("\nThank You for playing Game...");
                 return;
        default : 
		System.out.println("Invalid Choice!!"); 

      }
    }
  }
}