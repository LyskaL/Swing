package lyskal.module3.JProgressBar;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JProgressIndeterminateDemo {
	private JFrame _frame;
	private JPanel _panel = new JPanel();
	
	private JProgressBar _horizontalBar;
	private JProgressBar _verticalBar;
	private JButton _startButton;
	private JButton _stopButton;
	
	public JProgressIndeterminateDemo() {
		getFrame();
		_frame.add(_panel);
		
		_horizontalBar = new JProgressBar();
		_verticalBar = new JProgressBar(JProgressBar.VERTICAL);
		
		_horizontalBar.setIndeterminate(true);
		_verticalBar.setIndeterminate(true);
		
		setupButtons();
		_panel.setLayout(new GridBagLayout());
		JPanel bars = new JPanel();
		bars.add(_horizontalBar);
		bars.add(_verticalBar);
		_panel.add(bars, new GridBagConstraints(0, 0, 5, 5, 1, 1,
				GridBagConstraints.NORTH, GridBagConstraints.BOTH, 
				new Insets(1, 1, 1, 1), 0, 0));
		_panel.add(_startButton, new GridBagConstraints(2, 5, 3, 1, 1, 1,
				GridBagConstraints.CENTER, GridBagConstraints.NONE, 
				new Insets(1, 1, 1, 1), 0, 0));
		_panel.add(_stopButton, new GridBagConstraints(2, 6, 3, 1, 1, 1,
				GridBagConstraints.CENTER, GridBagConstraints.NONE, 
				new Insets(1, 1, 1, 1), 0, 0));
	}
	
	private void setupButtons() {
		_startButton = new JButton("Start");
		_stopButton = new JButton("Stop");
		
		_startButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				if(!_horizontalBar.isIndeterminate() || !_verticalBar.isIndeterminate()) {
				_horizontalBar.setIndeterminate(true);
				_verticalBar.setIndeterminate(true);
				}
			}
		});
		
		_stopButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				if(_horizontalBar.isIndeterminate() || _verticalBar.isIndeterminate()) {
					_horizontalBar.setIndeterminate(false);
					_verticalBar.setIndeterminate(false);
				}
			}
		});
	}
	
	private void getFrame() {
		_frame = new JFrame("Progress Bar Interminate");
		_frame.setBounds(500, 150, 300, 280);
		_frame.setVisible(true);
		_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(final String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new JProgressIndeterminateDemo();
			}
		});
	}
}