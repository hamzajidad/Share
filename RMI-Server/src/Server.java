import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

@SuppressWarnings("deprecation")
public class Server {

	public static void main(String[] args){
	
		int port =  1094; //Integer.parseInt(args[1]);
		System.out.println("Lancement Serveur au port : " + port);
		try{
			LocateRegistry.createRegistry(port);
			if(System.getSecurityManager() == null){
				System.out.println("Mise en place Security Manager");
				System.setSecurityManager(new RMISecurityManager());
			}
			
			HelloImpl helloImpl = new HelloImpl();
			
			String url = "rmi://" + InetAddress.getLocalHost().getHostAddress() + "/Hello";
			System.out.println("Url : " + url);
			Naming.rebind(url, helloImpl);
			
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