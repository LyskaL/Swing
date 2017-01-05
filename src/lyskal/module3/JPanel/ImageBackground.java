package lyskal.module3.JPanel;

import java.awt.*;
import javax.swing.*;

public class ImageBackground {
	private JFrame _frame;
	private JPanel _panel = new MyComponent();

	public ImageBackground() {
		getFrame();
		_frame.add(_panel);
		_panel.setLayout(new BorderLayout());
		JButton click = new JButton("Click me!");
		JPanel flowPanel = new JPanel(new FlowLayout());
		flowPanel.setOpaque(false);
		flowPanel.add(click);
		_panel.add(BorderLayout.SOUTH, flowPanel);
	}

	private void getFrame() {
		_frame = new JFrame("Image Background");
		_frame.setBounds(500, 150, 350, 280);
		_frame.setVisible(true);
		_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@SuppressWarnings("serial")
	static class MyComponent extends JPanel {
		{
			setOpaque(false);
		}
		
		@Override
		protected void paintComponent(final Graphics g) {
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D) g;
			Image image = new ImageIcon("src\\lyskal\\module3\\JPanel\\background.jpg").getImage();
			g2.drawImage(image, 0, 0, null);
		}
	}

	public static void main(final String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new ImageBackground();
			}
		});
	}
}