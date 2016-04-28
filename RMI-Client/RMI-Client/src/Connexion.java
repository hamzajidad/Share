


import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public class Connexion {
	
	public static boolean connect(String login, String mdp) throws MalformedURLException, RemoteException, NotBoundException{
		Remote r = Naming.lookup("rmi://"+Client.getUrl()+"/Profil");
		return ((ProfilInterface) r).connexion(login, mdp);
	
	}
}
