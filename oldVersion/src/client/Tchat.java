package client;

import java.io.Serializable;

public class Tchat implements Serializable {
	
	private String message;
	private int idEmetteur;
	private int idRecepteur;
	
	public Tchat() {}
	
	public String getMessage() {
		return message;
	}


	public int getIdEmetteur() {
		return idEmetteur;
	}


	public int getIdRecepteur() {
		return idRecepteur;
	}

	


}
