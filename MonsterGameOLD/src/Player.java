import java.util.*;



public class Player extends MovableItem
{
	
	public boolean eaten;
	public String moveDirection;
	private static final Scanner sc = new Scanner(System.in);
	private static Square tempSquare;
	private static Player playersTemp,temp;
	

	public Player(String itemChar) 
	{
		super(itemChar);
		this.eaten = false;
		this.moveDirection = "Stop";
		
	}
	
	
	public boolean geteaten()
	{
		return eaten;
	}
		
	public String getMoveDirection()
	{
		return moveDirection;
	}
	
	public String changeMoveDirection(String moveDirection)
	
	{
		this.moveDirection = moveDirection;
		return moveDirection;
	}
	
	public static void addInitialPlayerPosition(int boardSize, ArrayList<Square> gameSquares,
			                   ArrayList<Player> gamePlayers, Item[][] gameBoard)
	{
		
		String response;
	    char selection = '\0';
	    
	 // Asks player one to select a start position
	    
	    int playerNumber = 1;
	    
		do
		{
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
        	   
        	   /*
        	    * 
        	    * playersTemp =  new Player(1,1);
        	      gamePlayers.add(playersTemp);
        	      */
        	      tempSquare = gameSquares.get((1*1)-1);
			      System.out.println(tempSquare.getContents());
			      playersTemp =  new Player(Integer.toString(playerNumber));
			      tempSquare.changeContents(playersTemp);
			      gameSquares.set(((1*1)-1),tempSquare);
			      gameBoard[0][0] = playersTemp;
			   
			  
        	   
        	   break;
        	   
           case 'B':
        	   
        	   
        	   tempSquare = gameSquares.get((1*boardSize)-1);
			   System.out.println(tempSquare.getContents());
			   playersTemp =  new Player(Integer.toString(playerNumber));
			   tempSquare.changeContents(playersTemp);
			   gameSquares.set(((1*boardSize)-1),tempSquare);
			   gameBoard[boardSize-1][0] = playersTemp;
        	   
        	   break;
        	   
           case 'C':
        	   
        	   
        	   tempSquare = gameSquares.get((boardSize - 1) * boardSize);
			   System.out.println(tempSquare.getContents());
			   playersTemp =  new Player(Integer.toString(playerNumber));
			   tempSquare.changeContents(playersTemp);
			   gameSquares.set(((boardSize - 1) * boardSize),tempSquare);
			   gameBoard[0][boardSize-1] = playersTemp;
        	   break;
          
           case 'D':
        	   
        	  
        	   tempSquare = gameSquares.get((boardSize  * boardSize)-1);
			   System.out.println(tempSquare.getContents());
			   playersTemp =  new Player(Integer.toString(playerNumber));
			   tempSquare.changeContents(playersTemp);
			   gameSquares.set(((boardSize  * boardSize)-1),tempSquare);
			   gameBoard[boardSize-1][boardSize-1] = playersTemp;
			   
        	   
        	   break;
           }
           playerNumber++;
        } 
		
		
	}while (playerNumber <= gamePlayers.size());
		System.out.println(gameSquares.size() + " assigned");
    }

}

