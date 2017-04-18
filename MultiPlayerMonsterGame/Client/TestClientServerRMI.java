import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import org.junit.Test;

public class TestClientServerRMI {

	@Test
	public void test() throws RemoteException, MalformedURLException, NotBoundException { //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!SERVER MUST BE RUNNING FOR THIS TEST!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		ClientInterface player = null;
		int playerID = 0;
		boolean gameActive = false;
		
		player = (ClientInterface)Naming.lookup("rmi://localhost/ABC");
		
		//check obtains playerID from server for player 1
		playerID = player.joinLobby();
		System.out.println("Player1: " +playerID);
		assertEquals(1,playerID);
		
		//checks if game is now active
		gameActive = player.inGame(playerID);
		System.out.println("Game: " +gameActive);
		assertEquals(false,gameActive);
		
		
		
		//check obtains playerID from server for player 2
		playerID = player.joinLobby();
		System.out.println("Player1: " +playerID);
		assertEquals(2,playerID);
		
		//checks if game is now active
		gameActive = player.inGame(playerID);
		System.out.println("Game: " +gameActive);
		assertEquals(true,gameActive); 
		
		

	}

}


