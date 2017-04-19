import java.util.*;


public class Monster extends MovableItem
{
	public boolean canEat;

	public Monster(String itemChar) 
	{
		super(itemChar);
		this.canEat = true;
	}

}

