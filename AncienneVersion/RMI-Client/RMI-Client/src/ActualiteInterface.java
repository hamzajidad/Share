import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ActualiteInterface extends Remote {
	public void posterActualite(String contenu, String idProfil, String date) throws RemoteException;
	public String[] recupererActualite(int idAnnonce) throws RemoteException;
	public void afficherActualite(String annonce, int idAnnonce) throws RemoteException;
}