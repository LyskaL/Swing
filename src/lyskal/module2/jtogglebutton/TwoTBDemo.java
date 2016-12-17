package lyskal.module2.jtogglebutton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TwoTBDemo implements ItemListener {
	public static final String ON = "ON";
	public static final String OFF = "OFF";
	
	JLabel onLabel = new JLabel(ON);
	JLabel offLabel = new JLabel(OFF);
	JToggleButton onButton = new JToggleButton(ON);
	JToggleButton offButton = new JToggleButton(OFF);
	
	public TwoTBDemo(){
		JFrame jFrame = new JFrame();
		jFrame.setLayout(new GridLayout(2, 0));
		jFrame.setBounds(500, 250, 300, 120);
		jFrame.setTitle("Two Toggle Button");
		
		JPanel onPanel = new JPanel();
		onButton.setSelected(true);
		onButton.addItemListener(this);
		onPanel.add(onButton);
		onPanel.add(onLabel);
		jFrame.add(onPanel);
		
		JPanel offPanel = new JPanel();
		offButton.addItemListener(this);
		offPanel.add(offButton);
		offPanel.add(offLabel);
		jFrame.add(offPanel);
		
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setVisible(true);
	}

	public static void main(final String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new TwoTBDemo();
			}
		});
	}

	@Override
	public void itemStateChanged(final ItemEvent e) {
		JToggleButton buttonEvent = (JToggleButton) e.getItem();
		if(buttonEvent == onButton) {
			changeSelectedButton(buttonEvent, onLabel);
		} else {
			changeSelectedButton(buttonEvent, offLabel);
		}
	}
	
	private void changeSelectedButton (final JToggleButton buttonEvent, final JLabel labelButton) {
		if(buttonEvent.isSelected()){
			labelButton.setText(ON);
		} else {
			labelButton.setText(OFF);
		}
	}
}
