import javax.swing.JPanel;

import com.sun.prism.BasicStroke;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class ConteneurFenetre extends JPanel implements KeyListener {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L; //ajouté automatiquement

	private int originePlongeur1Y = 140;
	private int originePlongeur2Y = 140;
	int nombreNiveau1 = 9 + (int) (Math.random() * ((12 - 9) + 1));
	int nombreNiveau2 = 6 + (int) (Math.random() * ((9 - 6) + 1));
	int nombreNiveau3 = 3 + (int) (Math.random() * ((6 - 3) + 1));

	public ConteneurFenetre() {

		this.setBackground(Color.blue);
		this.requestFocus();
		this.addKeyListener(this);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		//caves en jaune
		g.setColor(Color.YELLOW);

		//nombre aléatoire de niveaux dans la cave 1 (entre 9 et 12 niveaux)
		System.out.println(nombreNiveau1);
		g.fillRect(100, 130, 600, nombreNiveau1 * 20);
		if (9 <= nombreNiveau1 && nombreNiveau1 <= 12) {
			for (int i = 0; i < nombreNiveau1; i++) {
				g.drawRect(100, 130 + i * 20, 600, 20);
			}
		}

		//nombre aléatoire de niveaux dans la cave 2 (entre 6 et 9 niveaux)
		System.out.println(nombreNiveau2);
		g.fillRect(100, 380, 600, nombreNiveau2 * 20);
		if (6 <= nombreNiveau2 && nombreNiveau2 <= 9) {
			for (int i = 0; i < nombreNiveau2; i++) {
				g.drawRect(100, 380 + i * 20, 600, 20);
			}
		}


		//nombre aléatoire de niveaux dans la cave 3 (entre 3 et 6 niveaux)
		System.out.println(nombreNiveau3);
		g.fillRect(100, 570, 600, nombreNiveau3 * 20);
		if (3 <= nombreNiveau3 && nombreNiveau3 <= 6) {
			for (int i = 0; i < nombreNiveau3; i++) {
				g.drawRect(100, 570 + i * 20, 600, 20);
			}
		}


		g.setColor(Color.BLACK);
		g.fillOval(600, originePlongeur1Y, 10, 10);

		g.setColor(Color.RED);
		g.fillOval(400, originePlongeur2Y, 10, 10);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("clic bas");
		while (originePlongeur1Y <= originePlongeur2Y && 140 <= originePlongeur1Y && originePlongeur1Y <= 140 + nombreNiveau1 * 20) {
			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				originePlongeur1Y += 20;
				repaint();
			}
			if (e.getKeyCode() == KeyEvent.VK_UP) {
				originePlongeur1Y -= 20;
				repaint();

			}

			while (originePlongeur2Y < originePlongeur1Y && 140 <= originePlongeur2Y && originePlongeur2Y <= 140 + nombreNiveau1 * 20) {
				if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					originePlongeur2Y += 20;
					repaint();
				}
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					originePlongeur2Y += 20;
					repaint();
				}

				while (originePlongeur1Y <= originePlongeur2Y &&) {
				}
			}

		}

		@Override
		public void keyPressed (KeyEvent e){
			// TODO Auto-generated method stub
			System.out.println("clic bas");

		}

		@Override
		public void keyReleased (KeyEvent e){
			// TODO Auto-generated method stub
			System.out.println("clic bas");

		}

	}
}

