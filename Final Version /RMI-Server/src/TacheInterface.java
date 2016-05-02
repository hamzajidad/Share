
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface TacheInterface extends Remote{

	public void creerTache(String date,String lieu,String sujet,String organisateur, String contenu) throws RemoteException;
	public void supprimerTache(int idTache) throws RemoteException;
	public void ajouterInvitation(int idTache,String idProfil) throws RemoteException;
	public void supprimerInvitation(int idTache,String idProfil) throws RemoteException;
	public void annulerInvitation(int idTache,String idProfil) throws RemoteException;
	public void validationInvitation(int idTache,String idProfil) throws RemoteException;
	public String[] recupererTache(int idTache) throws RemoteException;
	public ArrayList<Integer> recupererInvitation(String idProfil) throws RemoteException;
	public int recupererReponse(int idTache, int idProfil) throws RemoteException;
}
