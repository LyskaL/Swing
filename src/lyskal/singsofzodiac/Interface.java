package lyskal.singsofzodiac;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class Interface {
	private JFrame jFrame = getJFrame();
	private JPanel jPanel = new JPanel();
	private JPanel text = new JPanel();
	private JPanel button = new JPanel();
	private JTextField dateText = new JTextField(10);

	public Interface () {
		jFrame.add(jPanel);
		jPanel.setLayout(new GridLayout(3, 1));
		text.add(new JLabel("Enter your date of birth"));
		jPanel.add(text);
		jPanel.add(dateText);
		JButton searchButton = new JButton("Search");
		searchButton.addActionListener(new ButtonAction());
		button.add(searchButton);
		jPanel.add(button);
	}

	public static JFrame getJFrame() {
		JFrame jFrame = new JFrame();
		jFrame.setTitle("sings of zodiac");
		jFrame.setBounds(500, 200, 300, 135);
		jFrame.setVisible(true);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		return jFrame;
	}

	@SuppressWarnings("serial")
	class ButtonAction extends AbstractAction {
		@Override
		public void actionPerformed(final ActionEvent ae) {
			if (ae.getActionCommand().equals("Search")) {
				jFrame.setTitle("вот и я ");
			}
		}
	}
	
	public static void main(final String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Interface();
			}
		});
	}
}