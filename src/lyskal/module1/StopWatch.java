package lyskal.module1;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class StopWatch implements ActionListener {
	private JLabel _jlab;
	private long _start;
	
	public StopWatch() {
		JFrame jfrm = new JFrame("StopWatch");
		jfrm.setLayout(new FlowLayout());
		jfrm.setSize(220, 95);
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton jbtnStart = new JButton("Start");
		JButton jbtnStop = new JButton("Stop");
		//Связывание с кнопками обработчиков событий действия
		jbtnStart.addActionListener(this);
		jbtnStop.addActionListener(this);
		jfrm.add(jbtnStart);
		jfrm.add(jbtnStop);
		//Создание метки и привязка её в фрейму
		_jlab = new JLabel("Press Start to begin timing.");
		jfrm.add(_jlab);
		jfrm.setVisible(true);
	}
	@Override
	public void actionPerformed(final ActionEvent ae) {
		//Получении текущего системного времени
		Calendar cal = Calendar.getInstance(); 
		if(ae.getActionCommand().equals("Start")) {
			if (_start == 0) {
				//Сохранение времени запуска
				_start = cal.getTimeInMillis();
				_jlab.setText("Stop watch is Running...");
			}
		} else {
			if (_start != 0) {
				int sec = (int)(cal.getTimeInMillis()-_start)/1000;
				int mill = (int)(cal.getTimeInMillis()-_start)-(1000*sec);
				//Вычисляем время прошедшее от запуска до остановки
				_jlab.setText("Elapsed time is " + sec + "." + mill );
				_start = 0;
			}
		}
	}
	
	public static void main(final String[] args) {
		//Создание фрейма в потоке обработки событий
				SwingUtilities.invokeLater(new Runnable() {
					@Override
					public void run() {
						new StopWatch();
					}
				});
	}
}