package serveur;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AnnonceInterface extends Remote {
	public void posterAnnonce(String annonce) throws RemoteException;
	public String recupererAnnonce(int idAnnonce) throws RemoteException;
	public void afficherAnnonce(String annonce, int idAnnonce) throws RemoteException;
}
