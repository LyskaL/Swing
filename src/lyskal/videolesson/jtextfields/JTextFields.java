package lyskal.videolesson.jtextfields;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import javax.swing.*;

/**
 * Example of use of text fields.
 * 
 * @author LyskaL
 */
public class JTextFields {
	static JFrame jFrame = getJFrame();
	static JPanel jPanel = new JPanel();
	
	static final int WEIDTH_TEXT_FIELD = 17;
	static final String SAVE_BUTTON = "Save";
	static final String CLEAR_BUTTON = "Clear";
	static JTextField nameField = new JTextField(WEIDTH_TEXT_FIELD);
	static JTextField birthdayField = new JTextField(WEIDTH_TEXT_FIELD);
	static JTextField mailField = new JTextField(WEIDTH_TEXT_FIELD);
	static JLabel informationNameLabel = new JLabel("");
	static JLabel informationBirthdayLabel = new JLabel("");
	static JLabel informationMailLabel = new JLabel("");

	public static void main(final String[] args) {
		jFrame.add(jPanel);
		JLabel nameLabel = new JLabel("        Name: ");
		jPanel.add(nameLabel);
		jPanel.add(nameField);
		JLabel birthdayLabel = new JLabel("   Birthday: ");
		jPanel.add(birthdayLabel);
		jPanel.add(birthdayField);
		JLabel mailLabel = new JLabel("           Mail: ");
		jPanel.add(mailLabel);
		jPanel.add(mailField);
		JButton saveButton = new JButton(new ButtonAction());
		saveButton.setText(SAVE_BUTTON);
		saveButton.setPreferredSize(new Dimension(130, 30));
		JButton cleareButton = new JButton(new ButtonAction());
		cleareButton.setText(CLEAR_BUTTON);
		cleareButton.setPreferredSize(new Dimension(130, 30));
		jPanel.add(saveButton);
		jPanel.add(cleareButton);
		jPanel.add(informationNameLabel);
		jPanel.add(informationBirthdayLabel);
		jPanel.add(informationMailLabel);
		jPanel.revalidate();
	}

	private static JFrame getJFrame() {
		JFrame jFrame = new JFrame();
		jFrame.setBounds(500, 200, 300, 200);
		jFrame.setTitle("Text fienlds");
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setVisible(true);
		return jFrame;
	}
	
	@SuppressWarnings("serial")
	static class ButtonAction extends AbstractAction {
		@Override
		public void actionPerformed(final ActionEvent ae) {
			if(ae.getActionCommand().equals(SAVE_BUTTON)) {
				if(!nameField.getText().equals("") && 
				   !birthdayField.getText().equals("") &&
				   !mailField.getText().equals("")) {
					informationNameLabel.setText("Name: " + nameField.getText());
					informationBirthdayLabel.setText("Birthday: " + birthdayField.getText());
					informationMailLabel.setText("Mail: " + mailField.getText());
				}
			} else if (ae.getActionCommand().equals(CLEAR_BUTTON)) {
				nameField.setText("");
				birthdayField.setText("");
				mailField.setText("");
				informationNameLabel.setText("");
				informationBirthdayLabel.setText("");
				informationMailLabel.setText("");
			}
		}
	}
}