import java.util.ArrayList;
import  java.util.Random;

public class Cave {

    private int nbNiveau;
    private ArrayList<Niveau> tabNiveau;

    public Cave (int i){
        Random rand = new Random();
        if(i == 1){
            nbNiveau = rand.nextInt(4)+9;//nous donne une valeur entre 9 et 12
        }

        else if (i == 2){
            nbNiveau = rand.nextInt(4)+6;
        }

        else{
            nbNiveau = rand.nextInt(4)+3;
        }
        for ( int j = 0; j < nbNiveau ; j++){
            tabNiveau.add(new Niveau(i));
        }
    }

    //on supprime les niveaux où les coffres sont vides
    public void finPhaseSuppNiveau(){
        for (int i = 0 ; i < tabNiveau.size() ; i++){

        }
    }

}
