package rin2016.module1;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class SwingDemo {

	SwingDemo() {
		//Создание контейнера верхнего уровня
		JFrame jfrm = new JFrame("Окно");
		//Установка начальных размеров фрейма
		jfrm.setSize(250, 200);
		//Завершение программы при закрытии пользователем
		//окна приложения
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Создание метки
		JLabel jlab = new JLabel("Наше первое окно в JAVA :)");
		//Включение метки в состав панели содержимого
		jfrm.add(jlab);
		//Отображение фрейма
		jfrm.setVisible(true);
	}
	
	public static void main(final String[] args) {
		//Создание фрейма в потоке обработки событий
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new SwingDemo();
			}
		});
	}
}