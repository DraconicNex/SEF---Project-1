import java.util.*;


public class Monster extends MovableItem
{
	public boolean canEat;

	public Monster(int xCoord, int yCoord) 
	{
		super(xCoord, yCoord);
		this.canEat = true;
	}

}
