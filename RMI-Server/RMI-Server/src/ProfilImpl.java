import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ProfilImpl extends UnicastRemoteObject implements ProfilInterface{

	protected ProfilImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void creerProfil(String log, String nom, String prenom, String fonction, String email, String mdp, String statut, String statutCreateur)throws RemoteException
	{
		
		String url ="jdbc:mysql://localhost/bdserver";
		String login ="root";
		String pass = "";
		Connection cn = null;
		Statement st = null;
		
		try{
			
			Class.forName("com.mysql.jdbc.Driver");					// chargement des drivers
			
			cn = DriverManager.getConnection(url,login,pass);		// connection à la BD
			st = cn.createStatement();								// création d'un statement
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
				// libération de la mémoire
				cn.close();
				st.close();
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
		
		
	}
	
	public void afficherProfils() throws RemoteException 
	{
		
		String url ="jdbc:mysql://localhost/bdserver";
		String login ="root";
		String pass = "";
		Connection cn = null;
		Statement st = null;
		ResultSet res = null;
		
		try{
			
			Class.forName("com.mysql.jdbc.Driver");					// chargement des drivers
			
			cn = DriverManager.getConnection(url,login,pass);		// connection à la BD
			st = cn.createStatement();								// création d'un statement
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
				// libération de la mémoire
				cn.close();
				st.close();
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
		
		
	}
	
	public String[] recupererProfil(String log) throws RemoteException 
	{
		
		String url ="jdbc:mysql://localhost/bdserver";
		String login ="root";
		String pass = "";
		Connection cn = null;
		Statement st = null;
		ResultSet res = null;
		String[] tab = new String[7];
		try{
			
			Class.forName("com.mysql.jdbc.Driver");					// chargement des drivers
			
			cn = DriverManager.getConnection(url,login,pass);		// connection à la BD
			st = cn.createStatement();								// création d'un statement
			String sql = "select * from Profil where login = '"+log+"'";
			res = st.executeQuery(sql);									// execution de la BD
			
			while (res.next()){
				//System.out.println(res.getString("nom")+" "+res.getString("prenom")+" "+res.getString("email")+" "+res.getString("poste"));
				tab[0] = log;
				tab[1] = res.getString("nom");
				tab[2] = res.getString("prenom");
				tab[3] = res.getString("email");
				tab[4] = res.getString("poste");
				tab[5] = res.getString("statut");
				tab[6] = res.getString("moderateur");
				//System.out.println(tab[0]+" "+tab[1]+" "+tab[2]+" "+tab[3]+" "+tab[4]+" "+tab[5]+" "+tab[6]);
			}
			
			
			
		}catch (SQLException e){
			e.printStackTrace();
		}catch (ClassNotFoundException e){
			e.printStackTrace();
		}finally {
			try {
				// libération de la mémoire
				cn.close();
				st.close();
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
		
		return tab;
	}
	
	public String recupererMdp(String log, String statut)throws RemoteException
	{
		String url ="jdbc:mysql://localhost/bdserver";
		String login ="root";
		String pass = "";
		Connection cn = null;
		Statement st = null;
		ResultSet res = null;
		String mdp = null;
		try{
			
			Class.forName("com.mysql.jdbc.Driver");					// chargement des drivers
			
			cn = DriverManager.getConnection(url,login,pass);		// connection à la BD
			st = cn.createStatement();								// création d'un statement
			String sql = "select * from Profil where login = '"+log+"'";
			res = st.executeQuery(sql);									// execution de la BD
			
			while (res.next()){
				//System.out.println(res.getString("nom")+" "+res.getString("prenom")+" "+res.getString("email")+" "+res.getString("poste"));
				mdp = res.getString("mdp");
				//System.out.println(tab[0]+" "+tab[1]+" "+tab[2]+" "+tab[3]+" "+tab[4]+" "+tab[5]+" "+tab[6]);
			}
			
			
			
		}catch (SQLException e){
			e.printStackTrace();
		}catch (ClassNotFoundException e){
			e.printStackTrace();
		}finally {
			try {
				// libération de la mémoire
				cn.close();
				st.close();
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
		if (statut != "membre")
			return mdp;
		else
			return "";
	}
	
	public String recupererStatut(String log, String statut)throws RemoteException
	{
		String url ="jdbc:mysql://localhost/bdserver";
		String login ="root";
		String pass = "";
		Connection cn = null;
		Statement st = null;
		ResultSet res = null;
		String stat = null;
		try{
			
			Class.forName("com.mysql.jdbc.Driver");					// chargement des drivers
			
			cn = DriverManager.getConnection(url,login,pass);		// connection à la BD
			st = cn.createStatement();								// création d'un statement
			String sql = "select * from Profil where login = '"+log+"'";
			res = st.executeQuery(sql);									// execution de la BD
			
			while (res.next()){
				//System.out.println(res.getString("nom")+" "+res.getString("prenom")+" "+res.getString("email")+" "+res.getString("poste"));
				stat = res.getString("statut");
				//System.out.println(tab[0]+" "+tab[1]+" "+tab[2]+" "+tab[3]+" "+tab[4]+" "+tab[5]+" "+tab[6]);
			}
			
			
			
		}catch (SQLException e){
			e.printStackTrace();
		}catch (ClassNotFoundException e){
			e.printStackTrace();
		}finally {
			try {
				// libération de la mémoire
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
	
	public int recupererModerateur(String log, String statut)throws RemoteException
	{
		String url ="jdbc:mysql://localhost/bdserver";
		String login ="root";
		String pass = "";
		Connection cn = null;
		Statement st = null;
		ResultSet res = null;
		int mod =-1;
		try{
			
			Class.forName("com.mysql.jdbc.Driver");					// chargement des drivers
			
			cn = DriverManager.getConnection(url,login,pass);		// connection à la BD
			st = cn.createStatement();								// création d'un statement
			String sql = "select * from Profil where login = '"+log+"'";
			res = st.executeQuery(sql);									// execution de la BD
			
			while (res.next()){
				//System.out.println(res.getString("nom")+" "+res.getString("prenom")+" "+res.getString("email")+" "+res.getString("poste"));
				mod = res.getInt("moderateur");
				//System.out.println(tab[0]+" "+tab[1]+" "+tab[2]+" "+tab[3]+" "+tab[4]+" "+tab[5]+" "+tab[6]);
			}
			
			
			
		}catch (SQLException e){
			e.printStackTrace();
		}catch (ClassNotFoundException e){
			e.printStackTrace();
		}finally {
			try {
				// libération de la mémoire
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
	
	public void modifierNom (String log, String nom, String statut)throws RemoteException
	{
		String url ="jdbc:mysql://localhost/bdserver";
		String login ="root";
		String pass = "";
		Connection cn = null;
		Statement st = null;
		
		try{
			
		Class.forName("com.mysql.jdbc.Driver");					// chargement des drivers
			
		cn = DriverManager.getConnection(url,login,pass);		// connection à la BD
		st = cn.createStatement();								// création d'un statement
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
				// libération de la mémoire
				cn.close();
				st.close();
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
		
	}
	
	public void modifierPrenom (String log, String prenom, String statut)throws RemoteException
	{
		String url ="jdbc:mysql://localhost/bdserver";
		String login ="root";
		String pass = "";
		Connection cn = null;
		Statement st = null;
		
		try{
			
			Class.forName("com.mysql.jdbc.Driver");					// chargement des drivers
			
			cn = DriverManager.getConnection(url,login,pass);		// connection à la BD
			st = cn.createStatement();								// création d'un statement
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
				// libération de la mémoire
				cn.close();
				st.close();
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
		
	}

	public void modifierFonction (String log, String poste, String statut)throws RemoteException
	{
		String url ="jdbc:mysql://localhost/bdserver";
		String login ="root";
		String pass = "";
		Connection cn = null;
		Statement st = null;
		
		try{
			
			Class.forName("com.mysql.jdbc.Driver");					// chargement des drivers
			
			cn = DriverManager.getConnection(url,login,pass);		// connection à la BD
			st = cn.createStatement();								// création d'un statement
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
				// libération de la mémoire
				cn.close();
				st.close();
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
		
	}

	public void modifierEmail (String log, String email, String statut)throws RemoteException
	{
		String url ="jdbc:mysql://localhost/bdserver";
		String login ="root";
		String pass = "";
		Connection cn = null;
		Statement st = null;
		
		try{
			
			Class.forName("com.mysql.jdbc.Driver");					// chargement des drivers
			
			cn = DriverManager.getConnection(url,login,pass);		// connection à la BD
			st = cn.createStatement();								// création d'un statement
			if(statut != "membre" && (!this.recupererStatut(log, statut).equals("superAdmin") || (this.recupererStatut(log, statut).equals("superAdmin") && statut == "superAdmin")))
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
				// libération de la mémoire
				cn.close();
				st.close();
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
		
	}
	
	public void modifierMdp (String log, String mdp, String statut)throws RemoteException
	{
		String url ="jdbc:mysql://localhost/bdserver";
		String login ="root";
		String pass = "";
		Connection cn = null;
		Statement st = null;
		
		try{
			
			Class.forName("com.mysql.jdbc.Driver");					// chargement des drivers
			
			cn = DriverManager.getConnection(url,login,pass);		// connection à la BD
			st = cn.createStatement();								// création d'un statement
			if(statut != "membre" && (!this.recupererStatut(log, statut).equals("superAdmin") || (this.recupererStatut(log, statut).equals("superAdmin") && statut == "superAdmin")))
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
				// libération de la mémoire
				cn.close();
				st.close();
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
		
	}
	
	public void modifierStatut (String log, String stat, String statut)throws RemoteException
	{
		String url ="jdbc:mysql://localhost/bdserver";
		String login ="root";
		String pass = "";
		Connection cn = null;
		Statement st = null;
		
		try{
			
			Class.forName("com.mysql.jdbc.Driver");					// chargement des drivers
			
			cn = DriverManager.getConnection(url,login,pass);		// connection à la BD
			st = cn.createStatement();								// création d'un statement
			if(statut != "membre" && (stat == "membre" || stat == "admin"))
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
				// libération de la mémoire
				cn.close();
				st.close();
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
		
	}
	
	public void modifierModerateur (String log, String statut)throws RemoteException
	{
		String url ="jdbc:mysql://localhost/bdserver";
		String login ="root";
		String pass = "";
		Connection cn = null;
		Statement st = null;
		int mod = -1;
		
		if(this.recupererModerateur(log, statut) == 0)
			mod = 1;
		else
			mod = 0;
		
		try{
			
			Class.forName("com.mysql.jdbc.Driver");					// chargement des drivers
			
			cn = DriverManager.getConnection(url,login,pass);		// connection à la BD
			st = cn.createStatement();								// création d'un statement
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
				// libération de la mémoire
				cn.close();
				st.close();
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
		
	}
	
	public boolean connexion (String log, String mdp)throws RemoteException
	{
		System.out.println("le log est "+log+" et le mdp mis est : "+mdp+" et le bon mdp est "+this.recupererMdp(log, "superAdmin"));
		if (this.recupererMdp(log, "superAdmin").equals(mdp))
			return true;
		else
			return false;
	}
	
	public void supprimerProfil(String log, String statut) throws RemoteException 
	{
		String url ="jdbc:mysql://localhost/bdserver";
		String login ="root";
		String pass = "";
		Connection cn = null;
		Statement st = null;
		ResultSet res = null;
		try{
			
			Class.forName("com.mysql.jdbc.Driver");					// chargement des drivers
			
			cn = DriverManager.getConnection(url,login,pass);		// connection à la BD
			st = cn.createStatement();								// création d'un statement
			/*String sql = "select * from Profil where nom = '"+nom+"' and prenom = '"+prenom+"'";
			res = st.executeQuery(sql);									// execution de la BD

			ArrayList<Integer> idProfils = new ArrayList<Integer>();
			while(res.next())
			{
				idProfils.add(res.getInt("idProfil"));
			}
			
			for(Integer elem: idProfils)
			{
				String sql2 = "DELETE FROM `profil` WHERE `profil`.`idProfil` ="+elem+"";
				st.executeUpdate(sql2);
			}*/
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
				// libération de la mémoire
				cn.close();
				st.close();
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
	}
	
}
