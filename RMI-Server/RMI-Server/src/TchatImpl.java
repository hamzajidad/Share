

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class TchatImpl extends UnicastRemoteObject implements FichierInterface{

	protected TchatImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String recupererFichier(int id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void envoyerFichier(int id) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void validationPartage(boolean valide) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

}
