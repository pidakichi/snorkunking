


public class Main {


    public static void miseEnMarche(){


        StartUpFenetre fen = new StartUpFenetre();
        fen.setVisible(true);
        fen.son();

        while(fen.p1.nbJoueur == 0){
            System.out.println(fen.retourNbJoueur());
        }


        fen.son();

        Fenetre fenetre = new Fenetre();
        fenetre.setVisible(true);
        fenetre.jeu();


        miseEnMarche();
    }


    public static void main(String[] args) {

        miseEnMarche();

    }

}
