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
	 * 
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
	 * Create buttons from 0 to 10 and buttons of mathematical symbols.
	 * Add them on the panel.
	 * 
	 * @param buttons - panel on which we will arrange buttons. 
	 */
	static void createAndAddedButtons(final JPanel buttons) {
		JButton seven = new JButton("7");
		seven.addActionListener(new ButtonAction());
		JButton eight = new JButton("8");
		eight.addActionListener(new ButtonAction());
		JButton nine = new JButton("9");
		nine.addActionListener(new ButtonAction());
		JButton division = new JButton(DIVISION);
		division.addActionListener(new ButtonAction());

		buttons.add(seven);
		buttons.add(eight);
		buttons.add(nine);
		buttons.add(division);

		JButton four = new JButton("4");
		four.addActionListener(new ButtonAction());
		JButton five = new JButton("5");
		five.addActionListener(new ButtonAction());
		JButton six = new JButton("6");
		six.addActionListener(new ButtonAction());
		JButton multiply = new JButton(MULTIPLY);
		multiply.addActionListener(new ButtonAction());

		buttons.add(four);
		buttons.add(five);
		buttons.add(six);
		buttons.add(multiply);

		JButton one = new JButton("1");
		one.addActionListener(new ButtonAction());
		JButton two = new JButton("2");
		two.addActionListener(new ButtonAction());
		JButton three = new JButton("3");
		three.addActionListener(new ButtonAction());
		JButton minus = new JButton(MINUS);
		minus.addActionListener(new ButtonAction());

		buttons.add(one);
		buttons.add(two);
		buttons.add(three);
		buttons.add(minus);

		JButton zero = new JButton("0");
		zero.addActionListener(new ButtonAction());
		JButton point = new JButton(".");
		point.addActionListener(new ButtonAction());
		point.setEnabled(false);
		JButton equals = new JButton(EQUALS);
		equals.addActionListener(new ButtonAction());
		JButton plus = new JButton(PLUS);
		plus.addActionListener(new ButtonAction());
		
		buttons.add(zero);
		buttons.add(point);
		buttons.add(equals);
		buttons.add(plus);
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