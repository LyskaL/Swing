package lyskal.singsofzodiac;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Interface {
	private SingsOfZodiac _sings;
	
	private JFrame jFrame = getJFrame();
	private JPanel jPanel = new JPanel();
	private JTextField date = new JTextField(10);
	private ImageIcon image;

	public Interface () {
		_sings = new SingsOfZodiac();
		image = new ImageIcon(getClass().getResource("res/img/sings.png"));
		
		jFrame.add(new JLabel(image));
		jFrame.add(jPanel);
		jPanel.setLayout(new BorderLayout());
		
		jPanel.add(new JLabel("<html><br><br>"), BorderLayout.NORTH);
		JPanel text = new JPanel();
		text.add(new JLabel("Enter the day and month of birth"), BorderLayout.NORTH);
		jPanel.add(text, BorderLayout.CENTER);
		
		date.setToolTipText("dd.mm");
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
					SingOfZodiac sing = _sings.getSing(date.getText());
					if(sing != null) {
						SignInformation window = new SignInformation(jFrame, sing);
						window.setVisible(true);
						return;
					}
				}
				JOptionPane.showMessageDialog(jFrame, "You have entered the not correct date!",
							"Error", JOptionPane.ERROR_MESSAGE);
				date.setText("");
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