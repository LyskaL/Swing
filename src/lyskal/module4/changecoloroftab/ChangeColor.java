package lyskal.module4.changecoloroftab;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ChangeColor {
	private JTabbedPane _tabbed;

	private JPanel _colorPanel;
	private JPanel _changeColorPanel = new JPanel();

	private final String MIN_TEXT = "Your choice: ";
	private JLabel _textChoice = new JLabel(MIN_TEXT + "Standard");

	final Color _standard;

	public ChangeColor() {
		JFrame frame = getFrame();
		_standard = frame.getBackground();
		setupRadioButtons();
		_changeColorPanel.add(_textChoice, SwingUtilities.CENTER);

		_tabbed = new JTabbedPane();
		_tabbed.addTab("Color", _colorPanel);
		_tabbed.addTab("Сhange color", _changeColorPanel);
		frame.add(_tabbed);
	}

	private void setupRadioButtons() {
		_colorPanel = new JPanel(new GridLayout(5, 1));
		JRadioButton red = new JRadioButton("red");
		JRadioButton green = new JRadioButton("green");
		JRadioButton gray = new JRadioButton("gray");
		JRadioButton yellow = new JRadioButton("yellow");
		JRadioButton standard = new JRadioButton("standard");

		red.addItemListener(new ActionButton());
		green.addItemListener(new ActionButton());
		gray.addItemListener(new ActionButton());
		yellow.addItemListener(new ActionButton());
		standard.addItemListener(new ActionButton());
		standard.setSelected(true);

		ButtonGroup group = new ButtonGroup();
		group.add(red);
		group.add(green);
		group.add(gray);
		group.add(yellow);
		group.add(standard);

		_colorPanel.add(red);
		_colorPanel.add(green);
		_colorPanel.add(gray);
		_colorPanel.add(yellow);
		_colorPanel.add(standard);
	}

	private JFrame getFrame() {
		JFrame frame = new JFrame("Change the color of tab");
		frame.setBounds(500, 150, 400, 250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		return frame;
	}

	class ActionButton implements ItemListener {
		@Override
		public void itemStateChanged(final ItemEvent e) {
			if (((JRadioButton) e.getItem()).getText().equals("red")) {
				_textChoice.setText(MIN_TEXT + "Red");
				_changeColorPanel.setBackground(Color.RED);
			} else if (((JRadioButton) e.getItem()).getText().equals("green")) {
				_textChoice.setText(MIN_TEXT + "Green");
				_changeColorPanel.setBackground(Color.GREEN);
			} else if (((JRadioButton) e.getItem()).getText().equals("gray")) {
				_textChoice.setText(MIN_TEXT + "Gray");
				_changeColorPanel.setBackground(Color.GRAY);
			} else if (((JRadioButton) e.getItem()).getText().equals("yellow")) {
				_textChoice.setText(MIN_TEXT + "Yellow");
				_changeColorPanel.setBackground(Color.YELLOW);
			} else {
				_textChoice.setText(MIN_TEXT + "Standard");
				_changeColorPanel.setBackground(_standard);
			}
		}
	}

	public static void main(final String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new ChangeColor();
			}
		});
	}
}