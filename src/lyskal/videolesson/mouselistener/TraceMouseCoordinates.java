package lyskal.videolesson.mouselistener;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

/**
 * To determine mouse coordinates, to display in a title.
 * 
 * @author LyskaL
 */
public class TraceMouseCoordinates {
	static JFrame jFrame = getFrame();

	public static void main(final String[] args) {
		jFrame.addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseMoved(final MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
				jFrame.setTitle("X: " + x + " Y: " + y);
			}
		});
	}
	
	public static JFrame getFrame() {
		int width = 300;
		int height = 200;
		JFrame jFrame = new JFrame();
		jFrame.setTitle("x: ... y: ...");
		//To get expansion of the screen.
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension dimension = toolkit.getScreenSize();
		//To display a window on the middle.
		jFrame.setBounds(dimension.width/2-(width/2), 
				 dimension.height/2-(height/2), 
				 width, 
				 height);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setVisible(true);
		return jFrame;
	}
}