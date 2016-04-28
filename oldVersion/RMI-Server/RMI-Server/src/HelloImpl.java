import java.rmi.RemoteException;

import java.rmi.server.UnicastRemoteObject;
import java.io.Serializable;

public class HelloImpl extends UnicastRemoteObject implements HelloInterface, Serializable {

	protected HelloImpl() throws RemoteException {
		super();
	}

	@Override
	public String hello() throws RemoteException {
		return "hello";
	}
	
	public int Calcul(int a, int b) throws RemoteException{
		return a+b;
	}
}
