package lyskal.module4.jtabbedpane;

import javax.swing.*;

public class TabbedPaneDemo {
	
	public TabbedPaneDemo() {
		JFrame frame = getFrame();
		JTabbedPane tabbed = new JTabbedPane();
		tabbed.addTab("File", new JLabel("This is File Manager tab.", SwingUtilities.CENTER));
		tabbed.addTab("Performance", new JLabel("This is Performance tab.", SwingUtilities.CENTER));
		tabbed.addTab("Reports", new JLabel("This is Reports tab.", SwingUtilities.CENTER));
		tabbed.addTab("Customize", new JLabel("This is Customize tab.", SwingUtilities.CENTER));
		frame.add(tabbed);
	}

	private JFrame getFrame() {
		JFrame frame = new JFrame("Tabbed Pane");
		frame.setBounds(500, 150, 400, 250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		return frame;
	}

	public static void main(final String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new TabbedPaneDemo();
			}
		});
	}
}
