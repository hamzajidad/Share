
import java.util.Date;
import java.util.Locale;
import java.text.DateFormat;


import java.io.Serializable;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public class Actualite implements Serializable{
	private String date;
	private String contenu;
	private String idProfil;
	private int idActualite;
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("deprecation")
	public Actualite(String contenu, String idProfil) {
		this.contenu = contenu;
		this.idProfil = idProfil;
		Date d = new Date();
		this.date=d.getDay()+"/"+d.getMonth()+"/"+d.getYear();
		idActualite =0;
		
	}
	
	
	
	public Actualite(int idActualite) throws MalformedURLException, RemoteException, NotBoundException{
		Remote r = Naming.lookup("rmi://"+Client.getUrl()+"/Actualite");
		String[] actu = ((ActualiteInterface) r).recupererActualite(idActualite);
		this.idActualite=idActualite;
		contenu=actu[0];
		idProfil=actu[1];
		date=actu[2];
		
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
	
	public void sendActualite() throws RemoteException, MalformedURLException, NotBoundException{
		
		Remote r = Naming.lookup("rmi://"+Client.getUrl()+"/Actualite");
		((ActualiteInterface) r).posterActualite(contenu, idProfil, date);
		
	}
	
	public int getId(){
		
		return idActualite;
		
	}
	
	public void AfficherUneActualite(){
		
		System.out.println(getContenu());
		System.out.println(getIdProfil());
		System.out.println(getdate());

		
	}
	
	
	

}
