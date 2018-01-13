import java.lang.reflect.Array;
import java.util.ArrayList;
import  java.util.Random;

public class Cave {

    private int nbNiveau;
    public ArrayList<Niveau> tabNiveau;

    public Cave (int i){
        Random rand = new Random();
        tabNiveau = new ArrayList<Niveau>();
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

    public int retourNbNiveau(){
        return tabNiveau.size();
    }

    public void caveFinPhase(){
        ArrayList<Niveau> copy = new ArrayList<>();
        for(int i = 0 ; i < tabNiveau.size() ; i++){
            if(tabNiveau.get(i).tabCoffre.size() != 0){
                copy.add(tabNiveau.get(i));
            }
        }
        this.tabNiveau = copy;
    }
}
