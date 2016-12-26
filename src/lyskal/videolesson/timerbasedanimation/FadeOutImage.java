package lyskal.videolesson.timerbasedanimation;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class FadeOutImage extends JPanel implements ActionListener {
	static Image myImage;
	Timer timer = new Timer(20, this);
	private float alpha = 1f;

	public FadeOutImage() {
		myImage = new ImageIcon(getClass().getResource("a.jpg")).getImage();
		timer.start();
	}

	@Override
	public void paint(final Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
		g2d.drawImage(myImage, 0, 0, null);
	}

	@Override
	public void actionPerformed(final ActionEvent e) {
		alpha += -0.01f;
		if (alpha <= 0) {
			alpha = 0;
			timer.stop();
		}
		repaint();
	}

	public static void main(final String[] args) {
		JFrame frame = new JFrame("Fade out");
		frame.add(new FadeOutImage());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(myImage.getWidth(null), myImage.getHeight(null)+40);
		frame.setVisible(true);
	}
}