package serveur;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface SujetInterface extends Remote{
	public void supprimerCommentaire(int idSujet,String commentaire) throws RemoteException;
}
