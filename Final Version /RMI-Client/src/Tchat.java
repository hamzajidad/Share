import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public class Tchat{
	
	private Profil utilisateur;
	private Profil correspondant;
	
	public Tchat(Profil idu, Profil idc){
		
		utilisateur = idu;
		correspondant = idc;
		
	}
	
	public List<String> recevoirMessage() throws MalformedURLException, RemoteException, NotBoundException{
		Remote r = Naming.lookup("rmi://"+Client.getUrl()+"/Tchat");
		return ((TchatInterface) r).recevoirMessage(correspondant.getLogin(), utilisateur.getLogin());
		
		
	}
	
	public void envoyerMessage(String contenu) throws MalformedURLException, RemoteException, NotBoundException{
		Remote r = Naming.lookup("rmi://"+Client.getUrl()+"/Tchat");
		((TchatInterface) r).envoyerMessage(contenu, utilisateur.getLogin(), correspondant.getLogin());

	}
	
	public Profil getUtilisateur(){
		return utilisateur;
	}
	
	public Profil getCorrespondant(){
		
		return correspondant;
	}
	
	

}
