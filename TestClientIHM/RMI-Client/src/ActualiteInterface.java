
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ActualiteInterface extends Remote {
	public void posterActualite(String contenu, String titre, String idProfil, String date, int affichable) throws RemoteException;
	public String[] recupererActualite(int idAnnonce) throws RemoteException;
	public List<Integer> recupererFilActu() throws RemoteException;
	public List<Integer> recupererActuNonValide(boolean mod) throws RemoteException;
	public void modifierAffichable(int idAnnonce,boolean choix, boolean mod)throws RemoteException;
}
