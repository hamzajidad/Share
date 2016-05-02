
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ForumInterface extends Remote{

	public void posterSujet(int idProfil,int idSujet,String sujet) throws RemoteException;
	public void repondreSujet(int idProfil,String sujet) throws RemoteException;
	public void supprimerSujet(int idSujet) throws RemoteException;
	public void validationSujet(int idSujet,boolean valide) throws RemoteException;
}
