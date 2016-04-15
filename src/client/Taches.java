package client;

import java.io.Serializable;

public class Taches implements Serializable {

	private String time;
	private String date;
	private String lieu;
	private String sujet;
	private int idTache;
	private int idInvitation;
	private int idProfil;
	private int[] listeInvites;
	
	public Taches(){}


	public String getDate() {
		return date;
	}

	public String getLieu() {
		return lieu;
	}

	public String getSujet() {
		return sujet;
	}

	public int getIdTache() {
		return idTache;
	}

	public int getIdProfil() {
		return idProfil;
	}

	public int[] getListeInvites() {
		return listeInvites;
	}

	public int getIdInvitation() {
		return idInvitation;
	}


	public String getTime() {
		return time;
	}
}
