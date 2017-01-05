package lyskal.module3;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 * Write a program containing a linear regulator 
 * and a scroll bar, interacting with each other.
 * 
 * @author LyskaL
 */
public class Regulators {
	private JSlider slider;
	private JProgressBar progress;
	
	public Regulators() {
		JFrame frame = getFrame();
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		panel.setBorder(BorderFactory.createEtchedBorder());
		frame.add(panel);
		setupRegulators(panel);
	}
	
	private void setupRegulators(final JPanel panel) {
		slider = new JSlider();
		slider.setMajorTickSpacing(10);
		slider.setMinorTickSpacing(5);
		slider.setSnapToTicks(true);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		Font font = new Font("Arial", Font.ITALIC, 9);
		slider.setFont(font);
		
		progress = new JProgressBar();
		progress.setValue(slider.getValue());
		progress.setStringPainted(true);
		
		panel.add(slider, new GridBagConstraints(0, 1, 5, 1, 1, 1,
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 
				new Insets(1, 1, 1, 1), 0, 0));
		panel.add(progress, new GridBagConstraints(0, 2, 5, 1, 1, 1,
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 
				new Insets(1, 1, 1, 1), 0, 0));
		
		slider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(final ChangeEvent e) {
				progress.setValue(slider.getValue());
			}
		});
	}
	
	
	private JFrame getFrame() {
		JFrame frame = new JFrame();
		//frame.setLayout(new FlowLayout());
		frame.setBounds(500, 200, 300, 200);
		frame.setTitle("Regulators");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		return frame;
	}


	public static void main(final String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Regulators();
			}
		});
	}

}
