
import javax.swing.*;
import sun.audio.*;
import java.awt.*;
import java.io.InputStream;


public class StartUpFenetre extends JFrame {

    StartUpPanel p1 = new StartUpPanel(this);

    public StartUpFenetre() throws HeadlessException {
        this.setSize(new Dimension(900, 500));
        this.setUndecorated(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setContentPane(p1);
        this.setVisible(false);
    }

    public void son(){
        try{
            InputStream in = getClass().getResourceAsStream("Sounds/splash.wav");
            AudioStream au = new AudioStream(in);
            AudioPlayer.player.start(au);
        }catch(Exception e){}
    }

    public int modeDeJeu(){
        return p1.modeDeJeu();
    }
    public int retourNbJoueur(){
        return p1.nbJoueur;
    }
}
