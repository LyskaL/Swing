package lyskal.module2.iconlabel;

import javax.swing.*;
import java.awt.*;

public class IconLabelDemo {
	
	public static void main(final String[] args) {
		JFrame jfrm = new JFrame("My window");
		jfrm.setLayout(new GridBagLayout());
		jfrm.setSize(350, 300);
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon _myIcon = new ImageIcon("src//lyskal//module2//iconlabel//Icon.jpg");
		JLabel jlabIcon = new JLabel(_myIcon);
		JLabel jlabText = new JLabel("Added a photo", SwingConstants.CENTER);
		jfrm.add(jlabText);
		jfrm.add(jlabIcon);
		jfrm.setVisible(true);
	}
}