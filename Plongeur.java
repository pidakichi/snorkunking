public class Plongeur {

    protected int positionX, positionY, poids, score, nbCoffre;
    //mettre la position Y en "case" plutot qu'en pixel plus facile pour gerer la position


    //faut peut etre changer positionY en valeur par defaut lors de la construction
    public Plongeur(int _positionX){
        positionX = _positionX;
        positionY = 0;
        poids = 1;
        score = 0;
        nbCoffre = 0;
    }



    //méthodes


    public void monter(){
        positionY = positionY - 1;
    }

    public void descendre(){
        positionY = positionY + 1;
    }

    public void prendre(int i){//i = nb de tresor dans le coffres
        poids = poids + i;
        nbCoffre = nbCoffre+1;
    }//prendre un entier et faire plus un entier

    public int retourNbCoffre(){
        return nbCoffre;
    }


    public int retourPoids(){
        return poids;
    }

    public int retourPositionY(){
        return positionY;
    }

    public int retourScore(){
        return score;
    }

    public void setScore(){
        score = score + poids - 1;
    }

    public void remiseAZero(){
        positionY = 0;
        poids = 1;
        nbCoffre = 0;
    }


}
