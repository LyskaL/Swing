package lyskal.singsofzodiac;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class Interface {
	private JFrame jFrame = getJFrame();
	private JPanel jPanel = new JPanel();
	private JTextField date = new JTextField(15);
	private final ImageIcon image = 
			new ImageIcon("src//lyskal//singsofzodiac//information//img//sings.png");

	public Interface () {
		jFrame.add(new JLabel(image));
		
		jFrame.add(jPanel);
		jPanel.setLayout(new BorderLayout());
		
		jPanel.add(new JLabel("<html><br><br>"), BorderLayout.NORTH);
		JPanel text = new JPanel();
		text.add(new JLabel("Enter your date of birth"), BorderLayout.NORTH);
		jPanel.add(text, BorderLayout.CENTER);
		
		date.setText("dd.mm.yyyy");
		text.add(date, BorderLayout.CENTER);
		
		JButton searchButton = new JButton("Search");
		searchButton.addActionListener(new ButtonAction());
		text.add(searchButton, BorderLayout.SOUTH);
	}

	public JFrame getJFrame() {
		JFrame jFrame = new JFrame();
		jFrame.setLayout(new GridLayout(1, 2));
		jFrame.setTitle("sings of zodiac");
		jFrame.setBounds(500, 200, 400, 200);
		jFrame.setResizable(false);
		jFrame.setVisible(true);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		return jFrame;
	}

	@SuppressWarnings("serial")
	class ButtonAction extends AbstractAction {
		@Override
		public void actionPerformed(final ActionEvent ae) {
			if (ae.getActionCommand().equals("Search")) {
				if(Validator.isValidDate(date.getText())) {
					//TODO если дата корректна вызвать новое окошко, 
					//куда будет вынесена информация о знаке зодиака
				} else {
					JOptionPane.showMessageDialog(jFrame, "You have entered the not correct date!",
							"Error", JOptionPane.ERROR_MESSAGE);
				}
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