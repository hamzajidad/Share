
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class TacheImpl extends UnicastRemoteObject implements TacheInterface{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String url ="jdbc:mysql://localhost/bdserver?useSSL=false";
	private String login ="root";
	private String pass = "";
	
	protected TacheImpl() throws RemoteException {
		super();
	}

	public void creerTache(String date, String lieu, String sujet, String organisateur,String contenue)
			throws RemoteException {
		Connection cn = null;
		Statement st = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");					// chargement des drivers
			
			cn = DriverManager.getConnection(url,login,pass);		// connection � la BD
			st = cn.createStatement();								// cr�ation d'un statement
			
			String sql = "INSERT INTO `tache` (`sujet`, `date`, `lieu`, `login_organisateur`, `contenue`) VALUES ('"+sujet+"', '"+date+"', '"+lieu+"', '"+organisateur+"', '"+contenue+"')";
			st.executeUpdate(sql);// execution de la BD
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

	@Override
	public void supprimerTache(int idTache) throws RemoteException {
		// TODO Auto-generated method stub
		
		Connection cn = null;
		Statement st = null;
		ResultSet res = null;
		ArrayList<String> list = new ArrayList<String>();
		try{
			Class.forName("com.mysql.jdbc.Driver");					// chargement des drivers
			
			cn = DriverManager.getConnection(url,login,pass);		// connection � la BD
			st = cn.createStatement();								// cr�ation d'un statement
			
			
			String sql = "SELECT * FROM Invitation WHERE `Invitation`.`idTache` = "+idTache+"";
			res = st.executeQuery(sql);
			while (res.next()){
				
				list.add(res.getString("login"));
				
			}
			
			for(String elem : list){
				
				this.supprimerInvitation(idTache, elem);
				
			}
			
			String sql2 ="DELETE FROM `tache` WHERE `tache`.`idTache` = "+idTache+"";
			st.executeUpdate(sql2);
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

	@Override
	public void ajouterInvitation(int idTache, String idProfil) throws RemoteException {
		// TODO Auto-generated method stub
		
		Connection cn = null;
		Statement st = null;
		ArrayList<String> list = this.dejaInvite(idTache, idProfil);
		boolean choix = false;
		try{
			Class.forName("com.mysql.jdbc.Driver");					// chargement des drivers
			
			cn = DriverManager.getConnection(url,login,pass);		// connection � la BD
			st = cn.createStatement();								// cr�ation d'un statement
			
			for (String elem : list){
				
				if(elem.equals(idProfil))
					choix = true;
				else
					choix = false;
				
			}
			if(!choix){	
				String sql2 = "INSERT INTO `invitation` (`login`, `idTache`,`choix`) VALUES ('"+idProfil+"', '"+idTache+"', '0')";
				st.executeUpdate(sql2);// execution de la BD
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

	private ArrayList<String> dejaInvite(int idTache, String idProfil)throws RemoteException {
		// TODO Auto-generated method stub
		Connection cn = null;
		Statement st = null;
		ArrayList<String> list = new ArrayList<String>();
		try{
			Class.forName("com.mysql.jdbc.Driver");					// chargement des drivers
			
			cn = DriverManager.getConnection(url,login,pass);		// connection � la BD
			st = cn.createStatement();								// cr�ation d'un statement
			ResultSet res = null;
			String sql = "SELECT * FROM Invitation WHERE `Invitation`.`idTache` = "+idTache+"";
			res = st.executeQuery(sql);
		
			while (res.next()){
				
				list.add(res.getString("login"));
				
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
		return list;
	}

	@Override
	public void validationInvitation(int idTache,String idProfil) throws RemoteException {
		// TODO Auto-generated method stub

		Connection cn = null;
		Statement st = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");					// chargement des drivers
			
			cn = DriverManager.getConnection(url,login,pass);		// connection � la BD
			st = cn.createStatement();								// cr�ation d'un statement
			
			String sql = "UPDATE `invitation` SET `choix` = '1' WHERE `invitation`.`login` = '"+idProfil+"' AND `invitation`.`idTache` = "+idTache+"";
			st.executeUpdate(sql);// execution de la BD
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
	
	

	@Override
	public void supprimerInvitation(int idTache, String idProfil) throws RemoteException {
		// TODO Auto-generated method stub
		
		Connection cn = null;
		Statement st = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");					// chargement des drivers
			
			cn = DriverManager.getConnection(url,login,pass);		// connection � la BD
			st = cn.createStatement();								// cr�ation d'un statement
			
			String sql = "DELETE FROM `invitation` WHERE `invitation`.`login` = '"+idProfil+"' AND `invitation`.`idTache` = "+idTache+"";
			st.executeUpdate(sql);// execution de la BD
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

	@Override
	public void annulerInvitation(int idTache, String idProfil) throws RemoteException {
		// TODO Auto-generated method stub
		Connection cn = null;
		Statement st = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");					// chargement des drivers
			
			cn = DriverManager.getConnection(url,login,pass);		// connection � la BD
			st = cn.createStatement();								// cr�ation d'un statement
			
			String sql = "UPDATE `invitation` SET `choix` = '-1' WHERE `invitation`.`login` = '"+idProfil+"' AND `invitation`.`idTache` = "+idTache+"";
			st.executeUpdate(sql);// execution de la BD
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

	@Override
	public String[] recupererTache(int idTache) throws RemoteException {
		// TODO Auto-generated method stub
		
		
		Connection cn = null;
		Statement st = null;
		ResultSet res = null;
		String[] tab = new String[6];
		try{
			Class.forName("com.mysql.jdbc.Driver");					// chargement des drivers
			cn = DriverManager.getConnection(url,login,pass);		// connection � la BD
			st = cn.createStatement();								// cr�ation d'un statement
			String sql = "select * from Tache where idTache = '"+idTache+"'";
			res = st.executeQuery(sql);									// execution de la BD
			while (res.next()){
				tab[0] = ""+idTache;
				tab[1] = res.getString("sujet");
				tab[2] = res.getString("date");
				tab[3] = res.getString("lieu");
				tab[4] = res.getString("login_organisateur");
				tab[5] = res.getString("contenue");
				
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
	
	public ArrayList<Integer> recupererInvitation(String idProfil) throws RemoteException {
		// TODO Auto-generated method stub
		
		
		Connection cn = null;
		Statement st = null;
		ResultSet res = null;
		ArrayList<Integer> list = new ArrayList<Integer>();
		try{
			Class.forName("com.mysql.jdbc.Driver");					// chargement des drivers
			cn = DriverManager.getConnection(url,login,pass);		// connection � la BD
			st = cn.createStatement();								// cr�ation d'un statement
			String sql = "select * from Invitation where login = '"+idProfil+"'";
			res = st.executeQuery(sql);									// execution de la BD
			while (res.next()){
				
				list.add(res.getInt("idTache"));
				
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
		return list;
		
	}

	public int recupererReponse(int idTache, int idProfil) throws RemoteException {
		Connection cn = null;
		Statement st = null;
		ResultSet res = null;
		int choix = 0;
		try{
			Class.forName("com.mysql.jdbc.Driver");					// chargement des drivers
			cn = DriverManager.getConnection(url,login,pass);		// connection � la BD
			st = cn.createStatement();								// cr�ation d'un statement
			String sql = "select * from Invitation where login = '"+idProfil+"'AND idTache = '"+idTache+"";
			res = st.executeQuery(sql);									// execution de la BD
			
			while (res.next()){
				choix = res.getInt("choix");
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
		return choix;
	}
}
