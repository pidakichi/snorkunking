import java.util.ArrayList;

public class Niveau {

    private ArrayList<Coffre> tabCoffre;

    public Niveau(int i){ //i pour savoir dans quelle partie est le niveau
        if (i == 1){
            tabCoffre.add(new Coffre(i));
        }
        else if (i == 2){
            tabCoffre.add(new Coffre(i));
        }
        else{
            tabCoffre.add(new Coffre(i));
        }
    }


    //méthodes

    //retirer les coffres vides a la fin de la phase
    public void finPhase(){
        Coffre coffreNul = new Coffre();
        for (int i = 0 ; i < tabCoffre.size() ; i++){
            if(tabCoffre.get(i).equals(coffreNul)){
                tabCoffre.remove(tabCoffre.get(i));
            }
        }
    }

}
