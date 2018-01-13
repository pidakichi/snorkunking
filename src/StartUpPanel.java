
import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

public class StartUpPanel extends JPanel implements MouseListener {

   // variables d'instance pour le choix du nombre de joueur
	
	private static StartUpButtons choix1 = new StartUpButtons("1", 40);
    private static StartUpButtons choix2 = new StartUpButtons("2", 40);
   
    private static boolean[] isCliked = {false, false};

   
    // 
    
    private static StartUpButtons exit = new StartUpButtons("Quitter", 20);
    private static StartUpButtons play = new StartUpButtons("Jouer", 20);
    private static JPanel actionButtonsPanel = new JPanel();
  
    //
    
    private static GridLayout glAction = new GridLayout(1, 2, 5, 5);

    private static GridLayout glChoix = new GridLayout(2, 2, 5, 5);
    private static JPanel choixPanel = new JPanel();

    private static JFrame mainFrame;

    public int nbJoueur = 0;

    // constructeur
    
    public StartUpPanel(JFrame mainFrame) {
        setLayout(null);
        choixPanel.setLayout(glChoix);
        choixPanel.setOpaque(false);
        actionButtonsPanel.setLayout(glAction);
        actionButtonsPanel.setOpaque(false);

        this.mainFrame = mainFrame;

        choix1.setName("1");					//spécifie la position et la taille d'un composant d'une interface graphique 
        choix1.addMouseListener(this);	
        choixPanel.add(choix1);

        choix2.setName("2");
        choix2.addMouseListener(this);
        choixPanel.add(choix2);

        exit.setName("exit");
        exit.addMouseListener(this);
        actionButtonsPanel.add(exit); 

        play.setName("play");
        play.addMouseListener(this);
        actionButtonsPanel.add(play);

        this.add(choixPanel);
        choixPanel.setBounds(50, 120, 150, 150);

        this.add(actionButtonsPanel);
        actionButtonsPanel.setBounds(595, 445, 300, 50);
    }

    
    
    //dessin
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image img = null;
        try {
            img = ImageIO.read(getClass().getResource("Drawables/StartUpFenetreBackground.png"));
        } catch (IOException e) {
            e.printStackTrace(); //identifie la méthode où il y a un problème
        }
        g.drawImage(img, 0, 0, null); //dessine l'image 
    }

    @Override
    public void mouseClicked(MouseEvent e) {  //la souris clique sur un composant
        if(e.getComponent().getName().equals("exit")){
            System.exit(0);
        }else if(e.getComponent().getName().equals("play")){
            if(isCliked[0]){
                mainFrame.dispose();  //destruction de la fenetre
                nbJoueur = 1;


            }else if(isCliked[1]){
                mainFrame.dispose();
                nbJoueur = 2;
           
            }
        }else{
            for(int i = 0; i < isCliked.length; i++){
                if(isCliked[i]){
                    if(i == 0){
                        choix1.setBackground(Color.decode("#7c7c7c"));
                        isCliked[0] = false;
                    }else if(i == 1){
                        choix2.setBackground(Color.decode("#7c7c7c"));
                        isCliked[1] = false;
                   
                    }
                }
            }

            if(e.getComponent().getName().equals("1")){
                if(!isCliked[0]){
                    choix1.setBackground(Color.decode("#23b5ff"));
                    isCliked[0] = true;
                }else{
                    choix1.setBackground(Color.decode("#7c7c7c"));
                    isCliked[0] = false;
                }
            }else if(e.getComponent().getName().equals("2")){
                if(!isCliked[1]){
                    choix2.setBackground(Color.decode("#23b5ff"));
                    isCliked[1] = true;
                }else{
                    choix2.setBackground(Color.decode("#7c7c7c"));
                    isCliked[1] = false;
                }
            }
                }
            }
        
    


    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getComponent().getName().equals("1")){
            if(!isCliked[0]){
                choix1.setBackground(Color.decode("#494949"));
            }
        }else if(e.getComponent().getName().equals("2")){
            if(!isCliked[1]){
                choix2.setBackground(Color.decode("#494949"));
            }
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getComponent().getName().equals("1")){
            if(!isCliked[0]){
                choix1.setBackground(Color.decode("#7c7c7c"));
            }
        }else if(e.getComponent().getName().equals("2")){
            if(!isCliked[1]){
                choix2.setBackground(Color.decode("#7c7c7c"));
            }
        }
        
    }
}
