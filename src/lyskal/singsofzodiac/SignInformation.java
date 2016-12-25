package lyskal.singsofzodiac;

import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class SignInformation extends JDialog{
	
	public SignInformation(final JFrame jFrame, final SingOfZodiac sing){
		super(jFrame, "Your sign", true);
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new GridBagLayout());
		
		panel.getRootPane().setBorder
			(BorderFactory.createEtchedBorder(HIDE_ON_CLOSE, Color.WHITE, Color.GRAY));
		
		//добавить картинку знака
		panel.add(new JLabel(sing.getImage()), new GridBagConstraints(0, 0, 1, 4, 1, 1,
				GridBagConstraints.NORTH, GridBagConstraints.BOTH, 
				new Insets(1, 1, 1, 1), 0, 0));
		
		//Добавляем имя знака (правее от фото)
		Font fontName = new Font("Georgia", Font.ITALIC, 32);
		JLabel name = new JLabel(sing.getName());
		name.setFont(fontName);
		panel.add(name, new GridBagConstraints(1, 0, 3, 1, 1, 1,
				GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, 
				new Insets(1, 1, 1, 1), 0, 0));
		//Добавляем даты знака(праве от фото и ниже имени)
		Font fontElement = new Font("Georgia", Font.ITALIC, 20);
		JLabel element = new JLabel("element: " + sing.getElement());
		element.setFont(fontElement);
		panel.add(element, new GridBagConstraints(1, 1, 3, 1, 1, 1,
				GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, 
				new Insets(1, 1, 1, 1), 0, 0));
		
		//Добавляем даты знака(праве от фото и ниже имени)
		Font fontDate = new Font("Georgia", Font.ITALIC, 20);
		JLabel date = new JLabel("date: " + sing.getDate());
		date.setFont(fontDate);
		panel.add(date, new GridBagConstraints(1, 2, 3, 1, 1, 1,
				GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, 
				new Insets(1, 1, 1, 1), 0, 0));
		
		Font fontDiscription = new Font("Georgia", Font.ITALIC, 16);
		JLabel discriptionLabel = new JLabel("discription:");
		discriptionLabel.setFont(fontElement);
		panel.add(discriptionLabel, new GridBagConstraints(1, 3, 3, 1, 1, 1,
				GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, 
				new Insets(1, 1, 1, 1), 0, 0));
		
		//Выводим описание знака
		JTextArea discription = new JTextArea(15, 10);
		discription.setFont(fontDiscription);
		discription.setBackground(jFrame.getBackground());
		discription.setText(sing.getDescription());
		discription.setLineWrap(true);
		discription.setWrapStyleWord(true);
		discription.setEditable(false);
		panel.add(new JScrollPane(discription), new GridBagConstraints(0, 4, 4, 5, 1, 1,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH, 
				new Insets(1, 1, 1, 1), 0, 0));
		
		setBounds(450, 150, 600, 500);
		setVisible(true);
	}
}
