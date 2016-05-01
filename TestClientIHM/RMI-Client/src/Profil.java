


import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public class Profil implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String idProfil;
	private String nom;
	private String prenom;
	private String email;
	private String fonction;
	private String statut;
	private String moderateur;
	
	public Profil(String idProfil) throws MalformedURLException, RemoteException, NotBoundException{
		Remote r = Naming.lookup("rmi://"+Client.getUrl()+"/Profil");
		String[] infoProfil = ((ProfilInterface) r).recupererProfil(idProfil);
		this.idProfil= infoProfil[0];
		this.nom= infoProfil[1];
		this.prenom=infoProfil[2];
		this.email=infoProfil[3];
		this.fonction= infoProfil[4];
		this.statut= infoProfil[5];
		this.moderateur=infoProfil[6];

	}
	
	public Profil(String nom, String prenom, String email, String fonction, String mdp, String statut) {
		idProfil = "";
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.fonction = fonction;
		this.statut = statut;
		moderateur = "0";
	}
	
	public String getNom() {
		return nom;
	}
	
	public String getPrenom() {
		return prenom;
	}

	public String getEmail() {
		return email;
	}
	
	public String getFonction() {
		return fonction;
	}
	
	public String getStatut() {
		return statut;
	}
	
	public String getLogin(){
		return idProfil;
	}
	
	public boolean getModerateur(){
		if(moderateur.equals("0")){return false;}
		else{return true;}
	}
	
	public String getMdp(String statut) throws RemoteException, MalformedURLException, NotBoundException{
		Remote r = Naming.lookup("rmi://"+Client.getUrl()+"/Profil");
		return ((ProfilInterface) r).recupererMdp(idProfil, statut);
	}
	
	public static void modifNom( String idProfil, String modif, String statut) throws RemoteException, MalformedURLException, NotBoundException{
			Remote r = Naming.lookup("rmi://"+Client.getUrl()+"/Profil");
			((ProfilInterface) r).modifierNom(idProfil, modif, statut);
	}

	public static void modifPrenom( String idProfil, String modif, String statut) throws RemoteException, MalformedURLException, NotBoundException{
		Remote r = Naming.lookup("rmi://"+Client.getUrl()+"/Profil");
		((ProfilInterface) r).modifierPrenom(idProfil, modif, statut);
	}
	
	public static void modifMdp( String idProfil, String modif, String statut) throws RemoteException, MalformedURLException, NotBoundException{
		Remote r = Naming.lookup("rmi://"+Client.getUrl()+"/Profil");
		((ProfilInterface) r).modifierMdp(idProfil, modif, statut);
	}
	
	public static void modifEmail( String idProfil, String modif, String statut) throws RemoteException, MalformedURLException, NotBoundException{
		Remote r = Naming.lookup("rmi://"+Client.getUrl()+"/Profil");
		((ProfilInterface) r).modifierEmail(idProfil, modif, statut);
	}
	
	public static void modifFonction( String idProfil, String modif, String statut) throws RemoteException, MalformedURLException, NotBoundException{
		Remote r = Naming.lookup("rmi://"+Client.getUrl()+"/Profil");
		((ProfilInterface) r).modifierFonction(idProfil, modif, statut);
	}
	
	public static void modifStatut( String idProfil, String modif, String statut) throws RemoteException, MalformedURLException, NotBoundException{
		Remote r = Naming.lookup("rmi://"+Client.getUrl()+"/Profil");
		((ProfilInterface) r).modifierStatut(idProfil, modif, statut);
	}
	
	public static void modifModerateur( String idProfil, String statut) throws RemoteException, MalformedURLException, NotBoundException{
		Remote r = Naming.lookup("rmi://"+Client.getUrl()+"/Profil");
		((ProfilInterface) r).modifierModerateur(idProfil, statut);
	}
	
	
}


	


