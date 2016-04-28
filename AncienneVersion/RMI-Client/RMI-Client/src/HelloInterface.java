import java.rmi.Remote;

public interface HelloInterface extends Remote{

	public String hello();
	public int Calcul(int a, int b);
	
}