import java.util.ArrayList;
import java.util.Scanner;

public class Board 
{
	//testing testing 1,2!!
	//bloody dual security 
	private static ArrayList<Square> gameSquares = new ArrayList<Square>() ;
	private static ArrayList<Player> gamePlayers = new ArrayList<Player>();
	private static Square tempSquare;
	private static Player playersTemp,temp;
	private static final Scanner sc = new Scanner(System.in);
	private static int numberOfPlayers , tempXA , tempYA ,tempXB,tempYB;
	private static String tempContentA , tempContentB , tempContentC,direction;
	private static Monster gameMonster = new Monster(0,0);
	

	public Board() 
	{
		
		
	}
	
/*------------------Initialise Game Board and Add Monster----------------------------*/

	
	public static void initialiseGameBoard( int boardSize)
	{
		
		
		
		for ( int i=1; i <= boardSize ; i++) {
			for (int j = 1; j <= boardSize ; j++)
			{
				
				
				
				if (i==1 & j==1)
				{
					System.out.print("A");
					tempSquare =  new Square(i,j,"A");
					gameSquares.add(tempSquare);
					
					
				}

				else if (i==1 & j==boardSize)
				{
					System.out.print("B");
					tempSquare =  new Square(i,j,"B");
					gameSquares.add(tempSquare);
					
					
				}
				else if (i==boardSize & j==1)
				{
					System.out.print("C");
					tempSquare =  new Square(i,j,"C");
					gameSquares.add(tempSquare);
					
					
				}
				else if (i==boardSize & j==boardSize)
				{
					System.out.print("D");
					tempSquare =  new Square(i,j,"D");
					gameSquares.add(tempSquare);
					
					
				}
				else if ((i==(boardSize/2)+1) & j==(boardSize/2)+1)
				{
					System.out.print("M");
					tempSquare =  new Square(i,j,"M");
					gameSquares.add(tempSquare);
					gameMonster = new Monster(i,j);
					
					
					
				}
				else if ((i==1 || j==1) || (i== boardSize || j == boardSize)
						|| (i==((boardSize/2)+1) || j==((boardSize/2)+1))){
					
					System.out.print("-");
					tempSquare =  new Square(i,j,"-");
					gameSquares.add(tempSquare);
					
					
					
				}
				else {
		            System.out.print("*");
		            tempSquare =  new Square(i,j,"*");
					gameSquares.add(tempSquare);
		           
		            
				}
				
			}
			System.out.println();
					
		}
		
		
		System.out.println(gameSquares.size()+ " initialise");
		System.out.println();
	}
	
/*--------------------------Player Starting Positons--------------------------------*/	
	
	public static void addInitialPlayerPosition(int boardSize)
	{
		
		String response;
	    char selection = '\0';
	    
	 // Asks player one to select a start position
		
		System.out.println("Please Enter postion to Start");
		
		System.out.println("A   -   Top Left");
        System.out.println("B   -   Top Right");
        System.out.println("C   -   Bottom Left");
        System.out.println("D   -   Bottom Right");
        
		response = sc.next().toUpperCase();
		System.out.println();
		
		if (response.length() != 1)
        {
           System.out
                 .println("Error - you did not enter a valid menu option!");
        }
		else
        {
           selection = response.charAt(0);

           /* 
            * process the user's selection by adding initial start position into
            * the array list.
            */
           switch (selection)
           {
           case 'A':
        	   
        	   playersTemp =  new Player(1,1);
        	   gamePlayers.add(playersTemp);
        	   tempSquare = gameSquares.get((1*1)-1);
			   System.out.println(tempSquare.getContents());
			   tempSquare = Square.changeContent(tempSquare , Integer.toString(gamePlayers.size() ) );
			   System.out.println(tempSquare.getContents());
			   gameSquares.set(((1*1)-1),tempSquare);
        	   
        	   break;
        	   
           case 'B':
        	   
        	   playersTemp=  new Player(1,boardSize);
        	   gamePlayers.add(playersTemp);
        	   tempSquare = gameSquares.get((1*boardSize)-1);
			   System.out.println(tempSquare.getContents());
			   tempSquare = Square.changeContent(tempSquare ,Integer.toString(gamePlayers.size()) );
			   System.out.println(tempSquare.getContents());
			   gameSquares.set(((1*boardSize)-1),tempSquare);
        	   
        	   break;
        	   
           case 'C':
        	   
        	   playersTemp =  new Player(boardSize,1);
        	   gamePlayers.add(playersTemp);
        	   tempSquare = gameSquares.get((boardSize - 1) * boardSize);
			   System.out.println(tempSquare.getContents());
			   tempSquare = Square.changeContent(tempSquare , Integer.toString(gamePlayers.size()) );
			   System.out.println(tempSquare.getContents());
			   gameSquares.set(((boardSize - 1) * boardSize),tempSquare);
        	   break;
          
           case 'D':
        	   
        	   playersTemp =  new Player(boardSize,boardSize);
        	   gamePlayers.add(playersTemp);
        	   tempSquare = gameSquares.get((boardSize  * boardSize)-1);
			   System.out.println(tempSquare.getContents());
			   tempSquare = Square.changeContent(tempSquare ,Integer.toString(gamePlayers.size()) );
			   System.out.println(tempSquare.getContents());
			   gameSquares.set(((boardSize  * boardSize)-1),tempSquare);
        	   
        	   break;
           }
        }

		System.out.println(gameSquares.size() + " assigned");
	}
	
/*--------------------------- Refresh Display of Game Board--------------------------*/
	
	public static void refreshGameBoard( int boardSize)
	
	{
		System.out.println(gameSquares.size() + " refreshed");
		
		
		
		for (int a = 1; a <= boardSize; a++)
		{
			for (int b = 1; b <= boardSize; b++)
			{
				
				tempSquare= gameSquares.get((a*boardSize)-(boardSize-b)-1);
				System.out.print(tempSquare.getContents());
				
			}
			System.out.println();
		}
		System.out.println(gamePlayers.size() + " in while loop");
	}
	public static int numberOfAssignedPlayers()
	{
		return gamePlayers.size();
	}
	
	public static int PlayerNumbers()
	{
		System.out.println(gamePlayers.isEmpty());
		System.out.println("Enter the number of players you want.");
		System.out.println("That is 2 to 4. Including You.");
		numberOfPlayers = sc.nextInt();
		System.out.println();	
		return numberOfPlayers;
	}
	
	public static Monster gameMonster()
	{
		return gameMonster;
	}
	
	
	public static ArrayList<Square> gameSquares()
	{
		return gameSquares;
	}
	
	public static void moveMonster(int boardSize, String directionInput)
	{
	    direction = directionInput;
		tempXA = gameMonster.getX();
		tempYA = gameMonster.getY();
		tempContentA = (gameSquares.get((tempXA*boardSize)-(boardSize-tempYA)-1)).getContents();
		System.out.println(tempContentA);
		
		gameMonster().moveItem(direction);
		
		tempXB = gameMonster.getX();
		tempYB = gameMonster.getY();
		tempContentB = (gameSquares.get((tempXB*boardSize)-(boardSize-tempYB)-1)).getContents();
		System.out.println(tempContentB);
		
		tempContentC = tempContentA;
		
		
		tempContentA = (gameSquares.get((tempXA*boardSize)-(boardSize-tempYA)-1)).
				           changeContents(tempContentB);
		
		
		tempContentB = (gameSquares.get((tempXB*boardSize)-(boardSize-tempYB)-1)).
				          changeContents(tempContentC);
	}
	
	public static void movePlayer(int boardSize, int playerNum)
	
	{
		playersTemp =  gamePlayers.get((playerNum -1));
		String direction = "Up";
		playersTemp.moveItem(direction);
		System.out.println(playersTemp.getX());
		//String direction = "Up";
		//playersTemp().moveItem(direction);
		
	}
	
	
	
}
