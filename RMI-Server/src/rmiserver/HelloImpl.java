package rmiserver;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class HelloImpl extends UnicastRemoteObject implements HelloInterface,Serializable{

	protected HelloImpl() throws RemoteException {
		super();
	}

	@Override
	public String hello() throws RemoteException {
		return "hello";
	}

}
