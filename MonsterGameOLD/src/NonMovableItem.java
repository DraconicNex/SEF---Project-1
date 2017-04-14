import java.util.*;



public class NonMovableItem extends Item
{
	public boolean stationary;

	public NonMovableItem(int xCoord, int yCoord,boolean stationary) 
	{
		
		super(xCoord, yCoord);
		this.stationary = stationary;
	}

}
