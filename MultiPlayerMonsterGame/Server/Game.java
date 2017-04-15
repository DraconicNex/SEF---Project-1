import java.rmi.*;
import java.rmi.server.*;
import java.util.*;
 
public class Game extends UnicastRemoteObject implements ClientInterface {
	 
	public Game () throws RemoteException {   }
	 
	  LinkedList<Integer> Lobby = new LinkedList<Integer>();
	 
    
      public int joinLobby() {
    	   if(Lobby.isEmpty() == true){
    		  Lobby.add(1);
    	  }else{
    		 int lastID = Lobby.getLast();
    		 Lobby.add(lastID + 1);
    		
    	  } 
    	  return Lobby.getLast(); 
      }
 }

