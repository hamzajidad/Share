import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.Remote;
import java.rmi.RemoteException;

@SuppressWarnings("deprecation")
public class Client {

	public static void main(String[] args){
		
		System.out.println("Lancement Client");
		
		if(System.getSecurityManager() == null){
			System.out.println("Mise en place Security Manager");
			System.setSecurityManager(new RMISecurityManager());
		}
		try{
			System.out.println("Utilisation lookup");
			Remote r = Naming.lookup("rmi://127.0.0.2/Hello");
			System.out.println("Utilisation fonction");
			System.out.println(((HelloInterface) r).hello());
			
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
