

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class AnnonceImpl extends UnicastRemoteObject implements AnnonceInterface{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected AnnonceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void posterAnnonce(String annonce) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String recupererAnnonce(int idAnnonce) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void afficherAnnonce(String annonce, int idAnnonce) throws RemoteException {
		// TODO Auto-generated method stub
		
	}
	
	

}
