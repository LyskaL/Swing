package lyskal.singsofzodiac;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Interface {
	private SingsOfZodiac _sings;
	
	private JFrame jFrame = getJFrame();
	private JPanel jPanel = new JPanel();
	private JTextField date = new JTextField(10);
	private final ImageIcon image = 
			new ImageIcon("src//lyskal//singsofzodiac//information//img//sings.png");

	public Interface () {
		_sings = new SingsOfZodiac();
		
		jFrame.add(new JLabel(image));
		jFrame.add(jPanel);
		jPanel.setLayout(new BorderLayout());
		
		jPanel.add(new JLabel("<html><br><br>"), BorderLayout.NORTH);
		JPanel text = new JPanel();
		text.add(new JLabel("Enter the day and month of birth"), BorderLayout.NORTH);
		jPanel.add(text, BorderLayout.CENTER);
		
		date.setText("13.04");
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
						MyDialog dialog = new MyDialog(sing);
						dialog.setVisible(true);
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
	
	@SuppressWarnings("serial")
	class MyDialog extends JDialog {
		public MyDialog(final SingOfZodiac sing){
			super(jFrame, "Your sign", true);
			JPanel panel = new JPanel();
			add(panel);
			panel.setLayout(new GridBagLayout());
			
			panel.getRootPane().setBorder
				(BorderFactory.createEtchedBorder(HIDE_ON_CLOSE, Color.WHITE, Color.GRAY));
			
			//добавить картинку знака
			panel.add(new JLabel(sing.getImage()), new GridBagConstraints(0, 0, 1, 4, 1, 1,
					GridBagConstraints.NORTH, GridBagConstraints.BOTH, 
					new Insets(1, 1, 1, 1), 0, 0));
			
			//Добавляем имя знака (правее от фото)
			Font fontName = new Font("Georgia", Font.ITALIC, 32);
			JLabel name = new JLabel(sing.getName());
			name.setFont(fontName);
			panel.add(name, new GridBagConstraints(1, 0, 3, 1, 1, 1,
					GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, 
					new Insets(1, 1, 1, 1), 0, 0));
			//Добавляем даты знака(праве от фото и ниже имени)
			Font fontElement = new Font("Georgia", Font.ITALIC, 20);
			JLabel element = new JLabel("element: " + sing.getElement());
			element.setFont(fontElement);
			panel.add(element, new GridBagConstraints(1, 1, 3, 1, 1, 1,
					GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, 
					new Insets(1, 1, 1, 1), 0, 0));
			
			//Добавляем даты знака(праве от фото и ниже имени)
			Font fontDate = new Font("Georgia", Font.ITALIC, 20);
			JLabel date = new JLabel("date: " + sing.getDate());
			date.setFont(fontDate);
			panel.add(date, new GridBagConstraints(1, 2, 3, 1, 1, 1,
					GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, 
					new Insets(1, 1, 1, 1), 0, 0));
			
			Font fontDiscription = new Font("Georgia", Font.ITALIC, 16);
			JLabel discriptionLabel = new JLabel("discription:");
			discriptionLabel.setFont(fontElement);
			panel.add(discriptionLabel, new GridBagConstraints(1, 3, 3, 1, 1, 1,
					GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, 
					new Insets(1, 1, 1, 1), 0, 0));
			
			//Выводим описание знака
			JTextArea discription = new JTextArea(15, 10);
			discription.setFont(fontDiscription);
			discription.setBackground(jFrame.getBackground());
			discription.setText(sing.getDescription());
			discription.setLineWrap(true);
			discription.setWrapStyleWord(true);
			discription.setEditable(false);
			panel.add(new JScrollPane(discription), new GridBagConstraints(0, 4, 4, 5, 1, 1,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH, 
					new Insets(1, 1, 1, 1), 0, 0));
			
			setBounds(450, 150, 600, 500);
			setVisible(true);
		}
	}
}