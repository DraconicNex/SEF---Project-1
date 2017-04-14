   import java.rmi.*;
 
   public interface ClientInterface extends Remote {
	   public int joinLobby() throws RemoteException;
	   public boolean move(String Player, int x,int y) throws RemoteException;
   }