


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
		
		Remote r = Naming.lookup("rmi://"+Client.getUrl()+"/Hello");
		String[] infoProfil = ((ProfilInterface) r).recupererProfil(idProfil);
		infoProfil[0] = this.idProfil;
		infoProfil[1] = this.nom;
		infoProfil[2] = this.prenom;
		infoProfil[3] = this.email;
		infoProfil[4] = this.fonction;
		infoProfil[5] = this.statut;
		infoProfil[6] = this.moderateur;
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

	


