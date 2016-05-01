import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public class TchatMethodes{

	
	public static List<String> detecteterConversation() throws MalformedURLException, RemoteException, NotBoundException{
		
		Remote r = Naming.lookup("rmi://"+Client.getUrl()+"/Tchat");
		return ((TchatInterface) r).detecterConversation(LoginIHM.utilisateur.getLogin());
	}


}