package bag;

import java.util.Random;
import java.util.Scanner;

public class Poker {

	public static void main(String[] args) {
		Scanner getString = new Scanner(System.in);
		Random randomCard = new Random();
		
		boolean playerOneTurn = true;
    	boolean playerTwoTurn = false;
    	
    	
		BagInterface<String> playerOne = new ArrayBag<>();
		BagInterface<String> playerTwo = new ArrayBag<>();
	    BagInterface<String> cards = new ArrayBag<>();
		
	    String[] contentsOfCards =  {"1", "2", "3", "4", "5",
				                    "6", "7", "8", "9", "10",
				                    "11", "12", "13"};
	    
 	    System.out.println("T.Phong Card Game");
 	    System.out.println("\nSix cards selected.");
 	    
	    while(cards.getCurrentSize() < 6)
	    {
	    	String s = contentsOfCards[randomCard.nextInt(13)];
	    	if(!cards.contains(s))
	    		cards.add(s);
	    }
	    if(args.length > 1 && args[0].equals("debug")) {
	    	displayBag(cards);
	    }
	   
	    displayBag(cards);
	    
	  // System.out.println(cards.contains());
	    for(int num = 0; num < 6; num++) {
        	
	    	boolean bothIncorrect = true;
        	String tempHolder = cards.remove(); 
        	
        	
        	System.out.println("\nGuess new Card");
        	
        	while(bothIncorrect) {
            	if(playerOneTurn) {
            		System.out.println("Player1 guess card # ");
            		String playerOneGuess = getString.nextLine();
            		
            		if(playerOneGuess.equals(tempHolder)){
            			playerOne.add(tempHolder);
            			
            			System.out.println("Player1 got card.");
            		    
            			playerOneTurn = false;
            			playerTwoTurn = true;
            			bothIncorrect = false;
            			break;
            		}
            		else {
            			System.out.println("Player1 guessed incorrectly");
            			
            			playerOneTurn = false;
            			playerTwoTurn = true;
            		}
            	}
                if(playerTwoTurn) {
                	System.out.println("Player2 guess card #");
            		String playerTwoGuess = getString.nextLine(); 
            		
            		if(playerTwoGuess.equals(tempHolder)){
            			playerTwo.add(tempHolder);
            			
            			System.out.println("Player2 got card.");
            			
            			playerTwoTurn = false;
            			playerOneTurn = true;
            			bothIncorrect = false;
            			break;
            		}
            		else {	
            			System.out.println("Player2 guessed incorrectly");
            			
            			playerOneTurn = true;
            			playerTwoTurn = false;		
            	    } 
                 }       	        	
        
        	}                
        }
   
       if(playerOne.getCurrentSize() > playerTwo.getCurrentSize()) {
           int playerOneValue = playerOne.getCurrentSize();
    	   System.out.println("PlayerOne won with " + playerOneValue + " cards.");
       }
       else if(playerTwo.getCurrentSize() > playerOne.getCurrentSize()) {
           int playerTwoValue = playerTwo.getCurrentSize();
    	   System.out.println("PlayerTwo won with " + playerTwoValue + " cards.");  	
       }
       else {
          System.out.println("Game is a tie.");       
       }
       
       System.out.println("End of Game");
	}	
	
	private static void displayBag(BagInterface<String> aBag) {
	  Object[] bagArray = aBag.toArray();
	 
	   for(int index = bagArray.length - 1; index >= 0; index--) {
		   System.out.print(bagArray[index] + " ");	
	   }
	   System.out.println();
	}
}
