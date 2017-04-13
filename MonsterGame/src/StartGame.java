import java.util.*;



public class StartGame 
{
	private static final Scanner sc = new Scanner(System.in);

	

	public static void main(String[] args)
	{
		StartGame startGame = new StartGame();

	}
	public StartGame() {
		
		int boardSize;
		String directionInput;
		
		int numOfPlayers = 0;
		
	    boardSize = 9;
		
		/* Initialise the board size and display player position and
		 * monster start positions. */
	    
		Board.initialiseGameBoard(boardSize);
		
		if (Board.numberOfAssignedPlayers() == 0)
		{
			
			numOfPlayers = Board.PlayerNumbers();
			 
			
		}
		
		//System.out.println(numOfPlayers +" before while");
		System.out.println();
		
		do
		{
			Board.addInitialPlayerPosition(boardSize);
			//System.out.println(numOfPlayers +" in while");
		}
		while (Board.numberOfAssignedPlayers() < numOfPlayers);
		
		
		Board.refreshGameBoard(boardSize);
		
		
		System.out.println((Board. gameMonster()).getX() + " prove can get X coord");
		System.out.println();
		(Board.gameSquares()).size();
		
		for (int move = 1 ; move <= (boardSize/2); move++)
		{
			directionInput = "Left";
			Board.moveMonster(boardSize, directionInput);
			Board.refreshGameBoard(boardSize);
		}
		
		System.out.println((Board.gameSquares()).size() + " size of game players");
		System.out.println();
		System.out.println((Board. gameMonster()).getX() + " prove monster x coord moved");
		System.out.println();
		Board.movePlayer(boardSize,1);
		
		
		Board.refreshGameBoard(boardSize);
	
		
		
	}
}
