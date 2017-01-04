package lyskal.module3.JProgressBar;

import javax.swing.*;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		
		JPanel bars = new JPanel();
		bars.add(_horizontalBar);
		bars.add(_verticalBar);
		_panel.setLayout(new GridLayout(3, 1));
		_panel.add(bars);
		//_panel.add(_verticalBar);
		JPanel labels = new JPanel(new GridLayout(2, 1));
		labels.add(_horizontalLabel);
		labels.add(_verticalLabel);
		_panel.add(labels);
		//_panel.add(_verticalLabel);
		JPanel buttons = new JPanel();
		buttons.add(_pushButton);
		
		_panel.add(_pushButton);
	}
	
	private void getFrame() {
		_frame = new JFrame("Progress Bar");
		_frame.setBounds(500, 150, 350, 400);
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