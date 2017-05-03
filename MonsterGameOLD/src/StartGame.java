import java.util.*;






public class StartGame 
{
	//private static final Scanner sc = new Scanner(System.in);
	
	private static ViewerType myViewerType,playerViewerType;

	

	public static void main(String[] args)
	{
		StartGame startGame = new StartGame();
		
		

	}
	public StartGame() {
		
		
		
		
		int numOfPlayers = 0;
		 myViewerType = new ServerConsoleOutput();
		 playerViewerType = new PlayerScreenOutput();
		
		
		
		
	   
		
		/* Initialise the board size and display player position and
		 * 
		 *  */
	    
		Board.initialiseGameBoard();
		
		myViewerType.refreshBoard();
		playerViewerType.refreshBoard();
				
		Board.PlayerNumbers();
		
		Board.chooseStartPostion();
		myViewerType.refreshBoard();
		playerViewerType.refreshBoard();
		
	    /*
		Board.moveItem2(1,"Down");
		myViewerType.refreshBoard();
		playerViewerType.refreshBoard();

		
		Board.moveItem2(2,"Left");
		myViewerType.refreshBoard();
		playerViewerType.refreshBoard();
		Board.moveItem2(3,"Up");
		myViewerType.refreshBoard();
		playerViewerType.refreshBoard();
		Board.moveItem2(4,"Left");
		myViewerType.refreshBoard();
		playerViewerType.refreshBoard();
			
		*/	 
		 
		  
		
		    Board.moveItem2("M","Left");
		    myViewerType.refreshBoard();
		    playerViewerType.refreshBoard();
	 		
		

		
		
		
		
		
	}
}
