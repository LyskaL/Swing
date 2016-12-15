package lyskal.videolesson.layout;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.*;

/**
 * Implementation of a simple example of work of the GridBagLayout.
 * 
 * @author LyskaL
 */
public class TestGridBagLayout {
	static JFrame jFrame = getJFrame();
	static JPanel jPanel = new JPanel();

	public static void main(final String[] args) {
		jFrame.add(jPanel);
		GridBagLayout gridBagLayout = new GridBagLayout();
		jPanel.setLayout(gridBagLayout);
		
		GridBagConstraints labelConstraint = new GridBagConstraints();
		labelConstraint.weightx = 0;
		labelConstraint.weighty = 0;
		labelConstraint.gridx = 0;
		labelConstraint.gridy = 0;
		labelConstraint.gridheight = 1;
		labelConstraint.gridwidth = 1;
		jPanel.add(new JLabel("Name: "), labelConstraint);
		
		GridBagConstraints textConstraint = new GridBagConstraints();
		textConstraint.weightx = 0;
		textConstraint.weighty = 0;
		textConstraint.gridx = 1;
		textConstraint.gridy = 0;
		textConstraint.gridheight = 1;
		textConstraint.gridwidth = 2;
		jPanel.add(new JTextField(13), textConstraint);
		
		GridBagConstraints saveConstraint = new GridBagConstraints();
		saveConstraint.weightx = 0;
		saveConstraint.weighty = 0;
		saveConstraint.gridx = 0;
		saveConstraint.gridy = 1;
		saveConstraint.gridheight = 1;
		saveConstraint.gridwidth = 1;
		jPanel.add(new JButton("save"), saveConstraint);
		
		GridBagConstraints searchConstraint = new GridBagConstraints();
		searchConstraint.weightx = 0;
		searchConstraint.weighty = 0;
		searchConstraint.gridx = 1;
		searchConstraint.gridy = 1;
		searchConstraint.gridheight = 1;
		searchConstraint.gridwidth = 1;
		jPanel.add(new JButton("search"), searchConstraint);
		
		GridBagConstraints removeConstraint = new GridBagConstraints();
		removeConstraint.weightx = 0;
		removeConstraint.weighty = 0;
		removeConstraint.gridx = 2;
		removeConstraint.gridy = 1;
		removeConstraint.gridheight = 1;
		removeConstraint.gridwidth = 1;
		jPanel.add(new JButton("remove"), removeConstraint);
		
		jPanel.revalidate();
	}
	
	/**
	 * Creation of window.
	 * @return JFrame
	 */
	public static JFrame getJFrame() {
		JFrame jFrame = new JFrame();
		jFrame.setBounds(500, 200, 300, 150);
		jFrame.setTitle("Text Grid Bag Layout");
		jFrame.setVisible(true);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		return jFrame;
	}
}
