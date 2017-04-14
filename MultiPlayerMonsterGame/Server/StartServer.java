import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.util.*;  

public class StartServer {

	public static void main(String[] args) {
		   try {
			   Game Hello = new Game();
			   LocateRegistry.createRegistry(1099);
			   Naming.rebind("rmi://localhost/ABC", Hello);
			   
			   System.out.println("Addition Server is ready.");
			   }catch (Exception e) {
				   System.out.println("Addition Server failed: " + e);
				}
		   
	}

}
