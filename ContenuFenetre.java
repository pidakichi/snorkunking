import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;


public class ContenuFenetre extends JPanel{


    public Plongeur plongeur1 = new Plongeur(100);
    public Plongeur plongeur2 = new Plongeur(200);


    Cave cave1 = new Cave(1);
    Cave cave2 = new Cave(2);
    Cave cave3 = new Cave(3);

    int nbNiveau = cave1.retourNbNiveau()+cave2.retourNbNiveau()+cave3.retourNbNiveau();

    int oxygene = 2*nbNiveau;

    int dessinTour = 0;

    int fenetreFin = -1;


    public ContenuFenetre() {

        this.setBackground(Color.gray);
        this.requestFocus();

    }

    public void paintComponent(Graphics g) {
        Image bg = null;
        Image imgCoffrePlein = null;
        Image imgPlongeur1 = null;
        Image imgPlongeur2 = null;
        Image imgPlongeur1coffre = null;
        Image imgPlongeur2coffre = null;

        g.setFont(new Font("Courier" , Font.BOLD , 20));

        try {
            bg = ImageIO.read(getClass().getResource("Drawables/bg2.jpg"));
            imgCoffrePlein = ImageIO.read(getClass().getResource("Drawables/coffre-plein.png"));
            imgPlongeur1 = ImageIO.read(getClass().getResource("Drawables/plongeur1.png"));
            imgPlongeur2 = ImageIO.read(getClass().getResource("Drawables/plongeur2.png"));
            imgPlongeur1coffre = ImageIO.read(getClass().getResource("Drawables/plongeur1-coffre.png"));
            imgPlongeur2coffre = ImageIO.read(getClass().getResource("Drawables/plongeur2-coffre.png"));
        } catch (IOException e) {
            e.printStackTrace(); //identifie la méthode où il y a un problème
        }

        if (fenetreFin == -1) {
            super.paintComponent(g);



            g.drawImage(bg, 0, 0, null);

            //dessin des niveaux et des coffres
            //cave 1
            for (int i = 0; i < cave1.retourNbNiveau(); i++) {
                g.setColor(Color.lightGray);
                g.fillRect(340, 80 + 30 * i, 600, 20);
                for (int j = 0; j < cave1.retourNiveau(i).retourNbCoffre(); j++) {
                    g.setColor(Color.orange);
                    //g.fillRect(200-j*20, 80+30*i, 20,20);
                    g.drawImage(imgCoffrePlein, 200 - j * 20, 80 + 30 * i, null);
                    //g.drawString(String.valueOf(cave1.retourNiveau(i).retourCoffre(0).retourNbTresor()),260,80+30*i);
                }

            }

            //cave 2
            for (int i = 0; i < cave2.retourNbNiveau(); i++) {
                g.setColor(Color.cyan);
                g.fillRect(340, 80 + 30 * i + 30 * cave1.retourNbNiveau(), 600, 20);
                for (int j = 0; j < cave2.retourNiveau(i).retourNbCoffre(); j++) {
                    g.setColor(Color.orange);
                    //g.fillRect(200-j*20, 80+30*i+30*cave1.retourNbNiveau(), 20, 20);
                    g.drawImage(imgCoffrePlein, 200 - j * 20, 80 + 30 * i + 30 * cave1.retourNbNiveau(), null);
                    //g.drawString(String.valueOf(cave2.retourNiveau(i).retourCoffre(0).retourNbTresor()),260,80+30*i+30*cave1.retourNbNiveau());
                }
            }

            //cave 3
            for (int i = 0; i < cave3.retourNbNiveau(); i++) {
                g.setColor(Color.blue);
                g.fillRect(340, 80 + 30 * i + 30 * cave1.retourNbNiveau() + 30 * cave2.retourNbNiveau(), 600, 20);
                for (int j = 0; j < cave3.retourNiveau(i).retourNbCoffre(); j++) {
                    g.setColor(Color.orange);
                    //g.fillRect(200-j*30, 80+30*i+30*cave1.retourNbNiveau()+30*cave2.retourNbNiveau(), 20,20);
                    g.drawImage(imgCoffrePlein, 200 - j * 30, 80 + 30 * i + 30 * cave1.retourNbNiveau() + 30 * cave2.retourNbNiveau(), null);
                    //g.drawString(String.valueOf(cave3.retourNiveau(i).retourCoffre(0).retourNbTresor()),260,80+30*i+30*cave1.retourNbNiveau()+30*cave2.retourNbNiveau());
                }
            }


            //dessin des plongeurs
            g.setColor(Color.black);
            if (plongeur1.retourPoids() == 1) {
                g.drawImage(imgPlongeur1, 500, 40 + 30 * plongeur1.retourPositionY(), null);
            } else {
                g.drawImage(imgPlongeur1coffre, 500, 40 + 30 * plongeur1.positionY, null);
            }


            if (plongeur2.retourPoids() == 1) {
                g.drawImage(imgPlongeur2, 800, 40 + 30 * plongeur2.retourPositionY(), null);
            } else {
                g.drawImage(imgPlongeur2coffre, 800, 40 + 30 * plongeur2.retourPositionY(), null);
            }

            if (dessinTour == 1) {
                g.drawOval(500, 40 + 30 * plongeur1.retourPositionY(), 50, 50);
            } else if (dessinTour == 2) {
                g.drawOval(800, 40 + 30 * plongeur2.retourPositionY(), 50, 50);
            }


            g.setColor(Color.white);
            g.drawString("poids plongeur 1: " + String.valueOf(plongeur1.retourPoids()), 400, 950);
            g.drawString(String.valueOf("score total plongeur 1: " + plongeur1.retourScore()), 400, 900);
            g.drawString(String.valueOf("poids plongeur 2: " + plongeur2.retourPoids()), 900, 950);
            g.drawString(String.valueOf("score total plongeur 2: " + plongeur2.retourScore()), 900, 900);

            g.setColor(Color.green);
            g.fillRect(150, 20, 3*oxygene, 20);
            g.setColor(Color.white);

            g.drawString("Oxygene", 25, 35);
            g.drawString(String.valueOf(oxygene), 150, 35);



        }
        else if(fenetreFin == 2){
            g.drawImage(bg, 0, 0, null);
            g.drawString("Le gagnant est le plongeur 2", 500, 400);
            g.drawImage(imgPlongeur2, 600, 500, null);
        }
        else if(fenetreFin == 1){
            g.drawImage(bg, 0, 0, null);
            g.drawString("Le gagnant est le plongeur 1", 500, 400);
            g.drawImage(imgPlongeur1, 600, 500, null);
        }
        else if (fenetreFin == 0){
            g.drawImage(bg, 0, 0, null);
            g.drawString("Egalité entre les joueurs", 500, 400);
            g.drawImage(imgPlongeur1, 500, 500, null);
            g.drawImage(imgPlongeur2, 700, 500, null);
        }
    }



}
