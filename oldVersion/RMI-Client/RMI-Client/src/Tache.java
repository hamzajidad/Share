


import java.util.Date;
import java.io.Serializable;

public class Tache implements Serializable {

	private String time;
	private String date;
	private String lieu;
	private String sujet;
	private int idTache;
	private int idInvitation;
	private String idProfil;
	private String[] listeInvites;
	
	public Tache(){}


	public Tache(String time, String date, String lieu, String sujet, String idProfil,
		String[] listeInvites) {
		super();
		this.time = time;
		this.date = date;
		this.lieu = lieu;
		this.sujet = sujet;
		this.idProfil = idProfil;
		this.listeInvites = listeInvites;
	}
	
	public void Taches(){
		
		
		
		
		
		
		
	}


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

	public String getIdProfil() {
		return idProfil;
	}

	public String[] getListeInvites() {
		return listeInvites;
	}

	public int getIdInvitation() {
		return idInvitation;
	}


	public String getTime() {
		return time;
	}
	

}
