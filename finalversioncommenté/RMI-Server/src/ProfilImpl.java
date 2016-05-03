import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ProfilImpl extends UnicastRemoteObject implements ProfilInterface{


	private static final long serialVersionUID = 1L;

	private String url ="jdbc:mysql://localhost/bdserver?useSSL=false";
	private String login ="root";
	private String pass = "";
	
	protected ProfilImpl() throws RemoteException {
		super();
	}

	/*
	 * Methode permettant de stocker les infos d'un profil dans la base de donnée
	 * 
	 * */
	public void creerProfil(String log, String nom, String prenom, String fonction, String email, String mdp, String statut, String statutCreateur)throws RemoteException
	{
		Connection cn = null;
		Statement st = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");					// chargement des drivers
			
			cn = DriverManager.getConnection(url,login,pass);		// connection � la BD
			st = cn.createStatement();								// cr�ation d'un statement
			if (statutCreateur!="membre" || statut != "superAdmin")
			{	
				String sql = "INSERT INTO `profil` (`login`,`nom`, `prenom`, `poste`, `email`, `mdp`, `statut`, `moderateur`) VALUES ('"+log+"','"+nom+"','"+prenom+"','"+fonction+"','"+email+"','"+mdp+"', '"+statut+"', '0')";
				st.executeUpdate(sql);									// execution de la BD
			}
		}catch (SQLException e){
			e.printStackTrace();
		}catch (ClassNotFoundException f){
			f.printStackTrace();
		}finally {
			try {
				// lib�ration de la m�moire
				cn.close();
				st.close();
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
	}
	
	public void afficherProfils() throws RemoteException 
	{
		Connection cn = null;
		Statement st = null;
		ResultSet res = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");					// chargement des drivers
			cn = DriverManager.getConnection(url,login,pass);		// connection � la BD
			st = cn.createStatement();								// cr�ation d'un statement
			String sql = "select * from Profil";
			res = st.executeQuery(sql);									// execution de la BD
			while (res.next()){
				System.out.println(res.getString("nom")+" "+res.getString("prenom")+" "+res.getString("email")+" "+res.getString("poste"));
			}	
		}catch (SQLException e){
			e.printStackTrace();
		}catch (ClassNotFoundException f){
			f.printStackTrace();
		}finally {
			try {
				// lib�ration de la m�moire
				cn.close();
				st.close();
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
	}
	
	/*
	 * Methode permettant de recuperer les infos d'un profil depuis la base de donnée
	 * 
	 * */
	
	public String[] recupererProfil(String log) throws RemoteException 
	{
		
		Connection cn = null;
		Statement st = null;
		ResultSet res = null;
		String[] tab = new String[7];
		try{
			Class.forName("com.mysql.jdbc.Driver");					// chargement des drivers
			cn = DriverManager.getConnection(url,login,pass);		// connection � la BD
			st = cn.createStatement();								// cr�ation d'un statement
			String sql = "select * from Profil where login = '"+log+"'";
			res = st.executeQuery(sql);									// execution de la BD
			while (res.next()){
				tab[0] = log;
				tab[1] = res.getString("nom");
				tab[2] = res.getString("prenom");
				tab[3] = res.getString("email");
				tab[4] = res.getString("poste");
				tab[5] = res.getString("statut");
				tab[6] = res.getString("moderateur");
			}
		}catch (SQLException e){
			e.printStackTrace();
		}catch (ClassNotFoundException e){
			e.printStackTrace();
		}finally {
			try {
				// lib�ration de la m�moire
				cn.close();
				st.close();
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
		return tab;
	}
	
	
	/*
	 * Methode permettant de recuperer le mdp d'un profil depuis la base de donnée
	 * à condition que l'on soit un admin
	 * */
	public String recupererMdp(String log, String statut)throws RemoteException
	{
		Connection cn = null;
		Statement st = null;
		ResultSet res = null;
		String mdp = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");					// chargement des drivers
			cn = DriverManager.getConnection(url,login,pass);		// connection � la BD
			st = cn.createStatement();							// cr�ation d'un statement
			String sql = "select * from Profil where login = '"+log+"'";
			res = st.executeQuery(sql);									// execution de la BD
			while (res.next()){
				mdp = res.getString("mdp");
			}
		}catch (SQLException e){
			e.printStackTrace();
		}catch (ClassNotFoundException e){
			e.printStackTrace();
		}finally {
			try {
				// lib�ration de la m�moire
				cn.close();
				st.close();
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
		if (statut != "membre"){
			return mdp;
		}
		return null;
	}
	
	/*
	 * Methode permettant de recuperer le statut d'un profil depuis la base de donnée
	 * à condition que l'on soit un admin
	 * */
	public String recupererStatut(String log, String statut)throws RemoteException
	{
		Connection cn = null;
		Statement st = null;
		ResultSet res = null;
		String stat = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");					// chargement des drivers
			cn = DriverManager.getConnection(url,login,pass);		// connection � la BD
			st = cn.createStatement();								// cr�ation d'un statement
			String sql = "select * from Profil where login = '"+log+"'";
			res = st.executeQuery(sql);									// execution de la BD
			while (res.next()){
				stat = res.getString("statut");
			}
		}catch (SQLException e){
			e.printStackTrace();
		}catch (ClassNotFoundException e){
			e.printStackTrace();
		}finally {
			try {
				// lib�ration de la m�moire
				cn.close();
				st.close();
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
		if (statut != "membre")
			return stat;
		else
			return "";
	}
	
	/*
	 * Methode permettant de recuperer le statut de moderateur d'un profil depuis la base de donnée
	 * à condition que l'on soit un admin
	 * */
	public int recupererModerateur(String log, String statut)throws RemoteException
	{
		Connection cn = null;
		Statement st = null;
		ResultSet res = null;
		int mod =-1;
		try{
			Class.forName("com.mysql.jdbc.Driver");					// chargement des drivers
			cn = DriverManager.getConnection(url,login,pass);		// connection � la BD
			st = cn.createStatement();								// cr�ation d'un statement
			String sql = "select * from Profil where login = '"+log+"'";
			res = st.executeQuery(sql);									// execution de la BD
			while (res.next()){
				mod = res.getInt("moderateur");
			}
		}catch (SQLException e){
			e.printStackTrace();
		}catch (ClassNotFoundException e){
			e.printStackTrace();
		}finally {
			try {
				// lib�ration de la m�moire
				cn.close();
				st.close();
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
		if (statut != "membre")
			return mod;
		else
			return -1;
	}
	
	/*
	 * Methode permettant de modifier le nom d'un profil dans la base de donnée
	 * à condition que l'on soit un admin, de plus seul le super admin peut modifier son profil
	 * */
	public void modifierNom (String log, String nom, String statut)throws RemoteException
	{
		Connection cn = null;
		Statement st = null;
		try{
		Class.forName("com.mysql.jdbc.Driver");					// chargement des drivers
		cn = DriverManager.getConnection(url,login,pass);		// connection � la BD
		st = cn.createStatement();								// cr�ation d'un statement
		if(statut != "membre" && (!this.recupererStatut(log, statut).equals("superAdmin") || (this.recupererStatut(log, statut).equals("superAdmin") && statut == "superAdmin")))
		{

			String sql = "UPDATE `profil` SET `nom` = '"+nom+"' WHERE `profil`.`login` = '"+log+"'";
			st.executeUpdate(sql);	// execution de la BD
		
		}
		}catch (SQLException e){
			e.printStackTrace();
		}catch (ClassNotFoundException f){
			f.printStackTrace();
		}finally {
			try {
				// lib�ration de la m�moire
				cn.close();
				st.close();
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
	}
	
	/*
	 * Methode permettant de modifier le prenom d'un profil dans la base de donnée
	 * à condition que l'on soit un admin, de plus seul le super admin peut modifier son profil
	 * */
	public void modifierPrenom (String log, String prenom, String statut)throws RemoteException
	{
		Connection cn = null;
		Statement st = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");					// chargement des drivers
			
			cn = DriverManager.getConnection(url,login,pass);		// connection � la BD
			st = cn.createStatement();								// cr�ation d'un statement
			if(statut != "membre" && (!this.recupererStatut(log, statut).equals("superAdmin") || (this.recupererStatut(log, statut).equals("superAdmin") && statut == "superAdmin")))
			{
				String sql = "UPDATE `profil` SET `prenom` = '"+prenom+"' WHERE `profil`.`login` = '"+log+"'";
				st.executeUpdate(sql);									// execution de la BD
			}
		}catch (SQLException e){
			e.printStackTrace();
		}catch (ClassNotFoundException f){
			f.printStackTrace();
		}finally {
			try {
				// lib�ration de la m�moire
				cn.close();
				st.close();
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
	}
	
	/*
	 * Methode permettant de modifier le poste d'un profil dans la base de donnée
	 * à condition que l'on soit un admin, de plus seul le super admin peut modifier son profil
	 * */
	public void modifierFonction (String log, String poste, String statut)throws RemoteException
	{
		Connection cn = null;
		Statement st = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");					// chargement des drivers
			
			cn = DriverManager.getConnection(url,login,pass);		// connection � la BD
			st = cn.createStatement();								// cr�ation d'un statement
			if(statut != "membre" && (!this.recupererStatut(log, statut).equals("superAdmin") || (this.recupererStatut(log, statut).equals("superAdmin") && statut == "superAdmin")))
			{
				String sql = "UPDATE `profil` SET `poste` = '"+poste+"' WHERE `profil`.`login` = '"+log+"'";
				st.executeUpdate(sql);									// execution de la BD
			}
		}catch (SQLException e){
			e.printStackTrace();
		}catch (ClassNotFoundException f){
			f.printStackTrace();
		}finally {
			try {
				// lib�ration de la m�moire
				cn.close();
				st.close();
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
	}

	/*
	 * Methode permettant de modifier l'email d'un profil dans la base de donnée
	 * à condition que l'on soit un admin, de plus seul le super admin peut modifier son profil
	 * */
	public void modifierEmail (String log, String email, String statut)throws RemoteException
	{
		Connection cn = null;
		Statement st = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");					// chargement des drivers
			cn = DriverManager.getConnection(url,login,pass);		// connection � la BD
			st = cn.createStatement();								// cr�ation d'un statement
			if(!statut.equals("membre") && (!this.recupererStatut(log, statut).equals("superAdmin") || (this.recupererStatut(log, statut).equals("superAdmin") && statut == "superAdmin")))
			{
				String sql = "UPDATE `profil` SET `email` = '"+email+"' WHERE `profil`.`login` = '"+log+"'";
				st.executeUpdate(sql);									// execution de la BD
			}
		}catch (SQLException e){
			e.printStackTrace();
		}catch (ClassNotFoundException f){
			f.printStackTrace();
		}finally {
			try {
				// lib�ration de la m�moire
				cn.close();
				st.close();
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
	}
	
	/*
	 * Methode permettant de modifier le mdp d'un profil dans la base de donnée
	 * à condition que l'on soit un admin, de plus seul le super admin peut modifier son profil
	 * */
	public void modifierMdp (String log, String mdp, String statut)throws RemoteException
	{
		Connection cn = null;
		Statement st = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");					// chargement des drivers
			
			cn = DriverManager.getConnection(url,login,pass);		// connection � la BD
			st = cn.createStatement();								// cr�ation d'un statement
			if(!statut.equals("membre") && (!this.recupererStatut(log, statut).equals("superAdmin") || (this.recupererStatut(log, statut).equals("superAdmin") && statut.equals("superAdmin"))))
			{
				String sql = "UPDATE `profil` SET `mdp` = '"+mdp+"' WHERE `profil`.`login` = '"+log+"'";
				st.executeUpdate(sql);									// execution de la BD
			}
		}catch (SQLException e){
			e.printStackTrace();
		}catch (ClassNotFoundException f){
			f.printStackTrace();
		}finally {
			try {
				// lib�ration de la m�moire
				cn.close();
				st.close();
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
	}
	
	/*
	 * Methode permettant de modifier le statut d'un profil dans la base de donnée
	 * à condition que l'on soit un admin, de plus seul le super admin peut modifier son profil
	 * */
	public void modifierStatut (String log, String stat, String statut)throws RemoteException
	{
		Connection cn = null;
		Statement st = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");					// chargement des drivers
			cn = DriverManager.getConnection(url,login,pass);		// connection � la BD
			st = cn.createStatement();								// cr�ation d'un statement
			if(!statut.equals("membre") && (stat.equals("membre") || stat.equals("admin")))
			{
				String sql = "UPDATE `profil` SET `statut` = '"+stat+"' WHERE `profil`.`login` = '"+log+"'";
				st.executeUpdate(sql);									// execution de la BD
			}
		}catch (SQLException e){
			e.printStackTrace();
		}catch (ClassNotFoundException f){
			f.printStackTrace();
		}finally {
			try {
				// lib�ration de la m�moire
				cn.close();
				st.close();
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
	}
	
	/*
	 * Methode permettant de modifier le statut de moderateur d'un profil dans la base de donnée
	 * à condition que l'on soit un admin, de plus seul le super admin peut modifier son profil
	 * */
	public void modifierModerateur (String log, String statut)throws RemoteException
	{
		Connection cn = null;
		Statement st = null;
		int mod = -1;
		if(this.recupererModerateur(log, statut) == 0)
			mod = 1;
		else
			mod = 0;
		try{
			Class.forName("com.mysql.jdbc.Driver");					// chargement des drivers
			
			cn = DriverManager.getConnection(url,login,pass);		// connection � la BD
			st = cn.createStatement();								// cr�ation d'un statement
			if(statut != "membre" && (!this.recupererStatut(log, statut).equals("superAdmin") || (this.recupererStatut(log, statut).equals("superAdmin") && statut == "superAdmin")))
			{
				String sql = "UPDATE `profil` SET `moderateur` = '"+mod+"' WHERE `profil`.`login` = '"+log+"'";
				st.executeUpdate(sql);									// execution de la BD
			}
		}catch (SQLException e){
			e.printStackTrace();
		}catch (ClassNotFoundException f){
			f.printStackTrace();
		}finally {
			try {
				// lib�ration de la m�moire
				cn.close();
				st.close();
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
	}
	
	/*
	 * Methode permettant de verifier si le mdp donne
	 * correspond bien au login donne
	 * */
	public boolean connexion (String log, String mdp)throws RemoteException
	{
		String vraiMdp =(this.recupererMdp(log, "superAdmin"));
		if (vraiMdp != null && vraiMdp.equals(mdp))
			return true;
		else
			return false;
	}
	
	/*
	 * Methode permettant suprimmer un profil de la base de donnees
	 * 
	 * */
	public void supprimerProfil(String log, String statut) throws RemoteException 
	{
		Connection cn = null;
		Statement st = null;
		try{
			
			Class.forName("com.mysql.jdbc.Driver");					// chargement des drivers
			
			cn = DriverManager.getConnection(url,login,pass);		// connection � la BD
			st = cn.createStatement();								// cr�ation d'un statement
			if (statut!="membre")
			{
				String sql2 = "DELETE FROM `profil` WHERE `profil`.`login` ='"+log+"'";
				st.executeUpdate(sql2);
			}
		}catch (SQLException e){
			e.printStackTrace();
		}catch (ClassNotFoundException e){
			e.printStackTrace();
		}finally {
			try {
				// lib�ration de la m�moire
				cn.close();
				st.close();
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
	}
}
