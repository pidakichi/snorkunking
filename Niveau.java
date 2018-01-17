import java.util.ArrayList;

public class Niveau {

    private ArrayList<Coffre> tabCoffre;

    public Niveau(){
        tabCoffre = new ArrayList<Coffre>();
        tabCoffre.add(new Coffre());
    }

    public Niveau(int i){ //i pour savoir dans quelle partie est le niveau
        tabCoffre = new ArrayList<Coffre>();
        if (i == 1){
            tabCoffre.add(new Coffre(i,""));
        }
        else if (i == 2){
            tabCoffre.add(new Coffre(i,""));
        }
        else{
            tabCoffre.add(new Coffre(i,""));
        }
    }

    public int tailleTabCoffre(){
        return tabCoffre.size();
    }

    public Coffre retourCoffre(int i){
        return tabCoffre.get(i);
    }

    public void addCoffre(int i){
        tabCoffre.add(new Coffre(i,"finPhase"));
    }


    public void suppCoffre(int i){
        tabCoffre.remove(i);
    }

    public int retourNbCoffre(){
        return tabCoffre.size();
    }


}
