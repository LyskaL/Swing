package lyskal.videolesson.layout;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class TestLayout {
	static JFrame jFrame = getJFrame();
	static JPanel jPanel = new JPanel();
	static JPanel text = new JPanel();
	static JPanel buttons = new JPanel();

	static final String EQUALS = "=";
	
	static final String[] buttonsName = new String[] {"7", "8", "9", "/", 
			  										  "4", "5", "6", "*", 
			  										  "1", "2", "3", "-",
			  										  "0", ".", EQUALS, "+"};

	public static void main(final String[] args) {
		jFrame.add(jPanel);
		jPanel.setLayout(new GridLayout(2, 0));
		jPanel.add(text);
		buttons.setLayout(new GridLayout(4, 4));
		createAndAddedButtons(buttons);
		jPanel.add(buttons);
	}

	public static JFrame getJFrame() {
		JFrame jFrame = new JFrame();
		jFrame.setBounds(500, 200, 300, 250);
		jFrame.setVisible(true);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		return jFrame;
	}

	@SuppressWarnings("serial")
	static class ButtonAction extends AbstractAction {
		@Override
		public void actionPerformed(final ActionEvent ae) {
			if (ae.getActionCommand().equals(EQUALS)) {
				jFrame.setTitle("");
			} else {
				StringBuilder textTitle = new StringBuilder(jFrame.getTitle());
				textTitle.append(ae.getActionCommand());
				jFrame.setTitle(textTitle.toString());
			}
		}
	}
	
	static void createAndAddedButtons(final JPanel buttons) {
		for (int i = 0; i < buttonsName.length; i++) {
			JButton button = new JButton(buttonsName[i]);
			button.addActionListener(new ButtonAction());
			buttons.add(button);
		}
	}
}