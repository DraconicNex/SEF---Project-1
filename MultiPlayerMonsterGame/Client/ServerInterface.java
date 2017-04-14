   import java.rmi.*;
 
   public interface ServerInterface extends Remote {

	   public String joinLobby() throws RemoteException;
   }