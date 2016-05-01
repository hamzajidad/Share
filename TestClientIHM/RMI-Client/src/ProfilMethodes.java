


import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public class ProfilMethodes {
	
	public static boolean connect(String login, String mdp) throws MalformedURLException, RemoteException, NotBoundException{
		Remote r = Naming.lookup("rmi://"+Client.getUrl()+"/Profil");
		return ((ProfilInterface) r).connexion(login, mdp);
	
	}
	public static void creerUnProfil(String login, String nom, String prenom, String fonction, String email, String mdp, String statut, String statutCreateur) throws MalformedURLException, RemoteException, NotBoundException{
		Remote r = Naming.lookup("rmi://"+Client.getUrl()+"/Profil");
		((ProfilInterface) r).creerProfil(login, nom, prenom, fonction, email, mdp, statut, statutCreateur);
	
	}
}
