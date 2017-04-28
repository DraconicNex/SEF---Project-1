
public class ServerConsoleOutput extends ViewerType
{
	public static int boardSize;
	public static Item[][] gameBoard;

	public ServerConsoleOutput() 
	{
		super();
	}
	
	public   void refreshBoard()
	{
		
		
	 boardSize = Board.getBoardSize();
	 gameBoard = Board.getgameBoard();
		
         System.out.println(boardSize+ "  viewer type refreshed");
		
		
		
		       for (int a = 0; a < boardSize; a++)
		         {
			        for (int b = 0; b < boardSize; b++)
			        {
				
				
				      System.out.print(gameBoard[b][a].getItemChar());
				
			         }
			        System.out.println();
		         }
		 System.out.println("multidimensional array from viewer type");
	}

}
