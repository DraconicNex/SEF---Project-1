import java.util.*;
import java.lang.*;


public class Monster extends MovableItem
{
	
	public  int posn[] = new int[2];
	public ArrayList<int[]> playerCoordsForMonster = new ArrayList<int []>();
	public int x1,x2,y1,y2;
	public double[] playerManhattanCoords;

	public Monster(String itemChar) 
	{
		super(itemChar);
		
	}
	
	public static String moveMonsterDirection( ArrayList<int[]> playerCoordsForMonster)
	
	{
		
		return " ";
	}
	
	
	
		
		    
	public  double[] mDistance(int x1, int y1, int x2, int y2, String [] args) {
		
		    x1=Integer.parseInt(args[0]);
		  
		    y1=Integer.parseInt(args[1]);
		
		    x2=Integer.parseInt(args[2]);
		
		    y2=Integer.parseInt(args[3]);
		
		    //computing Manhattan Distance
		
		    playerManhattanCoords[0] =Math.abs(x1-x2);
		
		    playerManhattanCoords[1] =Math.abs(y1-y2);
		    
		    return playerManhattanCoords;
		}
	
	public static void examineManhattanDistance(ArrayList<int[]> playerCoordsForMonster)
	{
		
		
		for (int a=0; a< playerCoordsForMonster.size() ; a++)
		{
			System.out.println("from monster "+a+" " + playerCoordsForMonster.get(a)[0]
					+" " + playerCoordsForMonster.get(a)[1]  );
			
			
		}
	}


}

