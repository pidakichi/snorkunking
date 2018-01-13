import java.util.Random;

public class Coffre {

    private int nbTresor;


    //coffre nul
    public Coffre(){
        nbTresor = 0;
    }

    public Coffre(int i){
        Random rand = new Random();
        if(i == 1){
            nbTresor = rand.nextInt(3)+1;
        }

        else if (i == 2){
            nbTresor = rand.nextInt(4)+5;
        }

        else{
            nbTresor = rand.nextInt(3)+10;
        }
    }


    //méthodes

    public int retourNbTresor(){
        return nbTresor;
    }


}
