
import javax.swing.*;
import java.awt.*;


public class EndUpFenetre extends JFrame{


    EndUpPanel p2 = new EndUpPanel(this);


    public EndUpFenetre() throws HeadlessException {
        this.setSize(new Dimension(900, 500));
        this.setUndecorated(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setContentPane(p2);
        this.setVisible(true);
    }

    public int retourRejouer(){
        return p2.rejouer;
    }
}

