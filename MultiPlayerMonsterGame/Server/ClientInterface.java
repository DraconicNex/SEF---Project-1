   import java.rmi.*;
 
   public interface ClientInterface extends Remote {
	   public String join() throws RemoteException;
	   public boolean move(String Player, int x,int y) throws RemoteException;
   }