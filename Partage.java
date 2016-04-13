package share;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities; 

public class Partage  implements Runnable {
  public static void main(String[] args){
		SwingUtilities.invokeLater( (Runnable) new Partage());
  }
   
  public Partage(){}

@Override
public void run() {
	 JFrame fenetre = new JFrame();
	    //Définit un titre pour notre fenêtre
	    fenetre.setTitle("Partage");
	    //Définit sa taille : 400 pixels de large et 100 pixels de haut
	    fenetre.setSize(400, 400);
	    //Nous demandons maintenant à notre objet de se positionner au centre
	    fenetre.setLocationRelativeTo(null);
	    //Termine le processus lorsqu'on clique sur la croix rouge
	    fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    //Et enfin, la rendre visible        
	    fenetre.setVisible(true);   
	    
	    JLabel label1 = new JLabel();
	    label1.setText("c'est MOIIIIIIIIIII");
	    label1.setBounds(0, 0, 200, 50);
}
  }       
