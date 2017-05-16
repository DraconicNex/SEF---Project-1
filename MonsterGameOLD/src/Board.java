import java.util.ArrayList;
import java.util.Scanner;

public class Board 
{
	//testing testing 1,2!!
	//bloody dual security 
	//public static ArrayList<Square> gameSquares = new ArrayList<Square>() ;
	public static ArrayList<Player> gamePlayers = new ArrayList<Player>();
	
	public static ArrayList<int[]> playerCoordsForMonster = new ArrayList<int []>();
	public static Square tempSquare,updatedTempSquare, tempSquareA,
	                      tempSquareB;
	public static Player tempPlayer,temp;
	public static final Scanner sc = new Scanner(System.in);  
	public static int numberOfPlayers ,tempXA, tempYA ,tempXB, 
	                      tempYB, playerNumber,
	                      newXCoord, newYCoord;
	public static String  direction;
	public static Monster gameMonster;
	public static int boardSize,posnPlace;
	public static Item tempItem ,tempItemA, tempItemB, tempItemC;
	public static Item[][] gameBoard ;//= new Item [boardSize][boardSize] ;
	

	public Board() 
	{
		
		// test  11:20 18 Apr
			
		
	}
	
/*------------------Initialise Game Board and Add Monster----------------------------*/

	
	public static void initialiseGameBoard()
	{
		
		boardSize = 9;
		gameBoard = new Item [boardSize][boardSize];
		
		
		for ( int i=1; i <= boardSize ; i++) {
			for (int j = 1; j <= boardSize ; j++)
			{
								
				if (i==1 & j==1)
				{
					System.out.print("A");
					tempItem = new Floor("A");
		            gameBoard[j-1][i-1] = tempItem;
					
				}

				else if (i==1 & j==boardSize)
				{
					System.out.print("B");
					tempItem = new Floor("B");
					gameBoard[j-1][i-1] = tempItem;
					
					
					
				}
				else if (i==boardSize & j==1)
				{
					System.out.print("C");
					tempItem = new Floor("C");
					gameBoard[j-1][i-1] = tempItem;
					
					
				}
				else if (i==boardSize & j==boardSize)
				{
					System.out.print("D");
					tempItem = new Floor("D");
					gameBoard[j-1][i-1] = tempItem;
					
					
				}
				else if ((i==(boardSize/2)+1) & j==(boardSize/2)+1)
				{
					System.out.print("M");
									
					gameMonster = new Monster("M");
					gameBoard[j-1][i-1] = gameMonster;
					
					
					
				}
				else if ((i==1 || j==1) || (i== boardSize || j == boardSize)
						|| (i==((boardSize/2)+1) || j==((boardSize/2)+1))){
					
					
					tempItem = new Floor("-");
      				System.out.print("-");
					gameBoard[j-1][i-1] = tempItem;
					
					
					
				}
				else {
		            System.out.print("*");
		            tempItem = new Wall("*");
					gameBoard[j-1][i-1] = tempItem;
		           
		            
				}
				
			}
			System.out.println();
					
		}
		
		
		
		System.out.println();
	}
	
/*--------------------------Player Starting Positions--------------------------------*/	
	
	
	
	public static void chooseStartPostion()
	{
		
		Player.addInitialPlayerPosition(boardSize,gamePlayers,gameBoard);
	}
	
	
	

	/*--------------------------- Refresh Display of Game Board2--------------------------*/	
	
	// now in viewer class

	
	/*--------------------------- Players--------------------------*/
	
	public static int numberOfAssignedPlayers()
	{
		return gamePlayers.size();
	}
	
	
/*-------------------------------Choose Numbers of Opponents--------------------*/	
	
	public static void PlayerNumbers()
	{
		System.out.println(gamePlayers.isEmpty());
		System.out.println("Enter the number of players you want.");
		System.out.println("That is 2 to 4. Including You.");
		numberOfPlayers = sc.nextInt();
		System.out.println();	
		for (int num = 0; num < numberOfPlayers; num++ )
		{
			tempPlayer = new Player(Integer.toString(num+1));
			gamePlayers.add(num, tempPlayer);
			System.out.println("Size in playerNumbers " + gamePlayers.size() );
			System.out.println();
		}
		
	}
	
	
	
	public static Monster gameMonster()
	{
		return gameMonster;
	}
	
		
	public static int getBoardSize()
	{
		return boardSize;
	}
	
	public static Item[][] getGameBoard()
	{
		return gameBoard;
	}
	
/*----------------Sets up array to hold player positions to pass to Monster
 *                to calculate movement direction------------------------------
 */
	public static ArrayList<int[]> calculatePlayerCoordsForMonster()
	{   
		// calculate the player posn for Manhattan Distances
		// first clear old array
		
		playerCoordsForMonster.clear();
		posnPlace = 0;
		for (int m = 0; m < boardSize; m++)
		{
			
	      for (int n = 0; n < boardSize; n++) 
	      {
	    	  if (gameBoard[n][m] instanceof Player)
	    	  {
	    		// Have to make new array inside loop otherwise only records last position
	    		   int posn[] = new int[2];
	    		   posn[0]= n;
	    		   posn[1] = m;	    		  		
	    		   playerCoordsForMonster.add(posnPlace,posn);
	    		   posnPlace++;
	    	}
	      }
		}
		// calculate Monster posn and place at beginning of array list

		for (int m = 0; m < boardSize; m++)
		{
			
	      for (int n = 0; n < boardSize; n++) 
	      {
	    	  if (gameBoard[n][m] instanceof Monster)
	    	  {
	    		  // Have to make new array inside loop otherwise only records last position
	    		  int posn[] = new int[2];
		          posn[0]= n;
		          posn[1] = m;	    		  		
		    	  playerCoordsForMonster.add(0,posn);
	    			  }
	      }
		}
		
		return playerCoordsForMonster;
	}
	
/*--------------------------Move Item ----------------------------------------*/
	
	//Redundant Code see below. Uses Arraylist
	
	
	
/*----------------------------------moveItem 2D Array----------------------------------------*/	
	
	
	public static void moveItem2(String itemChar,String direction)
	{
		
		// test to find object need to pass in the object type monster player
		
		tempXA = boardSize +1;
    	tempYA = boardSize +1;
    	
		
			for (int i = 0; i < gameBoard.length; i++)
			{
				
		      for (int j = 0; j < gameBoard[i].length; j++) 
		      {
		        if ((gameBoard[j][i] instanceof MovableItem) &&
		        ((gameBoard[j][i].getItemChar()).equals(itemChar)))
		        	
		        {
		        	System.out.println(gameBoard[j][i].getItemChar());
		        	
		        	tempXA = j;
		        	tempYA =i;
		        	System .out.println(tempXA +" " +tempYA+" inside loop");
		        }
		        
		        
		      }
			}
			
			 
			
			// Message if player number not in Array list
			
			if((tempXA == boardSize +1 ) & (tempYA == boardSize +1) )
				
			{

        	      System.out.println("Player " + itemChar+
        			        " You are already Sunk");
        	      //  print statements to test should be omitted.
        	      System .out.println(tempXA +" " +tempYA +" inside sunk if");  
   
			}
			
			else
			{
        
			
			  // once found find where to move and interrogate new square for outcome
			
			  try
			  {  	 
		         if (((gameBoard[tempXA][tempYA].getItemChar()).equals (itemChar)))
		        	   {
		    	         System .out.println(tempXA +" " +tempYA +" nested loop");
		        	    newXCoord = MovableItem.findNewXAndY(tempXA,tempYA,direction,boardSize)[0];
		        	    newYCoord = MovableItem.findNewXAndY(tempXA,tempYA,direction,boardSize)[1];
		        	 
		        	     System .out.println(tempXA +" " +tempYA+" " + newXCoord+" " +newYCoord);
		        	 
		        	        if (gameBoard[newXCoord][newYCoord] instanceof Wall)
		        	           {
		        		            
		        		            System.out.println("You have run aground");
		        		            
		        	           }
		        	      
		        	       else if ((gameBoard[newXCoord][newYCoord] instanceof Player) && !(gameBoard[tempXA][tempYA] instanceof Monster))
		        	    	   {
		        		          
		        		           System.out.println("Danger Will Robinson! Collision ");
		        		          
		        	    	   }  
		        	        
		        	       else if ((gameBoard[newXCoord][newYCoord] instanceof Player) && (gameBoard[tempXA][tempYA] instanceof Monster))
	        	    	   {
		        	    	       System.out.println("Argh me hearties. We sunk the blighter.");
	        		               
	        		               for (int p = 0; p < gamePlayers.size(); p++)
	        		               {
	        		            	    if (gamePlayers.get(p).getItemChar().equals(gameBoard[newXCoord][newYCoord].getItemChar()))
	        		            	  {
	        		            		gamePlayers.remove(p);
	        		            	  }
	        		               }
	        		               gameBoard[newXCoord][newYCoord] = new Floor("-");
	        		               tempItemA = gameBoard[tempXA][tempYA];
		        		           tempItemB= gameBoard[newXCoord][newYCoord];
		        		           tempItemC = tempItemB;
		        		           gameBoard[newXCoord][newYCoord] = tempItemA;
		        		           gameBoard[tempXA][tempYA] = tempItemC;
	        		           
	        		          
	        	    	   }
		        	       		        	 
		        	       else if (gameBoard[newXCoord][newYCoord] instanceof Monster)
		        	           {
		        	  	           
		        		            System.out.println("Danger Will Robinson! We are sunk. ");
		        		            
		        		            gameBoard[tempXA][tempYA] = new Floor("-");
		        		            for (int p = 0; p < gamePlayers.size(); p++)
		        		            {
		        		            	if (gamePlayers.get(p).getItemChar().equals(itemChar))
		        		            	{
		        		            		gamePlayers.remove(p);
		        		            	}
		        		            }
		        		           
		        	           }
		        	 
		        	       else
		        	           {
		        	    	        tempItemA = gameBoard[tempXA][tempYA];
		        		            tempItemB= gameBoard[newXCoord][newYCoord];
		        		            tempItemC = tempItemB;
		        		            gameBoard[newXCoord][newYCoord] = tempItemA;
		        		            gameBoard[tempXA][tempYA] = tempItemC;
		        		            	 
		        		            
		        	           }
		        	      
		        	            
		        		      
		        	   }


		      }  catch (outOfBoundsException messageJ)
			
			         {
			            System.out.println(messageJ.getMessage());
			         }
         
			}
         
	}     
         
         
/*---------------------------- Change Item at x and y coord game board----------------*/		
	
	public static void changeItemOnGameBoard(int XCoord,int YCoord, Item changeArrayItem )
	{
		gameBoard[XCoord][YCoord] = changeArrayItem;
	}
		
		
}
	
	
/*   deprecated code
 * 
 * 
 * 
 * 
 * 
 * 
 * --------------------------- Refresh Display of Game Board--------------------------
	
	public static void refreshGameBoard()
	
	{
		System.out.println(gameSquares.size() + " refreshed");
		
		
		
		for (int a = 1; a <= boardSize; a++)
		{
			for (int b = 1; b <= boardSize; b++)
			{
				
				tempSquare= gameSquares.get((a*boardSize)-(boardSize-b)-1);
				System.out.print(tempSquare.getContents().getItemChar());
				
			}
			System.out.println();
		}
		System.out.println(gamePlayers.size() + " in while loop");
		
		
	}
	
	public static void refreshGameBoard2()
	
	{
		System.out.println(gameSquares.size() + " refreshed");
		
		
		
		for (int a = 0; a < boardSize; a++)
		{
			for (int b = 0; b < boardSize; b++)
			{
				
				
				System.out.print(gameBoard[b][a].getItemChar());
				
			}
			System.out.println();
		}
		System.out.println("multidimensional array");
		
		
	}
	
	public static void moveitem()
	{
		direction ="Right";
		tempPlayer = new Player ("A");
		tempSquare = new Square(9,5,tempPlayer);
		tempSquareA = tempSquare;
		tempItemA = tempSquareA.getContents();
		System.out.println("before move " + tempSquareA.getX()
	       +" "+ tempSquareA.getY()+" "+tempSquareA.getContents().getItemChar());
		
		gameSquares.set(((tempSquareA.getY()*boardSize)-
				(boardSize-tempSquareA.getX())-1), tempSquareA);
		try {
			 MovableItem.moveItem(direction,tempSquare,boardSize);
			 			 
			
		} catch (outOfBoundsException messageJ)
         {
            System.out.println(messageJ.getMessage());
         }
		System.out.println("new move item " + tempSquare.getX()
		       +" "+ tempSquare.getY());
		
		tempSquareB = tempSquare;
		tempItemB = tempSquareB.getContents();
		tempItemC = tempItemA;
		
		tempSquareA.changeContents(tempItemB);
		tempSquareB.changeContents(tempItemC);
		System.out.println("new move item " + tempSquareA.getX()
	       +" "+ tempSquareA.getY());
		
	}	
		
	public static ArrayList<Square> gameSquares()
	{
		return gameSquares;
	}	
*/
	
	
	
	
	

