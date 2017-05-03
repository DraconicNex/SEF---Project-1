import java.util.*;


public class Monster extends MovableItem
{
	public boolean canEat;
	public static int posn[] = new int[2];
	public static ArrayList<int[]> playerCoordsForMonster = new ArrayList<int []>();

	public Monster(String itemChar) 
	{
		super(itemChar);
		this.canEat = true;
	}
	
	public static String moveMonsterDirection( ArrayList<int[]> playerCoordsForMonster)
	
	{
		
		return " ";
	}

}

