import java.util.*;





public class MovableItem extends Item {
	
	public boolean canMove;
	public static int tempInt;
	private static Item[][] gameBoard ;
	private static int[] results;

	public MovableItem(String itemChar) 
	{
		super(itemChar);
		this.canMove = true;
	}
/*-----------------------------Using Arraylists----------------------------------*/	
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
				     objectSquare.changeYCoord(tempInt);
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
	
	/*-----------------------------Using two dimensional----------------------------------*/
	
	public static int[] moveItem2(int XCoord, int YCoord, String direction
			           , int boardSize) throws outOfBoundsException
    {   //Changed now to return x and y coords after move. n
		
		
		results = new int[2];
		
        if (direction == "Up")
        	{
        	   if ((YCoord == 0) && (XCoord != ((boardSize/2) )))
        		   {
        		   	 throw new outOfBoundsException("Out of Bounds Top");
        		    }
        	   
   	           else if (XCoord == ((boardSize/2) ))
   	                {
   		             YCoord = boardSize;
   		             
   	                 }
   	           else
   	                 {
   		             tempInt = YCoord - 1;
   		             YCoord =tempInt;
   		              
   		        	 }
        	   results[0] = XCoord;
        	   results[1] = YCoord;
        	   return results;
	         }
        
        else if (direction =="Down")
            {
   	           if ((YCoord  > boardSize-1) && (XCoord != boardSize/2))
   	               {
   		            throw new outOfBoundsException("Out of Bounds Bottom");
   	               }
   	           else if (XCoord == ((boardSize/2)))
   	               {
   		           YCoord = 1;
   		           
   	                }
   	          else
   	               {
   		           tempInt = YCoord + 1;
   		           YCoord = tempInt;
   		           
   		           }
   	        results[0] = XCoord;
     	    results[1] = YCoord;
   	        return results;
	       }

        else if (direction =="Left")
        	{
        	   if ((XCoord == 0) && (YCoord != ((boardSize/2) )))
        	   {
        		   throw new outOfBoundsException("Out of Bounds Left");
        	   }
   	           else if (YCoord == ((boardSize/2)))
   	           {
   		           XCoord = (boardSize);
   		          
   	           }
   	           else
   	          {
		           tempInt = XCoord - 1;
		           XCoord =(tempInt); 
		           
   	           }
        	   results[0] = XCoord;
        	   results[1] = YCoord;
        	   return results;

        	   
	     
    }

    else if (direction =="Right")
    {
   	 if ((XCoord  > boardSize - 1)&& 
		     (YCoord != ((boardSize/2) )))
   	 {
   		 throw new outOfBoundsException("Out of Bounds Right");
   	 }
   	 else if (YCoord == ((boardSize/2)))
   	 {
   		XCoord = (1);
   	    
   	 }
   	 else
   	 {
   		 tempInt = XCoord + 1;
   		XCoord = (tempInt);
   		
   	 }
       results[0] = XCoord;
	   results[1] = YCoord;
   	return results;  
	     
	  
    }
        results[0] = XCoord;
 	    results[1] = YCoord;
		return results;
  	 
  }
}

	

