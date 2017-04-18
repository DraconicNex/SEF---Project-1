   import java.rmi.*;
 
   public interface ServerInterface extends Remote {
	   public int joinLobby() throws RemoteException;
	   public boolean inGame(int PlayerID) throws RemoteException;
	  // public boolean selectPositon(int Position) throws RemoteException; 

   }