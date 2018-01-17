


public class Main {


    public static void miseEnMarche(){


        StartUpFenetre fen = new StartUpFenetre();
        fen.setVisible(true);
        fen.son();

        while(fen.p1.nbJoueur == 0){
            System.out.println(fen.retourNbJoueur());
        }


        fen.son();

        Fenetre fenetre = new Fenetre(fen.modeDeJeu());
        fenetre.setVisible(true);
        fenetre.jeu();
        fenetre.setVisible(false);

        EndUpFenetre endup = new EndUpFenetre();
        endup.setVisible(true);

        while(endup.retourRejouer() == 0){
            System.out.println("attente");
        }

        if(endup.retourRejouer() == 1) {
            fenetre.dispose();
            miseEnMarche();
        }
        System.out.println("fin");

    }


    public static void main(String[] args) {

        miseEnMarche();

    }

}
