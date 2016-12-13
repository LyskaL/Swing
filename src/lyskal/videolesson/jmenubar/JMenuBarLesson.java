package lyskal.videolesson.jmenubar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * To create a simple menu.
 * 
 * @author LyskaL
 */
public class JMenuBarLesson {
	private static JFrame jFrame = getJFrame();

	public static void main(final String[] args) {
		JMenuBar jMenuBar = new JMenuBar();
		JMenu file = new JMenu("File");
		JMenu edit = new JMenu("Edit"); 
		jMenuBar.add(file);
		jMenuBar.add(edit);
		
		file.add(new JMenuItem("Open"));
		file.add(new JMenuItem("Save")).setEnabled(false);
		file.addSeparator();
		JMenuItem exit = file.add(new JMenuItem("Exit"));
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent arg0) {
				System.exit(0);
			}
		});
		exit.setAccelerator(KeyStroke.getKeyStroke("ctrl E"));
		
		edit.add(new JMenuItem("Cut"));
		edit.add(new JMenuItem("Copy"));
		edit.add(new JCheckBox("format"));
		
		jFrame.setJMenuBar(jMenuBar);
		jFrame.revalidate();
	}

	private static JFrame getJFrame() {
		JFrame jFrame = new JFrame();
		jFrame.setBounds(100, 100, 300, 350);
		jFrame.setTitle("Menu");
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setVisible(true);
		return jFrame;
	}
}