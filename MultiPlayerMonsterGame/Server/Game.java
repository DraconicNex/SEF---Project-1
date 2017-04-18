import java.rmi.*;
import java.rmi.server.*;
import java.util.*;

import javax.swing.JOptionPane;
 
public  class Game extends UnicastRemoteObject implements ClientInterface {
	 
	public Game () throws RemoteException {   }
	 
	  LinkedList<Integer> Lobby = new LinkedList<Integer>();
	  boolean currentGame = false;
	  int playersInGame = 1;
    
	  
      public int joinLobby() {
    	  
    	   if(Lobby.isEmpty() == true){
    		  Lobby.add(1);
    	  }else{
    		 int lastID = Lobby.getLast();
    		 Lobby.add(lastID + 1);
    	  }
    	   
    	   if((Lobby.size() >= playersInGame)&&(currentGame != true)){
    		   monsterGame();
    		   currentGame = true;
    	   }
    	   
    	  // System.out.println("playerID issued: "+ Lobby.getLast());
    	   
    	  return Lobby.getLast(); 
    	  
      }
      
      
      public boolean inGame(int PlayerID) {
    	  if(currentGame == true){
	    	  for(int i = 1; i <= playersInGame; i++){
	    		  if(Lobby.get(i) == PlayerID){
	    			  return true;
	    		  } 
	    	  }  
    	  }
    	  return false;
      }
      
      
      public  void monsterGame() {
    	  for(int i = 0; i <= 1; i++){

    	  }
      }
      
      
      

 }

