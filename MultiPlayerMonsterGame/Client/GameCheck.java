import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

class GameCheck implements Runnable {
   private Thread t;
   private boolean gameActive = false;
   private ClientInterface server;
   private int playerID;
   
   GameCheck(ClientInterface player, int PlayerID) {
      server = player;
      playerID = PlayerID;
		
      //System.out.println("Creating " +  threadName );
   }
   
   public void run() {

      try {
         while(gameActive != true){
				try {
					gameActive = server.inGame(playerID);
					}catch (Exception arg0) {			
						//System.out.println("GameStart Check Error!");
					}
				 System.out.println("PlayerID: " + playerID + " Game On" + gameActive);
            Thread.sleep(50);
         }
      }catch (InterruptedException e) {
         System.out.println("PlayerID: " + playerID + " interrupted.");
      }
      System.out.println("PlayerID: " + playerID + " exiting." + gameActive);
   }
   
   public void start () {

      if (t == null) {
         t = new Thread (this);
         t.start ();
      }
   }
}