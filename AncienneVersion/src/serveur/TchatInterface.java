package serveur;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface TchatInterface extends Remote{
	
	public void envoyerMessage(String message) throws RemoteException;
	public String recevoirMessage(int idMessage,String message) throws RemoteException;
    public void rechercheReceveur(String nom,String prenom,String email,String fonction) throws RemoteException;
}
