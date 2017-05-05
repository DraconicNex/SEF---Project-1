
public class ServerConsoleOutput extends ViewerType
{
	public  int boardSize;
	public  Item[][] gameBoard;

	public ServerConsoleOutput() 
	{
		
	}
	
	public   void refreshBoard()
	{
		
		
	 boardSize = Board.getBoardSize();
	 gameBoard = Board.getGameBoard();
		
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
