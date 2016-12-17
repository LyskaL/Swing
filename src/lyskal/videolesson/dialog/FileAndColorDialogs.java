package lyskal.videolesson.dialog;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class FileAndColorDialogs {
	static JFrame jFrame = getJFrame();
	static JPanel filePanel = new JPanel();
	
	
	public static void main(final String[] args) {
		filePanel.setLayout(new GridLayout(3, 0));
		JPanel namePanel = new JPanel();
		namePanel.add(new JLabel("Name:     "));
		namePanel.add(new JTextField(10));
		filePanel.add(namePanel);
		JPanel bithdayPanel = new JPanel();
		bithdayPanel.add(new JLabel("Birthday: "));
		bithdayPanel.add(new JTextField(10));
		filePanel.add(bithdayPanel);
		JButton showDialog = new JButton("save");
		showDialog.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent ae) {
				JFileChooser file = new JFileChooser();
				file.showSaveDialog(filePanel);
			}
		});
		filePanel.add(showDialog);
		filePanel.revalidate();
		jFrame.add(filePanel);
		
	}
	
	
	public static JFrame getJFrame() {
		JFrame jFrame = new JFrame();
		jFrame.setLayout(new GridLayout(2, 0));
		jFrame.setTitle("File & Color dialogs");
		jFrame.setBounds(500, 100, 300, 300);
		jFrame.setVisible(true);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		return jFrame;
	}
}
