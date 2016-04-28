package rmiclient;

import java.rmi.Remote;

public interface HelloInterface extends Remote {

	public String hello();
	
}