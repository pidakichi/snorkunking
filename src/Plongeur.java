public class Plongeur {

    public int positionX, positionY, poids, score;

    //faut peut etre changer positionY en valeur par defaut lors de la construction
    public Plongeur(int _positionX, int _positionY, int _poids, int _score){
        positionX = _positionX;
        positionY = _positionY;
        poids = _poids;
        score = _score;
    }


    //méthodes


    public void monter(){
        positionY = positionY + 1;
    }

    public void descendre(){
        positionY = positionY - 1;
    }

    public void prendre(){
        poids = poids + 1;
    }

    //retourner le nb de tresor qu'il a pour les faire tomber
    public int finPhase(){
        return poids;
    }

}
