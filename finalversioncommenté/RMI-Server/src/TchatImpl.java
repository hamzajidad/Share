

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

	private String url ="jdbc:mysql://localhost/bdserver?useSSL=false";
	private String login ="root";
	private String pass = "";
	
	protected TchatImpl() throws RemoteException {
		super();
	}

	/*
	 * Methode permettant de stocker les infos d'un message dans la base de donnée
	 * 
	 * */
	public void envoyerMessage(String contenu, String idExpediteur, String idReceveur) throws RemoteException {
		Connection cn = null;
		Statement st = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");					// chargement des drivers
			
			cn = DriverManager.getConnection(url,login,pass);		// connection � la BD
			st = cn.createStatement();								// cr�ation d'un statement
			String sql = "INSERT INTO `message` ( `texte`, `login_envoyeur`, `login_recepteur`) VALUES ( '"+contenu+"', '"+idExpediteur+"', '"+idReceveur+"')";
			st.executeUpdate(sql);									// execution de la BD
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

	/*
	 * Methode permettant de recuperer les infos d'un message depuis la base de donnée
	 * puis de supprimer celui ci
	 * */
	public List<String> recevoirMessage(String idExpediteur, String idReceveur) throws RemoteException {
		Connection cn = null;
		Statement st = null;
		ResultSet res = null;
		ArrayList <String> list = new ArrayList<String>();
		ArrayList <Integer> listID = new ArrayList<Integer>();
		try{
			Class.forName("com.mysql.jdbc.Driver");					// chargement des drivers
			cn = DriverManager.getConnection(url,login,pass);		// connection � la BD
			st = cn.createStatement();								// cr�ation d'un statement
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
				// lib�ration de la m�moire
				cn.close();
				st.close();
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
		return list;
	}

	/*
	 * Methode renvoyant la liste des identifiants ayant envoye
	 * un message au profil donne
	 * */
	public List<String> detecterConversation(String idReceveur) throws RemoteException {
		Connection cn = null;
		Statement st = null;
		ResultSet res = null;
		ArrayList <String> list = new ArrayList<String>();
		try{
			Class.forName("com.mysql.jdbc.Driver");					// chargement des drivers
			cn = DriverManager.getConnection(url,login,pass);		// connection � la BD
			st = cn.createStatement();								// cr�ation d'un statement
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
				// lib�ration de la m�moire
				cn.close();
				st.close();
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
		return list;
	}

	/*
	 * Methode permettant de supprimer les infos d'un message de la base de donnée
	 * 
	 * */
	public void suprimerMessage(int id) throws RemoteException {
		Connection cn = null;
		Statement st = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");					// chargement des drivers
			cn = DriverManager.getConnection(url,login,pass);		// connection � la BD
			st = cn.createStatement();
			String sql2 = "DELETE FROM `message` WHERE `message`.`idMessage` ='"+id+"'";
			st.executeUpdate(sql2);
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
}
