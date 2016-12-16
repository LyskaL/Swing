package lyskal.videolesson.dialog;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class OurDialog {
	static JFrame jFrame = getJFrame();

	public static void main(final String[] args) {
		jFrame.add(new JPanel());
		JButton showDialog = new JButton("show dialog");
		showDialog.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent arg0) {
				MyDialog dialog = new MyDialog();
				dialog.setVisible(true);
			}
		});
		jFrame.add(showDialog);
	}
	
	@SuppressWarnings("serial")
	static class MyDialog extends JDialog {
		public MyDialog(){
			super(jFrame, "My dialog", true);
			JPanel panel = new JPanel();
			jFrame.add(panel);
			JButton ok = new JButton("OK");
			ok.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(final ActionEvent arg0) {
					setVisible(false);
				}
			});
			Font font = new Font("Arial", 0, 16);
			JLabel text = new JLabel("This is our dialog!");
			text.setFont(font);
			add(text, BorderLayout.CENTER);
			add(ok, BorderLayout.SOUTH);
			setBounds(550, 100, 250, 120);
			setVisible(true);
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
}