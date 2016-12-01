package rin2016.module2;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;

public class AlignLabelDemo {
	
	AlignLabelDemo(){
		JLabel[] jlabs = new JLabel[9];
		JFrame jfrm = new JFrame("Horizontal and Vertical Alignment");
		//Установка диспетчера компоновки GridLayout
		//Создать таблицу из 3 строк и 3 столбцов
		//с зазором 4 пикселя между компонентами.
		jfrm.setLayout(new GridLayout(3, 3, 4, 4));
		//Определение исходного размера фрейма
		jfrm.setSize(500, 200);
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		jlabs[0] = new JLabel ("Left Top", SwingConstants.LEFT);
		jlabs[0].setVerticalAlignment(SwingConstants.TOP);
		jlabs[1] = new JLabel ("Center Top", SwingConstants.CENTER);
		jlabs[1].setVerticalAlignment(SwingConstants.TOP);
		jlabs[2] = new JLabel ("Right Top", SwingConstants.RIGHT);
		jlabs[2].setVerticalAlignment(SwingConstants.TOP);
		
		jlabs[3] = new JLabel ("Left Center", SwingConstants.LEFT);
		jlabs[4] = new JLabel ("Center Center", SwingConstants.CENTER);
		jlabs[5] = new JLabel ("Right Center", SwingConstants.RIGHT);
		jlabs[6] = new JLabel ("Left Bottom", SwingConstants.LEFT);
		jlabs[6].setVerticalAlignment(SwingConstants.BOTTOM);
		jlabs[7] = new JLabel ("Center Bottom", SwingConstants.CENTER);
		jlabs[7].setVerticalAlignment(SwingConstants.BOTTOM);
		jlabs[8] = new JLabel ("Right Bottom", SwingConstants.RIGHT);
		jlabs[8].setVerticalAlignment(SwingConstants.BOTTOM);
		//Добавление рамок для отображения вокруг меток.
		//Создание рельефной рамки.
		Border border = BorderFactory.createEtchedBorder();
		//Добавление рамки к каждой метке
		for (int i = 0; i < jlabs.length; i++) {
			jlabs[i].setBorder(border);
		}
		//Добавление меток к панели содержимого
		for (int i = 0; i < jlabs.length; i++) {
			jfrm.add(jlabs[i]);
		}
		//Добавление пустой рамки к панели содержимого
		JPanel cp = ((JPanel) jfrm.getContentPane());
		//Пустая рамка создаёт зазор между краем фрейма
		//и содержащимися в нем элементами 
		cp.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
		jfrm.setVisible(true);
	}

	public static void main(final String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new AlignLabelDemo();
			}
		});

	}

}
