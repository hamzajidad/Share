package rmiclient;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

@SuppressWarnings("deprecation")
public class Client implements Serializable {

	public static void main(String[] args) throws RemoteException{
		
		System.out.println("Lancement Client");
		int port = Integer.parseInt(args[0]);
		System.out.println("Lancement Client au port : " + port);
		String url =args[1];
		System.out.println(" Lancement Client à l'url "  + url);
				
		if(System.getSecurityManager() == null){
			System.out.println("Mise en place Security Manager");
			System.setSecurityManager(new RMISecurityManager());
		}
		try{
			LocateRegistry.getRegistry(url,port);
			System.out.println("Utilisation lookup");
			Remote r = (HelloInterface)Naming.lookup("rmi://"+url+"/Hello");
			System.out.println("Utilisation fonction");
			System.out.println(((HelloInterface)r).hello());
			
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		
		System.out.println("Fermeture Client");
	}
}
