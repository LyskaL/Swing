package lyskal.module2.iconlabel;

import javax.swing.*;
import java.awt.*;

public class IconLabelDemo {
	private ImageIcon _myIcon;
	
	IconLabelDemo() {
		JFrame jfrm = new JFrame("My window");
		jfrm.setLayout(new GridLayout());
		jfrm.setSize(350, 300);
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		_myIcon = new ImageIcon("src//lyskal//module2//iconlabel//Icon.jpg");
		//Creates a label containing text and an image.
		JLabel jlabIconText = new JLabel("Added a photo", _myIcon, SwingConstants.LEFT);
		jfrm.add(jlabIconText);
		jfrm.setVisible(true);
	}
	
	public static void main(final String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new IconLabelDemo();
				
			}
		});
	}
}