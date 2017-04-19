import java.util.*;





public class MovableItem extends Item {
	
	public boolean canMove;
	public static int tempInt;

	public MovableItem(String itemChar) 
	{
		super(itemChar);
		this.canMove = true;
	}
	
	public static void moveItem(String direction , Square objectSquare 
			         , int boardSize) throws outOfBoundsException
	
	{
		
		
		
		{
	         if (direction == "Up")
		     {
	        	 if ((objectSquare.getY() - 1 < 1) && 
	        	 (objectSquare.getX() != ((boardSize/2) + 1)))
	        	 {
	        		 throw new outOfBoundsException("Out of Bounds Top");
	        	 }
	        	 else if (objectSquare.getX() == ((boardSize/2) + 1))
	        	 {
	        		 objectSquare.changeYCoord(boardSize);
	        	 }
	        	 else
	        	 {
	        		 tempInt = objectSquare.getY() - 1;
				     objectSquare.changeXCoord(tempInt);
	        	 }
			     
			     
			
		     }
		    else if (direction =="Down")
		     {
		    	 if ((objectSquare.getY() + 1 > boardSize) && 
	        	 (objectSquare.getX() != ((boardSize/2) + 1)))
	        	 {
	        		 throw new outOfBoundsException("Out of Bounds Bottom");
	        	 }
		    	 else if (objectSquare.getX() == ((boardSize/2) + 1))
	        	 {
	        		 objectSquare.changeYCoord(1);
	        	 }
	        	 else
	        	 {
	        		 tempInt = objectSquare.getY() + 1;
				     objectSquare.changeYCoord(tempInt);
	        	 }
			      
			
		     }
		
		
		
		
		
		     else if (direction =="Left")
		     {
		    	 if ((objectSquare.getX() - 1 < 1) && 
		    			 (objectSquare.getY() != ((boardSize/2) + 1)))
		    			 
	        	 {
	        		 throw new outOfBoundsException("Out of Bounds Left");
	        	 }
		    	 else if (objectSquare.getY() == ((boardSize/2) + 1))
	        	 {
	        		 objectSquare.changeXCoord(boardSize);
	        	 }
		    	 else
		    	 {
				      tempInt = objectSquare.getX() - 1;
				      objectSquare.changeXCoord(tempInt); 
		    	 }

			     
		     }
		
		     else if (direction =="Right")
		     {
		    	 if ((objectSquare.getX() - 1 > boardSize)&& 
    			     (objectSquare.getY() != ((boardSize/2) + 1)))
	        	 {
	        		 throw new outOfBoundsException("Out of Bounds Right");
	        	 }
		    	 else if (objectSquare.getY() == ((boardSize/2) + 1))
	        	 {
	        		 objectSquare.changeXCoord(1);
	        	 }
		    	 else
		    	 {
		    		 tempInt = objectSquare.getX() + 1;
				     objectSquare.changeXCoord(tempInt);
		    	 }
			     
			     
		     }
	
		   	 
		}
	}
	
	        
	
}
