package serveur;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ProfilInterface extends Remote{

	public void creerProfil(String nom, String prenom,String mdp,String email,String fonction, String statut) throws RemoteException; 
	public String[] recupererProfil(int id) throws RemoteException;
	public String recupererNom(int id) throws RemoteException;
	public String recupererPrenom(int id) throws RemoteException;
	public String recupererMdp(int id) throws RemoteException;
	public String recupererEmail(int id) throws RemoteException;
	public String recupererFonction(int id) throws RemoteException;
	public String recupererStatut(int id) throws RemoteException;
	public void supprimmerProfil(int id) throws RemoteException;
	public void modifierNom(int id,String nom) throws RemoteException;
	public void modifierPrenom(int id, String prenom) throws RemoteException;
	public void modifierMdp(int id,String mdp) throws RemoteException;
	public void modifierEmail(int id,String email) throws RemoteException;
	public void modifierFonction(int id,String fonction) throws RemoteException;
	public void modifierStatut(int id,String statut) throws RemoteException;

}
