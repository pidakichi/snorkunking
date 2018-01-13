
import javax.swing.*;

import java.awt.*;

public class StartUpFenetre extends JFrame {

    StartUpPanel p1 = new StartUpPanel(this);

    public StartUpFenetre() throws HeadlessException {
        this.setSize(new Dimension(900, 500));
        this.setUndecorated(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setContentPane(p1);
        this.setVisible(true);
    }

    public int retourNbJoueur(){
        return p1.nbJoueur;
    }
}
