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

    //retirer les coffres vides a la fin de la phase, verifier si la suppression change les indices! méthode peut etre inutile, il suffit de pas l'
    //afficher en fait
    public void finPhaseSuppCoffre(){
        Coffre coffreNul = new Coffre();
        for (int i = 0 ; i < tabCoffre.size() ; i++){
            if(tabCoffre.get(i).equals(coffreNul)){
                tabCoffre.remove(tabCoffre.get(i));
            }
        }
    }

    //on ajoute les tresors dans un nouveau coffre au dernier niveau, i est le nb de tresor
    public void finPhaseAjoutCoffre(int i){
        tabCoffre.add(new Coffre (i));
    }

}
