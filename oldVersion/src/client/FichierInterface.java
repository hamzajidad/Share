package serveur;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface FichierInterface extends Remote{
	public String recupererFichier(int id) throws RemoteException;
	public void envoyerFichier(int id) throws RemoteException;
	public void validationPartage(boolean valide) throws RemoteException;
}
