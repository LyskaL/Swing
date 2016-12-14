package lyskal.videolesson.layout;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class TestLayout {
	static JFrame jFrame = getJFrame();
	static JPanel jPanel = new JPanel();
	static JPanel text = new JPanel();
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
		JButton equals = new JButton(EQUALS);
		equals.addActionListener(new ButtonAction());
		JButton plus = new JButton(PLUS);
		plus.addActionListener(new ButtonAction());
		
		buttons.add(zero);
		buttons.add(point);
		buttons.add(equals);
		buttons.add(plus);
	}
}