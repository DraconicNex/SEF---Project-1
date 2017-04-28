import java.util.*;






public class StartGame 
{
	//private static final Scanner sc = new Scanner(System.in);

	

	public static void main(String[] args)
	{
		StartGame startGame = new StartGame();
		
		

	}
	public StartGame() {
		
		
		
		
		int numOfPlayers = 0;
		ServerConsoleOutput serverConsole = new ServerConsoleOutput();
		ViewerType myViewerType = serverConsole;
		
	   
		
		/* Initialise the board size and display player position and
		 * 
		 *  */
	    
		Board.initialiseGameBoard();
		
		serverConsole.refreshBoard();
				
		Board.PlayerNumbers();
		
		Board.chooseStartPostion();
		//Board.refreshGameBoard2();
		
		//Board.refreshGameBoard();
		
		//Board.moveitem();
		
		Board.moveItem2(1,"Down");
		serverConsole.refreshBoard();
		Board.moveItem2(2,"Left");
		serverConsole.refreshBoard();
		Board.moveItem2(3,"Up");
		serverConsole.refreshBoard();
		Board.moveItem2(4,"Left");
		serverConsole.refreshBoard();
			
		//Board.refreshGameBoard();
		//Board.refreshGameBoard2();
		 
		 serverConsole.refreshBoard();
		
		  
		
		

		

		
		
		
		
		
	}
}
