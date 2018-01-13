
import javax.swing.*;

import java.awt.*;

public class StartUpFenetre extends JFrame {

    public StartUpFenetre() throws HeadlessException {
        this.setSize(new Dimension(900, 500));
        this.setUndecorated(true);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setContentPane(new StartUpPanel(this));
        this.setVisible(true);
    }
}
