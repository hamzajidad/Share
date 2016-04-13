package share;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.ImageIcon;

public class Tchat implements Runnable {
	
	public JFrame fenetre;
	/*public JButton */

public Tchat()  {
   fenetre = new JFrame("Partage");

}


  public  void run(){
	  	//création de la fenetre
       //Définit sa taille : 400 pixels de large et 100 pixels de haut
         fenetre.setSize(400, 400);
       //Nous demandons maintenant à notre objet de se positionner au centre
         fenetre.setLocationRelativeTo(null);
       //Termine le processus lorsqu'on clique sur la croix rouge
         fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       //Et enfin, la rendre visible        
         fenetre.setVisible(true);  
        //création du Jpanel ce qui est par dessus ma fentre
          @SuppressWarnings("unused")
		 JPanel pan = new JPanel();
         fenetre.add(new JLabel(new ImageIcon("/ext/jidadh/workspace/Share/src/share/image.png")));
         
         
         
    		    }
  public static void main(String[] args){
	  SwingUtilities.invokeLater(new Tchat());
  }
  
}
