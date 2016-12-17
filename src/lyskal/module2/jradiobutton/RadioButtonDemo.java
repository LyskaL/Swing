package lyskal.module2.jradiobutton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RadioButtonDemo implements ItemListener {
		JFrame jFrame = new JFrame();
		JLabel optionsLabel = new JLabel("Choose options:");
		JLabel whatLabel = new JLabel("");
		JLabel changeLabel = new JLabel("Options selected: ");
		
		JCheckBox options = new JCheckBox("Enable Options");
		JRadioButton speed = new JRadioButton("Maximize Speed");
		JRadioButton size = new JRadioButton("Minimize Size");
		JRadioButton debug = new JRadioButton("Debug");
		
		public RadioButtonDemo() {
			jFrame.setLayout(new GridLayout(7, 1));
			jFrame.setBounds(500, 250, 350, 200);
			jFrame.setTitle("Demostrate Chack Box");
			
			setupButtons();
			
			jFrame.add(options);
			jFrame.add(optionsLabel);
			jFrame.add(speed);
			jFrame.add(size);
			jFrame.add(debug);
			jFrame.add(changeLabel);
			jFrame.add(whatLabel);
			
			jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			jFrame.setVisible(true);
		}
		
		private void setupButtons() {
			ButtonGroup group = new ButtonGroup();
			group.add(speed);
			group.add(size);
			group.add(debug);
			
			speed.setEnabled(false);
			size.setEnabled(false);
			debug.setEnabled(false);
			
			options.addItemListener(new ItemListener() {
				@Override
				public void itemStateChanged(final ItemEvent e) {
					if(options.isSelected()) {
						speed.setEnabled(true);
						size.setEnabled(true);
						debug.setEnabled(true);
					} else {
						speed.setEnabled(false);
						size.setEnabled(false);
						debug.setEnabled(false);
						group.clearSelection();
						changeLabel.setText("Options selected: ");
						whatLabel.setText("");
					}
				}
			});
			speed.addItemListener(this);
			size.addItemListener(this);
			debug.addItemListener(this);
		}
		
		public static void main(final String[] args) {
			SwingUtilities.invokeLater(new Runnable() {	
				@Override
				public void run() {
					new RadioButtonDemo();
				}
			});
		}

		@Override
		public void itemStateChanged(final ItemEvent e) {
			StringBuilder temp = new StringBuilder("");
			JRadioButton checkBoxEvent = (JRadioButton) e.getItem();
			if(e.getStateChange() == ItemEvent.SELECTED) {
				changeLabel.setText("Selection change: " + checkBoxEvent.getText() + " selected.");
			} else {
				changeLabel.setText("Selection change: " + checkBoxEvent.getText() + " cleared.");
			}
			
			if(speed.isSelected()) {
				temp.append("Speed");
			} else if (size.isSelected()) {
				temp.append("Size");
			} else if(debug.isSelected()) {
				temp.append("Debug");
			}
			
			whatLabel.setText("Selected optiopns: " + temp.toString());
		}
	}