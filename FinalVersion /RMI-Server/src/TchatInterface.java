import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface TchatInterface extends Remote{
	public void envoyerMessage(String contenu, String idExpediteur, String idReceveur) throws RemoteException;
	public List<String> recevoirMessage(String idExpediteur, String idReceveur) throws RemoteException;
	public List<String> detecterConversation(String idReceveur) throws RemoteException;
	public void suprimerMessage(int id) throws RemoteException;
}
