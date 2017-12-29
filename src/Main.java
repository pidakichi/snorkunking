public class Main {


    public static void main(String[] args) {

        //création des plongeurs
        Plongeur plongeur1 = new Plongeur(600,40,0, 0);
        Plongeur plongeur2 = new Plongeur (400, 40, 0, 0);

        //création de la 1ere cave
        Cave cave1 = new Cave(1);

        //création de la 2eme cave
        Cave cave2 = new Cave(2);

        //création de la 3eme cave
        Cave cave3 = new Cave(3);
        
        Fenetre fenetrePrincipale = new Fenetre();
        fenetrePrincipale.setVisible(true);



    }

}
