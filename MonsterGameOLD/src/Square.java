import java.util.*;


public class Square {
	
	public int xCoord;
	public int yCoord;
	public Item squareContent;

	public Square(int xCoord, int yCoord, Item squareContent) 
	{
		
		this.xCoord = xCoord;
		this.yCoord = yCoord;
		this.squareContent = squareContent;
			
		
	}
	public  int getX()
	{
		return xCoord;
	}
	
	public int getY()
	{
		return yCoord;
	}
	
	public Item getContents()
	{
		return squareContent;
	}
		
	public int changeXCoord(int newXCoord)
	{
		this.xCoord = newXCoord;
		return xCoord;
	}
	
	public  int changeYCoord(int newYCoord)
	{
		this.yCoord = newYCoord;
		return yCoord;
	}
	
	public  Item changeContents(Item tempContent)
	
	{
		this.squareContent = tempContent;
		return squareContent;
	}

}
