package lyskal.movefigure;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class MoveFigure extends JFrame {
	private JPanel figurePanel = new JPanel();
	private JPanel buttonsPanel = new JPanel();
	
	private JButton up = new JButton("Up");
	private JButton down = new JButton("Dowm");
	private JButton left = new JButton("Left");
	private JButton right = new JButton("Right");
	
	public MoveFigure() {
		getFrame();
		createButtons();
		figurePanel.setBorder(BorderFactory.createEtchedBorder(Color.WHITE, Color.GRAY));
		add(figurePanel, BorderLayout.CENTER);
		add(buttonsPanel, BorderLayout.SOUTH);
		
	}
	
	private void createButtons() {
		JPanel buttons = new JPanel();
		buttons.setLayout(new GridBagLayout());
		buttons.add(up, new GridBagConstraints(1, 0, 1, 1, 1, 1,
				GridBagConstraints.SOUTH, GridBagConstraints.HORIZONTAL, 
				new Insets(1, 1, 1, 1), 0, 0));
		buttons.add(left, new GridBagConstraints(0, 1, 1, 1, 1, 1,
				GridBagConstraints.SOUTH, GridBagConstraints.HORIZONTAL, 
				new Insets(1, 1, 1, 1), 0, 0));
		buttons.add(right, new GridBagConstraints(2, 1, 1, 1, 1, 1,
				GridBagConstraints.SOUTH, GridBagConstraints.HORIZONTAL, 
				new Insets(1, 1, 1, 1), 0, 0));
		buttons.add(down, new GridBagConstraints(1, 2, 1, 1, 1, 1,
				GridBagConstraints.SOUTH, GridBagConstraints.HORIZONTAL, 
				new Insets(1, 1, 1, 1), 0, 0));
		buttonsPanel.add(buttons);
	}
	
	private void getFrame() {
		setTitle("move figure");
		setBounds(400, 150, 500, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		setLayout(new BorderLayout());
	}
	
	@Override
	public Insets getInsets() {
		return new Insets(30, 7, 7, 7);
	}

	public static void main(final String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new MoveFigure();
			}
		});
	}

}