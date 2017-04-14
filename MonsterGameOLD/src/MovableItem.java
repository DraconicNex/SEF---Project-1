import java.util.*;



public class MovableItem extends Item {
	
	public boolean canMove;

	public MovableItem(int xCoord, int yCoord) 
	{
		super(xCoord, yCoord);
		this.canMove = true;
	}
	
	public int moveItem(String direction)
	{
		if (direction == "Up")
		{
			this.xCoord = super.getX() - 1;		
		}
		else if (direction =="Down")
		{
			this.xCoord = super.getX() + 1;	
		}
		else if (direction =="Left")
		{
			this.yCoord = super.getY() - 1;	
		}
		else if (direction =="Right")
		{
			this.yCoord = super.getY() + 1;	
		}
		
		return super.xCoord;
	}

}
