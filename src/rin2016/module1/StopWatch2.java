package rin2016.module1;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class StopWatch2 implements ActionListener {
	private JLabel _jlab;
	private long _startTime;
	private JButton _jbtnStartOrStop;
	
	public StopWatch2() {
		JFrame jfrm = new JFrame("StopWatch 2");
		jfrm.setLayout(new FlowLayout());
		jfrm.setSize(200, 95);
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		_jbtnStartOrStop = new JButton("Start");
		_jbtnStartOrStop.addActionListener(this);
		jfrm.add(_jbtnStartOrStop);
		_jlab = new JLabel("Press Start to begin timing.");
		jfrm.add(_jlab);
		jfrm.setVisible(true);
	}
	@Override
	public void actionPerformed(final ActionEvent ae) {
		//Obtaining a current system time.
		Calendar cal = Calendar.getInstance(); 
		if(ae.getActionCommand().equals("Start")) {
			if (_startTime == 0) {
				//Save the start time.
				_startTime = cal.getTimeInMillis();
				_jlab.setText("Stop watch is Running...");
				_jbtnStartOrStop.setText("Stop");
			}
		} else {
			if (_startTime != 0) {
				int sec = (int)(cal.getTimeInMillis()-_startTime)/1000;
				int mill = (int)(cal.getTimeInMillis()-_startTime)-(1000*sec);
				//Calculated the elapsed time from timer start to stop.
				_jbtnStartOrStop.setText("Start");
				_jlab.setText("Elapsed time is " + sec + "." + mill );
				_startTime = 0;
			}
		}
	}
	
	public static void main(final String[] args) {
		//The creation of the frame in the event-processing thread.
				SwingUtilities.invokeLater(new Runnable() {
					@Override
					public void run() {
						new StopWatch2();
					}
				});
	}
}