
import javax.swing.JFrame;

public class Fenetre extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; //ajouté automatiquement pour enlever une erreur

	public Fenetre() {
		super();
		proprietesFenetre();
	}
	
	private void proprietesFenetre() {
		this.setSize(800 , 700);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setAlwaysOnTop(true);
		
		this.setContentPane(new ConteneurFenetre()); //affiche le panneau de conteneur fenetre
		
		
		
	}

}
