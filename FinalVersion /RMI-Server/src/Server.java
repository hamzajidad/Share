import java.net.InetAddress;

import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

@SuppressWarnings("deprecation")
public class Server{

	public static void main(String[] args){

		int port = Integer.parseInt(args[0]);
		System.out.println("Lancement Serveur au port : " + port);
		try{
			LocateRegistry.createRegistry(port);
			if(System.getSecurityManager() == null){
				System.out.println("Mise en place Security Manager");
				System.setSecurityManager(new RMISecurityManager());
			}

			ProfilImpl profil = new ProfilImpl();
			TchatImpl tchat = new TchatImpl();
			ActualiteImpl actu = new ActualiteImpl();
			TacheImpl tache = new TacheImpl();

			String url = "rmi://"+InetAddress.getLocalHost().getHostAddress()+"/Profil";
			System.out.println("Url : " + url);
			Naming.rebind(url, profil);

			url = "rmi://"+InetAddress.getLocalHost().getHostAddress()+"/Tchat";
			System.out.println("Url : " + url);
			Naming.rebind(url, tchat);

			url = "rmi://"+InetAddress.getLocalHost().getHostAddress()+"/Actualite";
			System.out.println("Url : " + url);
			Naming.rebind(url, actu);

            url = "rmi://"+InetAddress.getLocalHost().getHostAddress()+"/Tache";
			System.out.println("Url : " + url);
			Naming.rebind(url, tache);

		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		System.out.println("Serveur Tourne");
	}
}
