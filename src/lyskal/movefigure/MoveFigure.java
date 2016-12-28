package lyskal.movefigure;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class MoveFigure extends JFrame {
	private JPanel figurePanel = new JPanel();
	private JPanel buttonsPanel = new JPanel();
	
	private JButton up = new JButton("Up");
	private JButton down = new JButton("Down");
	private JButton left = new JButton("Left");
	private JButton right = new JButton("Right");
	
	private PrintFigure figure;
	
	public MoveFigure() {
		getFrame();
		createButtons();
		figurePanel.setBorder(BorderFactory.createEtchedBorder(Color.WHITE, Color.GRAY));
		add(figurePanel, BorderLayout.CENTER);
		add(buttonsPanel, BorderLayout.SOUTH);
		figure = new PrintFigure(215, 100);
		figurePanel.add(figure);
		
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
		down.addActionListener(new ButtonAction());
		up.addActionListener(new ButtonAction());
		right.addActionListener(new ButtonAction());
		left.addActionListener(new ButtonAction());
		buttonsPanel.add(buttons);
	}
	
	private void getFrame() {
		int width = 500;
		int height = 400;
		setTitle("move figure");
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension dimension = toolkit.getScreenSize();
		setBounds(dimension.width/2-(width/2), 
				 dimension.height/2-(height/2), 
				 width, 
				 height);
		
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
	
	class ButtonAction extends AbstractAction {
		@Override
		public void actionPerformed(final ActionEvent e) {
			if(e.getActionCommand().equals("Down")) {
				figure.setY(200);
				figure.setX(215);
				figurePanel.repaint();
			} else if(e.getActionCommand().equals("Up")) {
				figure.setY(0);
				figure.setX(215);
				figurePanel.repaint();
			} else if(e.getActionCommand().equals("Left")) {
				figure.setY(100);
				figure.setX(0);
				figurePanel.repaint();
			} else if(e.getActionCommand().equals("Right")) {
				figure.setY(100);
				figure.setX(430);
				figurePanel.repaint();
			}
		}
		
	}
}