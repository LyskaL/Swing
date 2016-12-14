package lyskal.videolesson.layout;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class TestLayout {
	static JFrame jFrame = getJFrame();
	static JPanel jPanel = new JPanel();
	static JPanel text = new JPanel();
	static JPanel buttons = new JPanel();
	
	public static void main(final String[] args) {
		jFrame.add(jPanel);
		jPanel.setLayout(new GridLayout(2, 0));
		jPanel.add(text);
		buttons.setLayout(new GridLayout(4, 4));
		//createAndAddedButtons(buttons);
		jPanel.add(buttons);
	}

	public static JFrame getJFrame() {
		JFrame jFrame = new JFrame();
		jFrame.setBounds(500, 200, 300, 250);
		jFrame.setVisible(true);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		return jFrame;
	}
	
}