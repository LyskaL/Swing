package lyskal.videolesson.keystroke;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class ChandeColorAfterKeyStroke {
	static JFrame jFrame = getJFrame();
	static JPanel jPanel = new JPanel();
	static Color standart = jPanel.getBackground();
	
	static final String RED_COLOR = "red";
	static final String STANDART_COLOR = "standart color";

	public static void main(final String[] args) {
		JButton redButton = new JButton(new ButtonAction());
		redButton.setText(RED_COLOR);
		JButton standardColorButton = new JButton(new ButtonAction());
		standardColorButton.setText(STANDART_COLOR);
		jFrame.add(jPanel);
		jPanel.add(redButton);
		jPanel.add(standardColorButton);
		
		KeyStroke blackColor = KeyStroke.getKeyStroke("ctrl B");
		InputMap inputMap = jPanel.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
		inputMap.put(blackColor, "Black color");
		ActionMap actionMap = jPanel.getActionMap();
		actionMap.put("Black color", new ButtonAction());
	}
	
	static JFrame getJFrame() {
		int width = 300;
		int height = 200;
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
			if(ae.getActionCommand().equals(RED_COLOR)){
				jPanel.setBackground(Color.RED);
				return;
			} else if(ae.getActionCommand().equals(STANDART_COLOR)) {
				jPanel.setBackground(standart);
				return;
			}
			jPanel.setBackground(Color.BLACK);
		}
		
	}
}