package lyskal.videolesson.layout;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.*;

/**
 * Implementation of the simple calculator.
 * 
 * @author LyskaL
 */
public class Calculator {
	static JFrame jFrame = getJFrame();
	static JPanel jPanel = new JPanel();
	static JLabel text = new JLabel("");
	static JPanel buttons = new JPanel();

	static final String PLUS = "+";
	static final String MINUS = "-";
	static final String MULTIPLY = "*";
	static final String DIVISION = "/";
	static final String EQUALS = "=";
	
	static final String[] buttonsName = new String[] {"7", "8", "9", DIVISION, 
													  "4", "5", "6", MULTIPLY, 
													  "1", "2", "3", MINUS,
													  "0", ".", EQUALS, PLUS};

	public static void main(final String[] args) {
		jFrame.add(jPanel);
		jPanel.setLayout(new GridLayout(2, 0));
		jPanel.add(text);
		Font font = new Font("Arial", Font.BOLD, 30);
		text.setFont(font);
		buttons.setLayout(new GridLayout(4, 4));
		createAndAddedButtons(buttons);
		jPanel.add(buttons);
	}
	
	/**
	 * Creation of window.
	 * @return JFrame
	 */
	public static JFrame getJFrame() {
		JFrame jFrame = new JFrame();
		jFrame.setBounds(500, 200, 300, 250);
		jFrame.setVisible(true);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		return jFrame;
	}
	
	/**
	 * Processing of event pressing of the button.
	 */
	@SuppressWarnings("serial")
	static class ButtonAction extends AbstractAction {
		@Override
		public void actionPerformed(final ActionEvent ae) {
			displayNewText(ae.getActionCommand());
		}
	}
	
	/**
	 * Form a new string, and to display on the panel.
	 * 
	 * @param newChar - symbol from the pressed button.
	 */
	public static void displayNewText(final String newChar) {
		StringBuilder textLabel = new StringBuilder(text.getText());
		if (EQUALS.equals(newChar)) {
			text.setText("");
			return;
		}
		String lastChar = "";
		lastChar = (textLabel.length() == 0) ? "" : ""+textLabel.charAt(textLabel.length()-1);
		
		if (!isValidString(lastChar, newChar)) {
			return;
		}
		textLabel.append(newChar);
		text.setText(textLabel.toString());
	}
	
	/**
	 * Create buttons from 0 to 9 and buttons of mathematical symbols.
	 * Add them on the panel.
	 * 
	 * @param buttons - panel on which we will arrange buttons. 
	 */
	static void createAndAddedButtons(final JPanel buttons) {
		for (int i = 0; i < buttonsName.length; i++) {
			JButton button = new JButton(buttonsName[i]);
			button.addActionListener(new ButtonAction());
			buttons.add(button);
		}
	}
	
	/**
	 * The method checks whether we can add a new symbol on our panel.
	 * 
	 * @param lastChar - last symbol on our panel.
	 * @param newChar - symbol from the pressed button
	 * @return
	 * false - if by the first has pressed the button is minus, plus, multiply or division.
	 * false - if the new symbol and the last is minus, plus, multiply or division.
	 * true - if the new symbol can be added to line on the panel.
	 */
	public static boolean isValidString(final String lastChar, final String newChar) {
		boolean isLastCharDigit = false;
		boolean isNewCharDigit = false;
		if ((MINUS.equals(lastChar) || PLUS.equals(lastChar) || 
			MULTIPLY.equals(lastChar) || DIVISION.equals(lastChar))) {
			isLastCharDigit = true;;
		} 
		if (MINUS.equals(newChar) || PLUS.equals(newChar) || 
			MULTIPLY.equals(newChar) || DIVISION.equals(newChar)) {
			isNewCharDigit = true;
		}
		if ((isLastCharDigit && isNewCharDigit) || (lastChar.equals("") && isNewCharDigit)) {
			return false;
		} 
		return true;
	}
}