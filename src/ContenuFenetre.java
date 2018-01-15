import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;


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

        Image bg = null;
        Image imgCoffrePlein = null;
        Image imgPlongeur1 = null;
        Image imgPlongeur2 = null;
        try {
            bg = ImageIO.read(getClass().getResource("Drawables/bg2.jpg"));
            imgCoffrePlein = ImageIO.read(getClass().getResource("Drawables/coffre-plein.png"));
            imgPlongeur1 = ImageIO.read(getClass().getResource("Drawables/plongeur1.png"));
            imgPlongeur2 =  ImageIO.read(getClass().getResource("Drawables/plongeur2.png"));
        } catch (IOException e) {
            e.printStackTrace(); //identifie la méthode où il y a un problème
        }


        g.drawImage(bg,0,0,null);

        //dessin des niveaux et des coffres
        //cave 1
        for(int i = 0 ; i < cave1.retourNbNiveau() ; i++){
            g.setColor(Color.lightGray);
            g.fillRect(340, 80+30*i, 600,20);
            for(int j = 0 ; j < cave1.retourNiveau(i).retourNbCoffre() ; j++){
                g.setColor(Color.orange);
                //g.fillRect(200-j*20, 80+30*i, 20,20);
                g.drawImage(imgCoffrePlein,200-j*20,80+30*i, null);
                g.drawString(String.valueOf(cave1.retourNiveau(i).retourCoffre(0).retourNbTresor()),260,80+30*i);
            }

        }

        //cave 2
        for(int i = 0 ; i < cave2.retourNbNiveau() ; i++){
            g.setColor(Color.cyan);
            g.fillRect(340,80+30*i+30*cave1.retourNbNiveau(),600,20);
            for(int j = 0 ; j < cave2.retourNiveau(i).retourNbCoffre() ; j++){
                g.setColor(Color.orange);
                //g.fillRect(200-j*20, 80+30*i+30*cave1.retourNbNiveau(), 20, 20);
                g.drawImage(imgCoffrePlein, 200-j*20, 80+30*i+30*cave1.retourNbNiveau(), null);
                g.drawString(String.valueOf(cave2.retourNiveau(i).retourCoffre(0).retourNbTresor()),260,80+30*i+30*cave1.retourNbNiveau());
            }
        }

        //cave 3
        for (int i = 0 ; i < cave3.retourNbNiveau() ; i++){
            g.setColor(Color.blue);
            g.fillRect(340, 80+30*i+30*cave1.retourNbNiveau()+30*cave2.retourNbNiveau(), 600, 20);
            for(int j = 0 ; j < cave3.retourNiveau(i).retourNbCoffre() ; j++){
                g.setColor(Color.orange);
                //g.fillRect(200-j*30, 80+30*i+30*cave1.retourNbNiveau()+30*cave2.retourNbNiveau(), 20,20);
                g.drawImage(imgCoffrePlein, 200-j*30, 80+30*i+30*cave1.retourNbNiveau()+30*cave2.retourNbNiveau(), null );
                g.drawString(String.valueOf(cave3.retourNiveau(i).retourCoffre(0).retourNbTresor()),260,80+30*i+30*cave1.retourNbNiveau()+30*cave2.retourNbNiveau());
            }
        }





        //dessin des plongeurs
        g.setColor(Color.red);

        g.drawImage(imgPlongeur1, 500, 40+30*plongeur1.retourPositionY(), null);


        g.setColor(Color.black);

        g.drawImage(imgPlongeur2, 800, 40+30*plongeur2.retourPositionY(), null);

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
