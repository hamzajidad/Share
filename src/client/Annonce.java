package client;

import java.io.Serializable;

public class Annonce implements Serializable{

	private String annonce;
	private int idAnnonce;
	private int idProfil;
	
	public String getAnnonce() {
		return annonce;
	}

	public int getIdAnnonce() {
		return idAnnonce;
	}

	public int getIdProfil() {
		return idProfil;
	}

}
