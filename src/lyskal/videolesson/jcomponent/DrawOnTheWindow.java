package lyskal.videolesson.jcomponent;

import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class DrawOnTheWindow {
		
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
		
		static class MyComponent extends JComponent{
			@Override
			protected void paintComponent(final Graphics g) {
				Graphics2D g2 = (Graphics2D)g;
				Font font = new Font("Arial", Font.BOLD, 16);
				g2.setFont(font);
				g2.drawString("To draw on the window...", 150, 25);
				Point2D p1 = new Point.Double(280, 70);
				Point2D p2 = new Point.Double(380, 170);
				
				Ellipse2D el = new Ellipse2D.Double();
				el.setFrameFromDiagonal(p1, p2);
				g2.setPaint(Color.blue);
				g2.draw(el);
				
				Line2D line = new Line2D.Double(p1, p2);
				g2.setPaint(Color.red);
				g2.draw(line);
				
				Rectangle2D rectangle = new Rectangle2D.Double();
				rectangle.setFrameFromDiagonal(p1, p2);
				g2.setPaint(Color.black);
				g2.draw(rectangle);
				
				Image image = new ImageIcon("src\\lyskal\\videolesson\\jcomponent\\java.png").getImage();
				g2.drawImage(image, 0, 10, null);
				
			}	
		}
	}