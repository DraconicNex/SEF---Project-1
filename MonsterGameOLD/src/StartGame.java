import java.util.*;



public class StartGame 
{
	private static final Scanner sc = new Scanner(System.in);

	

	public static void main(String[] args)
	{
		StartGame startGame = new StartGame();

	}
	public StartGame() {
		
		
		
		
		int numOfPlayers = 0;
		
	   
		
		/* Initialise the board size and display player position and
		 * monster start positions.
		 * newer code
		 * after message
		 * test 2
		 * test 3
		 * 
		 * 
		 *  */
	    
		Board.initialiseGameBoard();
		
		Board.refreshGameBoard2();
				
		Board.PlayerNumbers();
		
		Board.chooseStartPostion();
		Board.refreshGameBoard2();
		
		//Board.refreshGameBoard();
		
		//Board.moveitem();
		
		Board.moveItem2(1,"Down");
		
		//Board.refreshGameBoard();
		Board.refreshGameBoard2();
		
		
		
		
		
		
		
	}
}
