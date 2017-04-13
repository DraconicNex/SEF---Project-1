import java.util.*;


public class Square {
	
	public int xCoord;
	public int yCoord;
	public String squareContent;

	public Square(int xCoord, int yCoord, String squareContent) 
	{
		
		this.xCoord = xCoord;
		this.yCoord = yCoord;
		this.squareContent = squareContent;
			
		
	}
	public int getX()
	{
		return xCoord;
	}
	
	public int getY()
	{
		return yCoord;
	}
	
	public String getContents()
	{
		return squareContent;
	}
		
		
	public static Square changeContent(Square tempSquare, String tempString)
	{
		Square newSquare = new Square(tempSquare.getX(),tempSquare.getY(),tempString);
		
		return newSquare;
	}
	
	public String changeContents(String tempString)
	
	{
		this.squareContent = tempString;
		return squareContent;
	}

}
