import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class TachesImpl extends UnicastRemoteObject implements TachesInterface{

	protected TachesImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void creerTache(String date, String lieu, int idProfil, String sujet, int idTache, String organisateur)
			throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void supprimerTache(int idTache) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ajouterInvitation(int idTache, int idProfil, String contenu) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void validationInvitation(boolean valide) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

}
