package client;

import java.io.Serializable;

public class Profil implements Serializable {

	private String nom;
	private String prenom;
	private int idProfil;
	private String mdp;
	private String email;
	private String fonction ;
	private String statut;
	
	
	public Profil(){}


	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}


	public int getIdProfil() {
		return idProfil;
	}

	public String getMdp() {
		return mdp;
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
