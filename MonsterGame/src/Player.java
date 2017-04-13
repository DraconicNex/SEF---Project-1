import java.util.*;



public class Player extends MovableItem
{
	
	public boolean eaten;
	

	public Player(int xCoord, int yCoord) 
	{
		super(xCoord, yCoord);
		this.eaten = false;
		
	}
	
	
	public boolean geteaten()
	{
		return eaten;
	}
		
	

}
