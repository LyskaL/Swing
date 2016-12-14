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
			if(ae.getActionCommand().equals("=")) {
				jFrame.setTitle("");
			} else {
				StringBuilder text = new StringBuilder(jFrame.getTitle());
				text.append(ae.getActionCommand());
				jFrame.setTitle(text.toString());
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
		JButton button2 = new JButton("/");
		button2.addActionListener(new ButtonAction());
		
		buttons.add(seven);
		buttons.add(eight);
		buttons.add(nine);
		buttons.add(button2);
		
		JButton four = new JButton("4");
		four.addActionListener(new ButtonAction());
		JButton five = new JButton("5");
		five.addActionListener(new ButtonAction());
		JButton six = new JButton("6");
		six.addActionListener(new ButtonAction());
		JButton button1 = new JButton("*");
		button1.addActionListener(new ButtonAction());

		buttons.add(four);
		buttons.add(five);
		buttons.add(six);
		buttons.add(button1);
		
		JButton one = new JButton("1");
		one.addActionListener(new ButtonAction());
		JButton two = new JButton("2");
		two.addActionListener(new ButtonAction());
		JButton three = new JButton("3");
		three.addActionListener(new ButtonAction());
		JButton minus = new JButton("-");
		minus.addActionListener(new ButtonAction());

		buttons.add(one);
		buttons.add(two);
		buttons.add(three);
		buttons.add(minus);
		
		JButton zero = new JButton("0");
		zero.addActionListener(new ButtonAction());
		JButton point = new JButton(".");
		point.addActionListener(new ButtonAction());
		JButton equals = new JButton("=");
		equals.addActionListener(new ButtonAction());
		JButton plus = new JButton("+");
		plus.addActionListener(new ButtonAction());
		
		buttons.add(zero);
		buttons.add(point);
		buttons.add(equals);
		buttons.add(plus);
	}
}