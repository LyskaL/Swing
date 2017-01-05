package lyskal.module3.JPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelDemo {
	private JLabel _labelButtons = new JLabel("No pressed");
	private JButton _start = new JButton("Start");
	private JButton _stop = new JButton("Stop");
	
	public PanelDemo() {
		JFrame frame = getFrame();
		
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setPreferredSize(new Dimension(100,100));
		buttonsPanel.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		frame.add(buttonsPanel);
		
		_start.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				_labelButtons.setText("\"Start\" pressed");
			}
		});
		_stop.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				_labelButtons.setText("\"Stop\" pressed");
			}
		});
		
		buttonsPanel.add(_start);
		buttonsPanel.add(_stop);
		buttonsPanel.add(_labelButtons);
		
		JPanel labelsPanel = new JPanel();
		labelsPanel.setPreferredSize(new Dimension(100, 50));
		labelsPanel.setBorder(BorderFactory.createLineBorder(Color.RED));
		frame.add(labelsPanel);
		
		labelsPanel.add(new JLabel("One"));
		labelsPanel.add(new JLabel("Two"));
		labelsPanel.add(new JLabel("Three"));
	}
	
	
	private JFrame getFrame() {
		JFrame frame = new JFrame("Use Two Panels");
		frame.setLayout(new FlowLayout());
		frame.setBounds(500, 200, 200, 250);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		return frame;
	}
	
	public static void main(final String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new PanelDemo();
			}
		});
	}

}
