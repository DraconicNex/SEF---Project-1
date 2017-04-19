import java.util.ArrayList;
import java.util.Scanner;

public class Board 
{
	//testing testing 1,2!!
	//bloody dual security 
	private static ArrayList<Square> gameSquares = new ArrayList<Square>() ;
	private static ArrayList<Player> gamePlayers = new ArrayList<Player>();
	private static Square tempSquare,updatedTempSquare, tempSquareA,
	                      tempSquareB;
	private static Player tempPlayer,temp;
	private static final Scanner sc = new Scanner(System.in);  
	private static int numberOfPlayers ,tempXA, tempYA ,tempXB, tempYB, playerNumber;
	private static String  direction;
	private static Monster gameMonster;
	private static int boardSize;
	private static Item tempItem ,tempItemA, tempItemB, tempItemC;
	private static Item[][] gameBoard ;//= new Item [boardSize][boardSize] ;
	

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
		            tempSquare =  new Square(j,i,tempItem);
					gameSquares.add(tempSquare);
					
					gameBoard[j-1][i-1] = tempItem;
					
				}

				else if (i==1 & j==boardSize)
				{
					System.out.print("B");
					tempItem = new Floor("B");
		            tempSquare =  new Square(j,i,tempItem);
					gameSquares.add(tempSquare);
					gameBoard[j-1][i-1] = tempItem;
					
					
					
				}
				else if (i==boardSize & j==1)
				{
					System.out.print("C");
					tempItem = new Floor("C");
		            tempSquare =  new Square(j,i,tempItem);
					gameSquares.add(tempSquare);
					gameBoard[j-1][i-1] = tempItem;
					
					
				}
				else if (i==boardSize & j==boardSize)
				{
					System.out.print("D");
					tempItem = new Floor("D");
		            tempSquare =  new Square(j,i,tempItem);
					gameSquares.add(tempSquare);
					gameBoard[j-1][i-1] = tempItem;
					
					
				}
				else if ((i==(boardSize/2)+1) & j==(boardSize/2)+1)
				{
					System.out.print("M");
									
					gameMonster = new Monster("M");
					tempSquare =  new Square(j,i,gameMonster);
					gameSquares.add(tempSquare);
					gameBoard[j-1][i-1] = tempItem;
					
					
					
				}
				else if ((i==1 || j==1) || (i== boardSize || j == boardSize)
						|| (i==((boardSize/2)+1) || j==((boardSize/2)+1))){
					
					
					tempItem = new Floor("-");
		            tempSquare =  new Square(j,i,tempItem);
					gameSquares.add(tempSquare);
					System.out.print("-");
					gameBoard[j-1][i-1] = tempItem;
					
					
					
				}
				else {
		            System.out.print("*");
		            tempItem = new Wall("*");
		            tempSquare =  new Square(j,i,tempItem);
					gameSquares.add(tempSquare);
					gameBoard[j-1][i-1] = tempItem;
		           
		            
				}
				
			}
			System.out.println();
					
		}
		
		
		System.out.println(gameSquares.size()+ " initialise");
		System.out.println();
	}
	
/*--------------------------Player Starting Positions--------------------------------*/	
	
	
	
	public static void chooseStartPostion()
	{
		Player.addInitialPlayerPosition(boardSize,gameSquares,gamePlayers);
	}
	
	
	
/*--------------------------- Refresh Display of Game Board--------------------------*/
	
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
	
	/*--------------------------- Refresh Display of Game Board2--------------------------*/	
	
	
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
	
	
	public static ArrayList<Square> gameSquares()
	{
		return gameSquares;
	}
	
/*--------------------------Move Item ----------------------------------------*/
	
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
		
/*----------------------------------moveItem 2----------------------------------------*/	
	
	
	public static void moveitem2()
	{
		playerNumber = 1;
		direction ="Right";
		
		
		for (int i = 0; i < gameBoard.length; i++) {
		    for (int j = 0; j < gameBoard[i].length; j++) {
		        if (gameBoard[j][i] instanceof Player) 
		        {
		        	if (gameBoard[j][i].getItemChar() == Integer.toString(playerNumber));
		        	 tempXA = j;
		        	 tempYA =i;
		        	 MovableItem.moveItem2(j,i,direction,boardSize);
		        }
		    }
		}

		
		
		
		
		
	}
	
	
	
	
	
	
	
	
}
