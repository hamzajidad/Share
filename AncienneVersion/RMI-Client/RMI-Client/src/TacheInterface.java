


import java.rmi.Remote;
import java.rmi.RemoteException;

public interface TacheInterface extends Remote{

	public void creerTache(String date,String lieu, int idProfil,String sujet,int idTache,String organisateur) throws RemoteException;
	public void supprimerTache(int idTache) throws RemoteException;
	public void ajouterInvitation(int idTache,int idProfil,String contenu) throws RemoteException;
	public void validationInvitation(boolean valide) throws RemoteException;
}
