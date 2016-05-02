

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ActualiteImpl extends UnicastRemoteObject implements ActualiteInterface{

	private static final long serialVersionUID = 1L;

	private String url ="jdbc:mysql://localhost/bdserver?useSSL=false";
	private String login ="root";
	private String pass = "";
	
	protected ActualiteImpl() throws RemoteException {
		super();
	}

	public void posterActualite(String contenu, String titre, String idProfil, String date, int affichable) throws RemoteException {
		Connection cn = null;
		Statement st = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");					// chargement des drivers
			cn = DriverManager.getConnection(url,login,pass);		// connection à la BD
			st = cn.createStatement();								// création d'un statement
			String sql = "INSERT INTO `actualite` ( `texte`, `date`, `login`, `affichable`,`titre`) VALUES ( '"+contenu+"', '"+date+"', '"+idProfil+"', '"+affichable+"', '"+titre+"')";
			st.executeUpdate(sql);									// execution de la BD
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

	@Override
	public String[] recupererActualite(int idAnnonce) throws RemoteException {
		Connection cn = null;
		Statement st = null;
		ResultSet res = null;
		String[] tab = new String[4];
		try{
			Class.forName("com.mysql.jdbc.Driver");					// chargement des drivers
			cn = DriverManager.getConnection(url,login,pass);		// connection à la BD
			st = cn.createStatement();								// création d'un statement
			String sql = "select * from Actualite where idAnnonce = '"+idAnnonce+"'";
			res = st.executeQuery(sql);									// execution de la BD
			while (res.next()){
				tab[0] = res.getString("texte");
				tab[1] = res.getString("login");
				tab[2] = res.getString("date");
				tab[3] = res.getString("titre");
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

	@Override
	public List<Integer> recupererFilActu() throws RemoteException {
			Connection cn = null;
			Statement st = null;
			ResultSet res = null;
			ArrayList <Integer> list = new ArrayList<Integer>();
			try{
				Class.forName("com.mysql.jdbc.Driver");					// chargement des drivers
				cn = DriverManager.getConnection(url,login,pass);		// connection à la BD
				st = cn.createStatement();								// création d'un statement
				String sql = "select * from Actualite where affichable = '1'";
				res = st.executeQuery(sql);									// execution de la BD
				while (res.next()){
					list.add(res.getInt("idAnnonce"));
					if(list.size() > 10)
					{
						this.supprimerActualite(list.get(0));
						list.remove(list.size()-1);
					}
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
			return list;
	}

	public void supprimerActualite(int idAnnonce) throws RemoteException{
		Connection cn = null;
		Statement st = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");					// chargement des drivers
			cn = DriverManager.getConnection(url,login,pass);		// connection à la BD
			st = cn.createStatement();
			String sql2 = "DELETE FROM `actualite` WHERE `actualite`.`idAnnonce` ='"+idAnnonce+"'";
			st.executeUpdate(sql2);
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

	public List<Integer> recupererActuNonValide(boolean mod) throws RemoteException {
		if (mod){
			Connection cn = null;
			Statement st = null;
			ResultSet res = null;
			ArrayList <Integer> list = new ArrayList<Integer>();
			try{
				System.out.println(Class.forName("com.mysql.jdbc.Driver"));
				Class.forName("com.mysql.jdbc.Driver");					// chargement des drivers
			
				cn = DriverManager.getConnection(url,login,pass);		// connection à la BD
				st = cn.createStatement();								// création d'un statement
				String sql = "select * from Actualite where affichable = '0'";
				res = st.executeQuery(sql);									// execution de la BD
			
				while (res.next()){
					list.add(res.getInt("idAnnonce"));
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
			return list;
		}
		return null;
	}

	@Override
	public void modifierAffichable(int idAnnonce, boolean choix, boolean mod) throws RemoteException {
		if (mod)
		{
			Connection cn = null;
			Statement st = null;
			try{
				Class.forName("com.mysql.jdbc.Driver");					// chargement des drivers
				cn = DriverManager.getConnection(url,login,pass);		// connection à la BD
				st = cn.createStatement();								// création d'un statement
				if (choix){
					String sql = "UPDATE `actualite` SET `affichable` = '1' WHERE `actualite`.`idAnnonce` = "+idAnnonce+"";
					st.executeUpdate(sql);									// execution de la BD
				}else{
					String sql2 = "DELETE FROM `actualite` WHERE `actualite`.`idAnnonce` ='"+idAnnonce+"'";
					st.executeUpdate(sql2);
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
	}
}
