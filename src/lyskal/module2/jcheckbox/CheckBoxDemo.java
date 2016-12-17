package lyskal.module2.jcheckbox;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CheckBoxDemo implements ItemListener {
	JFrame jFrame = new JFrame();
	JLabel optionsLabel = new JLabel("Options:");
	JLabel whatLabel = new JLabel("");
	JLabel changeLabel = new JLabel("Options selected: ");
	
	JCheckBox options = new JCheckBox("Enable Options");
	JCheckBox speed = new JCheckBox("Maximize Speed");
	JCheckBox size = new JCheckBox("Minimize Size");
	JCheckBox debug = new JCheckBox("Debug");
	
	public CheckBoxDemo() {
		jFrame.setLayout(new GridLayout(7, 1));
		jFrame.setBounds(500, 250, 350, 200);
		jFrame.setTitle("Demostrate Chack Box");
		
		optionCheckBoxes();
		
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
	
	private void optionCheckBoxes() {
		speed.setEnabled(false);
		size.setEnabled(false);
		debug.setEnabled(false);
		options.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(final ItemEvent arg0) {
				if(options.isSelected()) {
					speed.setEnabled(true);
					size.setEnabled(true);
					debug.setEnabled(true);
				} else {
					speed.setEnabled(false);
					size.setEnabled(false);
					debug.setEnabled(false);
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
				new CheckBoxDemo();
			}
		});
	}

	@Override
	public void itemStateChanged(final ItemEvent e) {
		StringBuilder temp = new StringBuilder("");
		JCheckBox checkBoxEvent = (JCheckBox) e.getItem();
		if(e.getStateChange() == ItemEvent.SELECTED) {
			changeLabel.setText("Selection change: " + checkBoxEvent.getText() + " selected.");
		} else {
			changeLabel.setText("Selection change: " + checkBoxEvent.getText() + " cleared.");
		}
		
		if(speed.isSelected()){
			temp.append("Speed ");
		}
		if(size.isSelected()){
			temp.append("Size ");
		}
		if(debug.isSelected()){
			temp.append("Debug ");
		}
		
		whatLabel.setText("Selected optiopns: " + temp.toString());
	}
}