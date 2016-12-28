package lyskal.movefigure;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import javax.swing.*;

@SuppressWarnings("serial")
public class PrintFigure extends JPanel {
	private int _x;
	private int _y;
	
	public PrintFigure(final int x, final int y) {
		_x = x;
		_y = y;
	}

    @Override
    public void paintComponent(final Graphics g) {
    	super.paintComponent(getGraphics());
        Graphics2D g2 = (Graphics2D) g;
		Ellipse2D ellipse = new Ellipse2D.Double(_x, _y, 50, 50);
		g2.setColor(Color.RED);
		g2.fill(ellipse);
		revalidate();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(486, 300);
    }
    
    public void setX(final int x) {
		_x = x;
	}

	public void setY(final int y) {
		_y = y;
	}
}