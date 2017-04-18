import java.rmi.*;
import java.rmi.server.*;
import java.util.*;

import javax.swing.JOptionPane;
 
public  class Game extends UnicastRemoteObject implements ClientInterface {
	 
	public Game () throws RemoteException {   }
	 
	  LinkedList<Integer> Lobby = new LinkedList<Integer>();
	  boolean currentGame = false;
	 
    
      public int joinLobby() {
    	  
    	   if(Lobby.isEmpty() == true){
    		  Lobby.add(1);
    	  }else{
    		 int lastID = Lobby.getLast();
    		 Lobby.add(lastID + 1);
    		
    	  }
    	   
    	   if((Lobby.size() == 2)&&(currentGame != true)){
    		   monsterGame();
    	   }
    	   System.out.println("player number game: "+ Lobby.getLast());
    	  return Lobby.getLast(); 
    	  
      }
      
      public  void monsterGame() {
    	  for(int i = 0; i <= 1; i++){

    	  }
      }

 }

