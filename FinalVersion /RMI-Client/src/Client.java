

import java.net.MalformedURLException;


import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;

@SuppressWarnings("deprecation")
public class Client {
	
	private static String url;

	public static void main(String[] args) throws RemoteException, MalformedURLException, NotBoundException{
		
		ConnexionServeur(args);
		LoginIHM login = new LoginIHM();
		login.main(args);
		
		
	}
	
	
	
	public static void ConnexionServeur(String[] args) throws RemoteException, MalformedURLException, NotBoundException{
		
		System.out.println("Lancement Client");
		int port = Integer.parseInt(args[0]);
		System.out.println("Lancement Client au port : " + port);
		setUrl(args[1]);
		System.out.println("Lancement du Client au l'url : " + getUrl());


		
		if(System.getSecurityManager() == null){
			System.out.println("Mise en place Security Manager");
			System.setSecurityManager(new RMISecurityManager());
		}

	}

	public static String getUrl() {
		return url;
	}

	public static void setUrl(String url) {
		Client.url = url;
	}

}	
