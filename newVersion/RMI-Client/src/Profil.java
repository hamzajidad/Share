


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
	
	//moderateur ce serait bien d etre boolean
	public Profil(String idProfil) throws MalformedURLException, RemoteException, NotBoundException{
		System.out.println("profil"+idProfil);
		Remote r = Naming.lookup("rmi://"+Client.getUrl()+"/Profil");
		String[] infoProfil = ((ProfilInterface) r).recupererProfil(idProfil);
		this.idProfil= infoProfil[0];
		this.nom= infoProfil[1];
		this.prenom=infoProfil[2];
		this.email=infoProfil[3];
		this.fonction= infoProfil[4];
		this.statut= infoProfil[5];
		this.moderateur=infoProfil[6];
		System.out.println("nom"+infoProfil[1]);

	}
	
	public Profil(String nom, String prenom, String email, String fonction, String mdp, String statut) {
		
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.fonction = fonction;
		this.statut = statut;
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

}

	


