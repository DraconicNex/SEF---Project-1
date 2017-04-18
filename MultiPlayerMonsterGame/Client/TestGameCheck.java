import static org.junit.Assert.*;

import java.rmi.Naming;


import org.junit.Test;

public class TestGameCheck {

	@Test
	public void test() {

			ClientInterface player = null;
			int playerID = 0;
			
			try {

				player = (ClientInterface)Naming.lookup("rmi://localhost/ABC");
				playerID = player.joinLobby();
				System.out.println("player number: "+ playerID);
				

				}catch (Exception arg0) {			
				}
			 
			if((playerID != 0)&&(player != null)){
				GameCheck GameStatus = new GameCheck(player, playerID);
				GameStatus.start();


			}
	}
}
