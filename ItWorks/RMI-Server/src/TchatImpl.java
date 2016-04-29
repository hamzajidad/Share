

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TchatImpl extends UnicastRemoteObject implements TchatInterface{

	private static final long serialVersionUID = 1L;

	String url ="jdbc:mysql://localhost/bdserver?useSSL=false";
	String login ="root";
	String pass = "";
	
	protected TchatImpl() throws RemoteException {
		super();
	}

	public void envoyerMessage(String contenu, String idExpediteur, String idReceveur) throws RemoteException {
		Connection cn = null;
		Statement st = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");					// chargement des drivers
			
			cn = DriverManager.getConnection(url,login,pass);		// connection à la BD
			st = cn.createStatement();								// création d'un statement
			String sql = "INSERT INTO `message` ( `texte`, `login_envoyeur`, `login_recepteur`) VALUES ( '"+contenu+"', '"+idExpediteur+"', '"+idReceveur+"')";
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

	public List<String> recevoirMessage(String idExpediteur, String idReceveur) throws RemoteException {
		Connection cn = null;
		Statement st = null;
		ResultSet res = null;
		ArrayList <String> list = new ArrayList<String>();
		ArrayList <Integer> listID = new ArrayList<Integer>();
		try{
			Class.forName("com.mysql.jdbc.Driver");					// chargement des drivers
			cn = DriverManager.getConnection(url,login,pass);		// connection à la BD
			st = cn.createStatement();								// création d'un statement
			String sql = "select * from message where login_envoyeur = '"+ idExpediteur+"' and login_recepteur ='"+idReceveur+"'";
			res = st.executeQuery(sql);									// execution de la BD
			while (res.next()){
				list.add(res.getString("texte"));
				listID.add(res.getInt("idMessage"));
				//suprimerMessage(res.getInt("idMessage"));
			}
			for(int i = 0; i<listID.size(); i++){
				suprimerMessage(listID.get(i));
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

	public List<String> detecterConversation(String idReceveur) throws RemoteException {
		Connection cn = null;
		Statement st = null;
		ResultSet res = null;
		ArrayList <String> list = new ArrayList<String>();
		try{
			Class.forName("com.mysql.jdbc.Driver");					// chargement des drivers
			cn = DriverManager.getConnection(url,login,pass);		// connection à la BD
			st = cn.createStatement();								// création d'un statement
			String sql = "select * from message where login_recepteur = '"+ idReceveur+"'";
			res = st.executeQuery(sql);									// execution de la BD
			while (res.next()){
				list.add(res.getString("login_envoyeur"));
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

	public void suprimerMessage(int id) throws RemoteException {
		Connection cn = null;
		Statement st = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");					// chargement des drivers
			cn = DriverManager.getConnection(url,login,pass);		// connection à la BD
			st = cn.createStatement();
			String sql2 = "DELETE FROM `message` WHERE `message`.`idMessage` ='"+id+"'";
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
}
