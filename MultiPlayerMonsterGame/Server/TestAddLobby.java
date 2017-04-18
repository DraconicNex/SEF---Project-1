import static org.junit.Assert.*;

import java.rmi.RemoteException;

import org.junit.Test;

public class TestAddLobby {

	@Test
	public void testLobby() throws RemoteException {

 		Game test = new Game();
		int result = test.joinLobby();
		System.out.println("result: " + result);
		assertEquals(1,result);
		result = test.joinLobby();
		System.out.println("result2: " + result);
		assertEquals(2,result);  

	}

}
