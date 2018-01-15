
import javax.swing.JFrame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.InputStream;
import java.util.Random;
import sun.audio.*;

public class Fenetre extends JFrame {


	//private static final long serialVersionUID = 1L; //ajouté automatiquement pour enlever une erreur

	private ContenuFenetre contenuFenetre = new ContenuFenetre();
    Plongeur plongeur1 = contenuFenetre.plongeur1;
    Plongeur plongeur2 = contenuFenetre.plongeur2;
	Cave cave1 = contenuFenetre.cave1;
	Cave cave2 = contenuFenetre.cave2;
	Cave cave3 = contenuFenetre.cave3;


    int [] order = new int[3];

	int interrupteur = 0;


	public Fenetre() {
		this.setTitle("Snorkunking");
		this.setSize(1200,1000);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setAlwaysOnTop(true);
		this.setContentPane(contenuFenetre);
		this.addKeyListener(new ClavierListener() );


	}

	class ClavierListener implements KeyListener{

	    @Override
		public void keyTyped(KeyEvent e) {
			if (order[interrupteur] == 1){
			    tourjoueur(plongeur1, e);
            }
            else if (order[interrupteur] == 2){
			    tourjoueur(plongeur2, e);
            }
            interrupteur++;
            if (interrupteur == 2){
                aquiletour();
            	interrupteur =0;
			}

            contenuFenetre.repaint();
			}

        @Override
		public void keyReleased(KeyEvent e) {

		}

		@Override
		public void keyPressed(KeyEvent e) {
		}
	}



	public void aquiletour(){

		if(plongeur1.retourPositionY() < plongeur2.retourPositionY()){
			order[0] = 1;
			order[1] = 2;
		}
		else if (plongeur2.retourPositionY() < plongeur1.retourPositionY()){

			order[0] = 2;
			order[1] = 1;
		}
		else {
			Random rand = new Random();
			int a = rand.nextInt(2);
			if (a == 0){
				order[0] = 1;
				order[1] = 2;
			}
			else{
				order[0] = 2;
				order[1] = 1;
			}
		}

	}


    public void tourjoueur (Plongeur plongeur, KeyEvent e){
        if (e.getKeyChar() == 'a' && plongeur.retourPositionY() != 0){
        	//mettre condition monter
            plongeur.monter();
			contenuFenetre.oxygene = contenuFenetre.oxygene - plongeur.retourPoids();
			sonMouvement();

        }
        else if (e.getKeyChar() == 'q' && plongeur.retourPositionY() != contenuFenetre.nbNiveau){
            plongeur.descendre();
			contenuFenetre.oxygene = contenuFenetre.oxygene - plongeur.retourPoids();
			sonMouvement();

        }
        else if (e.getKeyChar() == 'w' ){
			//plongeur dans la cave 1
			if(plongeur.retourPositionY()<cave1.retourNbNiveau()+1) {
				//ajout du poids du coffre
				plongeur.prendre(cave1.retourNiveau(plongeur.retourPositionY() - 1).retourCoffre(0).retourNbTresor());

				contenuFenetre.oxygene = contenuFenetre.oxygene - plongeur.retourPoids();

				//suppression du coffre
				cave1.retourNiveau(plongeur.retourPositionY() - 1).suppCoffre(0);

			}

			//plongeur dans cave 3
			else if(plongeur.retourPositionY()> cave1.retourNbNiveau()+cave2.retourNbNiveau()-1){
				//ajout du poids du coffre
				plongeur.prendre(cave3.retourNiveau(plongeur.retourPositionY()-cave1.retourNbNiveau()-cave2.retourNbNiveau()-1).retourCoffre(0).retourNbTresor());

				contenuFenetre.oxygene = contenuFenetre.oxygene - plongeur.retourPoids();

				//suppression du coffre
				cave3.retourNiveau(plongeur.retourPositionY()-cave1.retourNbNiveau()-cave2.retourNbNiveau()-1).suppCoffre(0);
			}

			else{
				//ajout du poids du coffre
				plongeur.prendre(cave2.retourNiveau(plongeur.retourPositionY()-cave1.retourNbNiveau()-1).retourCoffre(0).retourNbTresor());

				contenuFenetre.oxygene = contenuFenetre.oxygene - plongeur.retourPoids();

				//suppression du coffre
				cave2.retourNiveau(plongeur.retourPositionY()-cave1.retourNbNiveau()-1).suppCoffre(0);
			}
			sonChest();
        }

        else{interrupteur--;}
    }

    public void tourBot(){

	}

    public void jeu(){
    	contenuFenetre.repaint();
        aquiletour();
        for (int i = 0; i < 3 ; i++){


			System.out.println("cave1 "+cave1.retourNbNiveau());
			System.out.println("cave2 " + cave2.retourNbNiveau());
			System.out.println("cave3 " + cave3.retourNbNiveau());

            while (contenuFenetre.oxygene > 0){


            	if(plongeur1.retourPositionY()==0 && plongeur1.retourPoids() !=1){
					plongeur1.setScore();
					plongeur1.remiseAZero();
				}

				if(plongeur2.retourPositionY()==0 && plongeur2.retourPoids() !=1){
					plongeur2.setScore();
					plongeur2.remiseAZero();
				}

				contenuFenetre.dessinTour = order[interrupteur];
				System.out.println(order[interrupteur]);
            }


            //faire tomber les coffres

			if(plongeur1.retourPoids() != 1) {
				cave3.retourNiveau(cave3.retourNbNiveau()-1).addCoffre(plongeur1.retourPoids());
			}
			if(plongeur2.retourPoids() != 1) {
				cave3.retourNiveau(cave3.retourNbNiveau()-1).addCoffre(plongeur2.retourPoids());
			}

			//update de la map des niveaux, on supprime les niveaux où les coffres on été pris

			cave1.caveFinPhase();
			cave2.caveFinPhase();
			cave3.caveFinPhase();



            plongeur1.remiseAZero();
            plongeur2.remiseAZero();
            contenuFenetre.repaint();
			contenuFenetre.oxygene = 2*contenuFenetre.nbNiveau;
			contenuFenetre.repaint();
        }

		this.dispose();

    }

    public void sonMouvement(){
		try{
			InputStream in = getClass().getResourceAsStream("Sounds/movement.wav");
			AudioStream au = new AudioStream(in);
			AudioPlayer.player.start(au);
		}catch(Exception e){}
	}

	public void sonChest(){
    	try{
    		InputStream in = getClass().getResourceAsStream("Sounds/open.wav");
    		AudioStream au = new AudioStream(in);
    		AudioPlayer.player.start(au);
		}catch(Exception e){}
	}
}
