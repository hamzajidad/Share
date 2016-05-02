
import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public class Actualite implements Serializable,Controllable{
	private String date;
	private String contenu;
	private String idProfil;
	private int idActualite;
	private int affichable;
	private String titre;

	private static final long serialVersionUID = 1L;

	/*
	 * Constructeur d'une actualite avec des parametres rentres a la main
	 * 
	 * */
	public Actualite(String contenu, String idProfil, String titre) {
		this.contenu = contenu;
		this.idProfil = idProfil;
		this.date=Dates.date()+" "+Dates.heure();
		idActualite =0;
		this.titre=titre;
		
	}
	
	
	/*
	 * Constructeur d'une actualite depuis la base de donne via son id
	 * 
	 * */
	public Actualite(int idActualite) throws MalformedURLException, RemoteException, NotBoundException{
		Remote r = Naming.lookup("rmi://"+Client.getUrl()+"/Actualite");
		String[] actu = ((ActualiteInterface) r).recupererActualite(idActualite);
		this.idActualite=idActualite;
		contenu=actu[0];
		idProfil=actu[1];
		date=actu[2];
		titre=actu[3];
		
	}

	
	
	public String getContenu() {
		return contenu;
	}



	public String getIdProfil() {
		return idProfil;
	}
	
	public String getdate(){
		return date;
	}
	
	/*
	 * envoie l'actualite a la base de donne, 
	 * si l'interface controllable n'est pas implemente, celle ci sera affichable par defaut
	 * */
	public void sendActualite() throws RemoteException, MalformedURLException, NotBoundException{
		if(this instanceof Controllable){affichable=0;}else{affichable=1;}
		Remote r = Naming.lookup("rmi://"+Client.getUrl()+"/Actualite");
		((ActualiteInterface) r).posterActualite(contenu, titre, idProfil, date, affichable);
		
	}
	
	public void modifierAffichable(int id, boolean choix, boolean mod) throws RemoteException, MalformedURLException, NotBoundException{
		Remote r = Naming.lookup("rmi://"+Client.getUrl()+"/Actualite");
		((ActualiteInterface) r).modifierAffichable(id,choix,mod);
		
	}
	
	public int getId(){
		
		return idActualite;
		
	}
	
	public String getTitre(){
		return titre;
	}

	
	public void supprimerActualite() throws RemoteException, MalformedURLException, NotBoundException{
		Remote r = Naming.lookup("rmi://"+Client.getUrl()+"/Actualite");
		((ActualiteInterface) r).supprimerActualite(idActualite);
		
	}
	
	
	

}
