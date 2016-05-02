
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ProfilInterface extends Remote{

	public void creerProfil(String log,String nom, String prenom,String mdp,String email,String fonction, String statut, String statutCreateur) throws RemoteException; 
	public void afficherProfils() throws RemoteException;
	public String[] recupererProfil(String id) throws RemoteException;
	public String recupererMdp(String id, String statut) throws RemoteException;
	public String recupererStatut(String id, String statut) throws RemoteException;
	public int recupererModerateur(String id, String statut) throws RemoteException;
	public void supprimerProfil(String id, String statut) throws RemoteException;
	public void modifierNom(String id,String nom, String statut) throws RemoteException;
	public void modifierPrenom(String id, String prenom, String statut) throws RemoteException;
	public void modifierMdp(String id,String mdp, String statut) throws RemoteException;
	public void modifierEmail(String id,String email, String statut) throws RemoteException;
	public void modifierFonction(String id,String fonction, String statut) throws RemoteException;
	public void modifierStatut(String id,String statut, String stat) throws RemoteException;
	public void modifierModerateur (String id, String statut)throws RemoteException;
	public boolean connexion (String id, String mdp)throws RemoteException;

}
