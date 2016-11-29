package rin2016.module1;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ButtonDemo implements ActionListener {

	JLabel jlab;
	ButtonDemo() {
		//Создание нового контейнера JFrame
		JFrame jfrm = new JFrame("Окно");
		//Установка диспетчера компоновки FlowLayout
		jfrm.setLayout(new FlowLayout());
		jfrm.setSize(165, 120);
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Создание двух кнопок
		JButton jbtnFirst = new JButton("First");
		JButton jbtnSecond = new JButton("Second");
		//Связывание с кнопками обработчиков событий действия
		jbtnFirst.addActionListener(this);
		jbtnSecond.addActionListener(this);
		//Создание текстовой метки
		jlab = new JLabel("Press a button");
		//Включение метки в состав фрейма
		jfrm.add(jlab);
		jfrm.add(jbtnFirst);
		jfrm.add(jbtnSecond);
		//Отображение фрейма
		jfrm.setVisible(true);
	}
	
	//Обработка событий ActionEvent, связаный с кнопками
	@Override
	public void actionPerformed(final ActionEvent ae) {
		//Использование команды действия для
		//идентификации кнопки
		if(ae.getActionCommand().equals("First")) {
			jlab.setText("First button was...");
		} else {
			jlab.setText("Second button was...");
		}
	}
	
	public static void main(final String[] args) {
		//Создание фрейма в потоке обработки событий
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new ButtonDemo();
			}
		});
	}
}