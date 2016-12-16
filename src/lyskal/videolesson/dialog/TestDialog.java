package lyskal.videolesson.dialog;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class TestDialog {
	static JFrame jFrame = getJFrame();
	static JPanel jPanel = new JPanel();
	static final String[] nameButtons = new String[] {"first", "second", "third", "fourth"};
	

	public static void main(final String[] args) {
		jFrame.add(new JPanel());
		jFrame.add(jPanel);
		for (int i = 0; i < nameButtons.length; i++) {
			JButton button = new JButton(nameButtons[i]);
			button.addActionListener(new ButtonAction());
			jPanel.add(button);
		}
	}

	public static JFrame getJFrame() {
		JFrame jFrame = new JFrame();
		jFrame.setLayout(new GridLayout(3, 0));
		jFrame.setTitle("test dialog");
		jFrame.setBounds(500, 100, 300, 150);
		jFrame.setVisible(true);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		return jFrame;
	}
	
	@SuppressWarnings("serial")
	static class ButtonAction extends AbstractAction {
		@Override
		public void actionPerformed(final ActionEvent ae) {
			String message = "The "+ ae.getActionCommand()+ " button is pressed!";
			String title = ae.getActionCommand() + " dialog";
			
			if(ae.getActionCommand().equals(nameButtons[0])){
				JOptionPane.showMessageDialog(jPanel, message, title, JOptionPane.OK_OPTION);
			} else if(ae.getActionCommand().equals(nameButtons[1])){
				JOptionPane.showConfirmDialog(jPanel, message, title, JOptionPane.OK_OPTION);
			} else if(ae.getActionCommand().equals(nameButtons[2])){
				JOptionPane.showOptionDialog(jPanel, message, title, 0, 0, null, new Object[]{"Yes!", "No!"}, "Yes!");
			} else if(ae.getActionCommand().equals(nameButtons[3])) {
				JOptionPane.showInputDialog(jPanel, message, "");
			}
		}
	}
}
