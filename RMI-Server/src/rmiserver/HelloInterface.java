package rmiserver;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface HelloInterface extends Remote{

	public String hello() throws RemoteException;
	
}
