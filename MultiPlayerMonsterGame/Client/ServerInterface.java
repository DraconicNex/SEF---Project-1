   import java.rmi.*;
 
   public interface ServerInterface extends Remote {

	   public int joinLobby() throws RemoteException;
   }