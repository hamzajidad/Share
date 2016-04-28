

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ForumImpl extends UnicastRemoteObject implements ForumInterface{

	protected ForumImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void posterSujet(int idProfil, int idSujet, String sujet) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void repondreSujet(int idProfil, String sujet) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void supprimerSujet(int idSujet) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void validationSujet(int idSujet, boolean valide) throws RemoteException {
		// TODO Auto-generated method stub
		
	}
	

}
