package lyskal.videolesson.timerbasedanimation;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import javax.swing.*;

@SuppressWarnings("serial")
public class TimerBasedAnimation extends JPanel implements ActionListener {
	private Ellipse2D.Float ellipse = new Ellipse2D.Float();
	private double esize;
	private double maxSize = 0;
	private boolean initialize = true;

	Timer timer;

	ActionListener updateProBar;

	public TimerBasedAnimation() {
		setXY(20 * Math.random(), 200, 200);

		timer = new Timer(20, this);
		timer.setInitialDelay(190);
		timer.start();
	}

	public void setXY(final double size, final int w, final int h) {
		esize = size;
		ellipse.setFrame(10, 10, size, size);
	}

	public void reset(final int w, final int h) {
		maxSize = w / 10;
		setXY(maxSize * Math.random(), w, h);
	}

	public void step(final int w, final int h) {
		esize++;
		if (esize > maxSize) {
			setXY(1, w, h);
		} else {
			ellipse.setFrame(ellipse.getX(), ellipse.getY(), esize, esize);
		}
	}

	public void render(final int w, final int h, final Graphics2D g2) {
		g2.setColor(Color.BLUE);
		g2.draw(ellipse);
	}

	@Override
	public void paint(final Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, 
											   RenderingHints.VALUE_ANTIALIAS_ON);

		rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

		g2.setRenderingHints(rh);
		Dimension size = getSize();

		if (initialize) {
			reset(size.width, size.height);
			initialize = false;
		}
		this.step(size.width, size.height);
		render(size.width, size.height, g2);
	}

	@Override
	public void actionPerformed(final ActionEvent e) {
		repaint();
	}

	public static void main(final String[] args) {
		JFrame frame = new JFrame("TimerBasedAnimation");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new TimerBasedAnimation());
		frame.setSize(350, 250);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}