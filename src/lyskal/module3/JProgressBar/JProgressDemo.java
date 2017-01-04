package lyskal.module3.JProgressBar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JProgressDemo {
	private JFrame _frame;
	private JPanel _panel = new JPanel();
	
	private JLabel _horizontalLabel;
	private JLabel _verticalLabel;
	
	private JProgressBar _horizontalBar;
	private JProgressBar _verticalBar;
	
	private JButton _pushButton = new JButton("Push me");
	private JButton _cleanButton = new JButton("Clean");
	
	public JProgressDemo() {
		getFrame();
		_frame.add(_panel);
		
		_horizontalBar = new JProgressBar();
		_verticalBar = new JProgressBar(JProgressBar.VERTICAL);
		
		_horizontalLabel = new JLabel("Value of horizontal: " + _horizontalBar.getValue());
		_verticalLabel = new JLabel("Value of vertical: " + _verticalBar.getValue());
		
		_pushButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				int horizontalValue = _horizontalBar.getValue();
				int verticalValue = _verticalBar.getValue();
				
				if(horizontalValue >= _horizontalBar.getMaximum() || 
						verticalValue >= _verticalBar.getMaximum()) {
					return;
				} else {
					_horizontalBar.setValue(horizontalValue + 10);
					_verticalBar.setValue(verticalValue + 10);
				}
				
				_horizontalLabel.setText("Value of horizontal: " + _horizontalBar.getValue());
				_verticalLabel.setText("Value of vertical: " + _verticalBar.getValue());
			}
		});
		
		_cleanButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				_horizontalBar.setValue(0);
				_verticalBar.setValue(0);
				_horizontalLabel.setText("Value of horizontal: 0");
				_verticalLabel.setText("Value of vertical: 0");
			}
		});
		
		JPanel bars = new JPanel();
		bars.add(_horizontalBar);
		bars.add(_verticalBar);
		_panel.setLayout(new GridBagLayout());
		_panel.add(bars, new GridBagConstraints(0, 0, 5, 5, 1, 1,
				GridBagConstraints.NORTH, GridBagConstraints.BOTH, 
				new Insets(1, 1, 1, 1), 0, 0));
		
		JPanel labels = new JPanel(new GridLayout(2, 1));
		labels.add(_horizontalLabel);
		labels.add(_verticalLabel);
		_panel.add(labels, new GridBagConstraints(2, 5, 3, 2, 1, 1,
				GridBagConstraints.NORTH, GridBagConstraints.NONE, 
				new Insets(1, 1, 1, 1), 0, 0));
		
		_panel.add(_pushButton, new GridBagConstraints(2, 7, 3, 1, 1, 1,
				GridBagConstraints.CENTER, GridBagConstraints.NONE, 
				new Insets(1, 1, 1, 1), 0, 0));
		_panel.add(_cleanButton, new GridBagConstraints(2, 8, 3, 1, 1, 1,
				GridBagConstraints.CENTER, GridBagConstraints.NONE, 
				new Insets(1, 1, 1, 1), 0, 0));
	}
	
	private void getFrame() {
		_frame = new JFrame("Progress Bar");
		_frame.setBounds(500, 150, 300, 300);
		_frame.setVisible(true);
		_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(final String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new JProgressDemo();
			}
		});
	}
}