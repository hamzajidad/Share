

import java.net.MalformedURLException;


import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.Scanner;

import javax.swing.SwingUtilities;

@SuppressWarnings("deprecation")
public class Client {
	
	private static String url;

	public static void main(String[] args) throws RemoteException, MalformedURLException, NotBoundException{
		
		ConnexionServeur(args);
		LoginIHM login = new LoginIHM();
		login.main(args);
		
		
	}
	
	
	
	public static void ConnexionServeur(String[] args) throws RemoteException, MalformedURLException, NotBoundException{
		
		System.out.println("Lancement Client");
		int port = Integer.parseInt(args[0]);
		System.out.println("Lancement Client au port : " + port);
		setUrl(args[1]);
		System.out.println("Lancement du Client au l'url : " + getUrl());


		
		if(System.getSecurityManager() == null){
			System.out.println("Mise en place Security Manager");
			System.setSecurityManager(new RMISecurityManager());
		}
		try{
			System.out.println("Utilisation lookup");
			Remote r = Naming.lookup("rmi://"+getUrl()+"/Hello");
			System.out.println("Utilisation fonction");
			System.out.println(((HelloInterface) r).hello());
			System.out.println(((HelloInterface) r).Calcul(1,2));
			Remote rp = Naming.lookup("rmi://"+getUrl()+"/Profil");
			System.out.println("Connexion superAdmin mdp plop = " + ((ProfilInterface)rp).connexion("superAdmin", "plop"));
			System.out.println("Connexion superAdmin mdp 0000 = " + ((ProfilInterface)rp).connexion("superAdmin", "0000"));

		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	/*	System.out.println("********** Bienvenue dans SHARE **********");
		System.out.println("Veuillez choisir votre options :");
		System.out.println("1 ) Tchat");
		System.out.println("2 ) ACtualité");
		System.out.println("3 ) Creer un profil");

		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int choix = scanner.nextInt();
		
		
		if(choix==1){
			
		}
		if(choix==2){
			Actualité();
			
		}
		if(choix==3){
			Profil();
		}
		System.out.println("Fermeture Client");
	*/	
	}
	
	public void tchat(){
		
		
	}
	
	public static void Actualité() throws RemoteException, MalformedURLException, NotBoundException{
		
		System.out.println("Veuillez choisir :");
		System.out.println("1) Creer une anonce & l'envoyer");
		System.out.println("2) Consulter une annonce");
		Scanner scanner = new Scanner(System.in);
		int choix = scanner.nextInt();
		
		if(choix==1){
			
			System.out.println("Donnez votre contenu :");
			System.out.println("Donnez votre identifiant :");
			System.out.println("Donnez la date de publication :");
			String date = scanner.nextLine();
			String contenu = scanner.nextLine();
			String idProfil = scanner.nextLine();
			//Actualite actu = new Actualite(contenu, idProfil, date);
			//actu.sendActualite();
			
		}
		if(choix==2){
			
			Remote r = Naming.lookup("rmi://"+Client.getUrl()+"/Hello");
			System.out.println("Donnez votre contenu :");
			int idAnnonce = scanner.nextInt();
			Actualite a = new Actualite(((ActualiteInterface)r).recupererActualite(idAnnonce));
			a.AfficherUneActualite();
			
		}
		
	}
	

		//Remote r = Naming.lookup("rmi://"+url+"/Profil");
		//(ProfilInterface)r.creerProfil(nom,prenom,mdp,email,fonction,statut);
		



	public static String getUrl() {
		return url;
	}

	public static void setUrl(String url) {
		Client.url = url;
	}
	
	public static void Profil(){
		
		System.out.println("Veuillez entrez le nom :");
		Scanner scanner = new Scanner(System.in);
		String nom = scanner.nextLine();

		System.out.println("Veuillez entrez le prenom :");
		String prenom = scanner.nextLine();

		System.out.println("Veuillez entrez le mdp :");
		String mdp = scanner.nextLine();
		

		System.out.println("Veuillez entrez l'email :");
		String email = scanner.nextLine();
		

		System.out.println("Veuillez entrez la fonction :");
		String fonction = scanner.nextLine();
		

		System.out.println("Veuillez entrez le satut :");
		String statut = scanner.nextLine();
	}


}	
