


import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public class Tache implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String contenu;
	private String date;
	private String lieu;
	private String sujet;
	private int idTache;
	private String idProfil;
	
	public Tache(int idTache)throws MalformedURLException, RemoteException, NotBoundException{
		Remote r = Naming.lookup("rmi://"+Client.getUrl()+"/Tache");
		String[] infoProfil = ((TacheInterface) r).recupererTache(idTache);
		this.idTache= Integer.parseInt(infoProfil[0]);
		this.sujet= infoProfil[1];
		this.date=infoProfil[2];
		this.lieu=infoProfil[3];
		this.idProfil= infoProfil[4];
		this.contenu= infoProfil[5];
	}


	public Tache(String date, String lieu, String sujet, String idProfil,String contenu) {
		super();
		this.date=Dates.date()+" "+Dates.heure();
		this.lieu = lieu;
		this.sujet = sujet;
		this.idProfil = idProfil;
		this.contenu = contenu;
		idTache = 0;
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
	public String getContenu() {
		return contenu;
	}
	
	public void envoyerTache() throws RemoteException, MalformedURLException, NotBoundException{
		Remote r = Naming.lookup("rmi://"+Client.getUrl()+"/Tache");
		((TacheInterface) r).creerTache(date,lieu,sujet,idProfil,contenu);
		
	}
	public void supprimerTache() throws RemoteException, MalformedURLException, NotBoundException{
		Remote r = Naming.lookup("rmi://"+Client.getUrl()+"/Tache");
		((TacheInterface) r).supprimerTache(idTache);
		
	}
	public void ajouterInvitation(String loginInvite) throws RemoteException, MalformedURLException, NotBoundException{
		Remote r = Naming.lookup("rmi://"+Client.getUrl()+"/Tache");
		((TacheInterface) r).ajouterInvitation(idTache, loginInvite);
	}
	public void supprimerInvitation(String loginInvite) throws RemoteException, MalformedURLException, NotBoundException{
		Remote r = Naming.lookup("rmi://"+Client.getUrl()+"/Tache");
		((TacheInterface) r).supprimerInvitation(idTache, loginInvite);
	}
	public void annulerInvitation(String loginInvite) throws RemoteException, MalformedURLException, NotBoundException{
		Remote r = Naming.lookup("rmi://"+Client.getUrl()+"/Tache");
		((TacheInterface) r).annulerInvitation(idTache, loginInvite);
	}
	public void validationInvitation(String loginInvite) throws RemoteException, MalformedURLException, NotBoundException{
		Remote r = Naming.lookup("rmi://"+Client.getUrl()+"/Tache");
		((TacheInterface) r).validationInvitation(idTache, loginInvite);
	}
	public int recupererReponse(String loginInvite) throws MalformedURLException, RemoteException, NotBoundException{
		Remote r = Naming.lookup("rmi://"+Client.getUrl()+"/Tache");
		return ((TacheInterface) r).recupererReponse(idTache, loginInvite);
	
	}
}
