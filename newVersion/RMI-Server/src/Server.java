import java.net.InetAddress;

import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

@SuppressWarnings("deprecation")
public class Server{

	public static void main(String[] args){
	
		//int port =  1094;
		int port = Integer.parseInt(args[0]);
		System.out.println("Lancement Serveur au port : " + port);
		try{
			LocateRegistry.createRegistry(port);
			//HelloImpl p = new HelloImpl();
			//HelloInterface p_stub = (HelloInterface) UnicastRemoteObject.exportObject(p,0);
			
			if(System.getSecurityManager() == null){
				System.out.println("Mise en place Security Manager");
				System.setSecurityManager(new RMISecurityManager());
			}
			
			HelloImpl helloImpl = new HelloImpl();
			ProfilImpl p = new ProfilImpl();
			
			String url = "rmi://"+InetAddress.getLocalHost().getHostAddress()+"/Hello";
			System.out.println("Url : " + url);
			Naming.rebind(url, helloImpl);
			
			url = "rmi://"+InetAddress.getLocalHost().getHostAddress()+"/Profil";
			System.out.println("Url : " + url);
			Naming.rebind(url, p);
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
