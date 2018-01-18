import javax.imageio.ImageIO;
import javax.swing.*;


import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;



public class EndUpPanel extends JPanel implements MouseListener {





    private static EndUpButtons replay = new EndUpButtons("Rejouer", 40);
    private static EndUpButtons exit = new EndUpButtons("Quitter", 40);

    private static boolean[] isCliked = {true};


    private static GridLayout glAction = new GridLayout(1, 2, 20, 20);
    //private static GridLayout glChoix = new GridLayout(2, 2, 5, 5);
    //private static JPanel choixPanel = new JPanel();
    private static JPanel actionButtonsPanel = new JPanel();

    private static JFrame mainFrame;

    public int rejouer = 0;

    public EndUpPanel (JFrame mainFrame) {
        setLayout(null);
        actionButtonsPanel.setLayout(glAction);
        actionButtonsPanel.setOpaque(true);

        this.mainFrame = mainFrame;

        exit.setName("exit");
        exit.addMouseListener(this);
        this.add(actionButtonsPanel);
        actionButtonsPanel.add(exit);
        actionButtonsPanel.setBounds(200, 345, 450, 75);

        replay.setName("replay");
        replay.addMouseListener(this);
        //this.add(actionButtonsPanel);
        actionButtonsPanel.add(replay);


    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image img = null;
        try {
            img = ImageIO.read(getClass().getResource("Drawables/EndUpFenetreBackground.jpg"));
        } catch (IOException e) {
            e.printStackTrace(); //identifie la méthode où il y a un problème
        }
        g.drawImage(img, 0, 0, null); //dessine l'image



    }




    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getComponent().getName().equals("exit")) {
            System.exit(0);
        }
        else if (e.getComponent().getName().equals("replay")){
            if (isCliked[0]) {
                replay.setBackground(Color.green);
                mainFrame.dispose();
                rejouer = 1;


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

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
