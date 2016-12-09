package lyskal.videolesson.jbutton;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

import javax.swing.*;

public class ChangeColorPanel {
	static JFrame jFrame = getJFrame();
	static JPanel jPanel = new JPanel();
	static Color standart = jPanel.getBackground();
	
	static final String RED_COLOR = "red";
	static final String BLUE_COLOR = "blue";
	static final String GREEN_COLOR = "green";
	static final String YELLOW_COLOR = "yellow";
	static final String STANDART_COLOR = "standart color";

	public static void main(final String[] args) {
		JButton redButton = new JButton(new ButtonAction());
		redButton.setText(RED_COLOR);
		JButton blueButton = new JButton(new ButtonAction());
		blueButton.setText(BLUE_COLOR);
		JButton greenButton = new JButton(new ButtonAction());
		greenButton.setText(GREEN_COLOR);
		JButton yellowButton = new JButton(new ButtonAction());
		yellowButton.setText(YELLOW_COLOR);
		JButton standardColorButton = new JButton(new ButtonAction());
		standardColorButton.setText(STANDART_COLOR);
		jFrame.add(jPanel);
		jPanel.add(redButton);
		jPanel.add(greenButton);
		jPanel.add(blueButton);
		jPanel.add(yellowButton);
		jPanel.add(standardColorButton);
		
		
	}
	
	static JFrame getJFrame() {
		int width = 300;
		int height = 150;
		JFrame jFrame = new JFrame();
		jFrame.setTitle("Change color panel");
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension dimension = toolkit.getScreenSize();
		jFrame.setBounds(dimension.width/2-(width/2), 
						 dimension.height/2-(height/2), 
						 width, 
						 height);
		jFrame.setVisible(true);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		return jFrame;
	}
	
	@SuppressWarnings("serial")
	static class ButtonAction extends AbstractAction{

		@Override
		public void actionPerformed(final ActionEvent ae) {
			if(ae.getActionCommand().equals(RED_COLOR)) {
				jPanel.setBackground(Color.RED);
			} else if (ae.getActionCommand().equals(BLUE_COLOR)) {
				jPanel.setBackground(Color.BLUE);
			} else if (ae.getActionCommand().equals(GREEN_COLOR)) {
				jPanel.setBackground(Color.GREEN);
			} else if (ae.getActionCommand().equals(YELLOW_COLOR)) {
				jPanel.setBackground(Color.YELLOW);
			} else if (ae.getActionCommand().equals(STANDART_COLOR)) {
				jPanel.setBackground(standart);		
			}
		}
		
	}
}