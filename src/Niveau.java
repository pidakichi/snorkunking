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

}
