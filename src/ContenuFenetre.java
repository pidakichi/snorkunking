import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;


public class ContenuFenetre extends JPanel{



    Plongeur plongeur1 = new Plongeur(100);
    Plongeur plongeur2 = new Plongeur(200);


    Cave cave1 = new Cave(1);
    Cave cave2 = new Cave(2);
    Cave cave3 = new Cave(3);

    int nbNiveau = cave1.retourNbNiveau()+cave2.retourNbNiveau()+cave3.retourNbNiveau();

    int oxygene = 2*nbNiveau;

    int dessinTour = 0;


    public ContenuFenetre() {

        this.setBackground(Color.gray);
        this.requestFocus();

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);


        //dessin des niveaux et des coffres
        //cave 1
        for(int i = 0 ; i < cave1.retourNbNiveau() ; i++){
            g.setColor(Color.lightGray);
            g.fillRect(340, 80+30*i, 600,20);
            for(int j = 0 ; j < cave1.tabNiveau.get(i).retourNbCoffre() ; j++){
                g.setColor(Color.orange);
                g.fillRect(200-j*20, 80+30*i, 20,20);
                g.drawString(String.valueOf(cave1.tabNiveau.get(i).tabCoffre.get(0).retourNbTresor()),260,80+30*i);
            }

        }

        //cave 2
        for(int i = 0 ; i < cave2.retourNbNiveau() ; i++){
            g.setColor(Color.cyan);
            g.fillRect(340,80+30*i+30*cave1.retourNbNiveau(),600,20);
            for(int j = 0 ; j < cave2.tabNiveau.get(i).retourNbCoffre() ; j++){
                g.setColor(Color.orange);
                g.fillRect(200-j*20, 80+30*i+30*cave1.retourNbNiveau(), 20, 20);
                g.drawString(String.valueOf(cave2.tabNiveau.get(i).tabCoffre.get(0).retourNbTresor()),260,80+30*i+30*cave1.retourNbNiveau());
            }
        }

        //cave 3
        for (int i = 0 ; i < cave3.retourNbNiveau() ; i++){
            g.setColor(Color.blue);
            g.fillRect(340, 80+30*i+30*cave1.retourNbNiveau()+30*cave2.retourNbNiveau(), 600, 20);
            for(int j = 0 ; j < cave3.tabNiveau.get(i).retourNbCoffre() ; j++){
                g.setColor(Color.orange);
                g.fillRect(200-j*30, 80+30*i+30*cave1.retourNbNiveau()+30*cave2.retourNbNiveau(), 20,20);
                g.drawString(String.valueOf(cave3.tabNiveau.get(i).tabCoffre.get(0).retourNbTresor()),260,80+30*i+30*cave1.retourNbNiveau()+30*cave2.retourNbNiveau());
            }
        }





        //dessin des plongeurs
        g.setColor(Color.red);
        g.fillOval(500, 50+30*plongeur1.retourPositionY(), 10,10);

        g.setColor(Color.black);
        g.fillOval(800, 50+30*plongeur2.retourPositionY(),10,10);

        if(dessinTour == 1){
            g.drawOval(500,50+30*plongeur1.retourPositionY(), 20,20);
        }
        else{
            g.drawOval(800,50+30*plongeur2.retourPositionY(), 20,20);
        }

        g.drawString("oxygene restant: "+String.valueOf(oxygene),900,1000);
        g.drawString("poids plongeur 1: "+String.valueOf(plongeur1.retourPoids()), 900,850);
        g.drawString(String.valueOf("score total plongeur 1: "+plongeur1.retourScore()), 900, 800);
        g.drawString(String.valueOf("poids plongeur 2: "+plongeur2.retourPoids()), 900,950);
        g.drawString(String.valueOf("score total plongeur 2: "+plongeur2.retourScore()), 900, 900);

    }



}
