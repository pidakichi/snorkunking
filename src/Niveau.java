import java.util.ArrayList;

public class Niveau {

    public ArrayList<Coffre> tabCoffre;

    public Niveau(){
        tabCoffre = new ArrayList<Coffre>();
        tabCoffre.add(new Coffre());
    }

    public Niveau(int i){ //i pour savoir dans quelle partie est le niveau
        tabCoffre = new ArrayList<Coffre>();
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


    public void suppCoffre(int i){
        tabCoffre.remove(i);
    }

    public int retourNbCoffre(){
        return tabCoffre.size();
    }


}
