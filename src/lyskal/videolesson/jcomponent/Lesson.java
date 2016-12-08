package lyskal.videolesson.jcomponent;

import java.awt.*;
import javax.swing.*;

public class Lesson {
	
	public static void main(final String[] args) {
		JFrame jFrame = getJFrame();
		jFrame.add(new MyComponent());
		
	}

	static JFrame getJFrame() {
		int width = 500;
		int height = 300;
		JFrame jFrame = new JFrame();
		jFrame.setTitle("draw...");
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension dimension = toolkit.getScreenSize();
		jFrame.setBounds(dimension.width/2-(width/2), 
						 dimension.height/2-(height/2), 
						 width, 
						 height);
		jFrame.setVisible(true);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		return jFrame;
	}
	
	@SuppressWarnings("serial")
	static class MyComponent extends JComponent{
		@Override
		protected void paintComponent(final Graphics g) {
			Font font = new Font("Arial", Font.BOLD, 16);
			Graphics2D g2 = (Graphics2D)g;
			g2.setFont(font);
			g2.drawString("I to draw the string... :)", 20, 20);
		}	
	}
}
