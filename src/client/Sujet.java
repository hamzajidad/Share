package client;

import java.io.Serializable;

public class Sujet implements Serializable{

	private int idSujet;
	private int idAuteur;
	private String sujet;
	
	//getteurs 
	public int getIdSujet() {
		return idSujet;
	}
	public int getIdAuteur() {
		return idAuteur;
	}
	public String getSujet() {
		return sujet;
	}
}
