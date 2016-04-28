package client;

import java.io.Serializable;

public class Invitation implements Serializable {

	private int idInvitation ;
	private int idTache;
	private String sujet;

	public int getIdInvitation() {
		return idInvitation;
	}
	public int getIdTache() {
		return idTache;
	}
	public String getSujet() {
		return sujet;
	}
}
