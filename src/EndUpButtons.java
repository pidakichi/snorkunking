import javax.swing.*;
import java.awt.*;


public class EndUpButtons extends JPanel{

    private String s;
    private int textSize;
    private Color textColor = Color.BLACK;

    public EndUpButtons(String s, int txtSize) {
        this.s = s;
        this.textSize = txtSize;
        this.setBackground(Color.decode("#7c7c7c"));
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(textColor);
        g.setFont(new Font("Courier", Font.BOLD, textSize));
        g.drawString(s, (this.getWidth() /2) - (g.getFontMetrics().stringWidth(s) / 2),
                (this.getHeight() / 2) + (g.getFontMetrics().getHeight()/4));
    }
}
