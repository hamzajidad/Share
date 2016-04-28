

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class SujetImpl extends UnicastRemoteObject implements SujetInterface{

	protected SujetImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void supprimerCommentaire(int idSujet, String commentaire) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

}
