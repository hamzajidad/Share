package client;

import java.io.Serializable;

public class Commentaire implements Serializable {

	private int idCommentateur;
	private String contenu;
	private int idCommentaire;
	private String heure;
	private String date;	
	
	public int getIdCommentateur() {
		return idCommentateur;
	}	
	public int getIdCommentaire() {
		return idCommentaire;
	}
	public String getContenu() {
		return contenu;
	}
	public String getHeure() {
		return heure;
	}
	public String getDate() {
		return date;
	}
}
