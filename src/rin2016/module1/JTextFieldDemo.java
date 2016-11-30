package rin2016.module1;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JTextFieldDemo implements ActionListener {
	
	JTextField _jtf;
	JLabel _jlab;
	
	JTextFieldDemo() {
		JFrame jfrm = new JFrame("A Text Field Example");
		jfrm.setLayout(new FlowLayout());
		jfrm.setSize(280, 90);
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Create edit field (up to 10 characters)
		_jtf = new JTextField(10);
		_jtf.addActionListener(this);
		//Inclusion of the field edit part of the content pane.
		jfrm.add(_jtf);
		_jlab = new JLabel("");
		jfrm.add(_jlab);
		jfrm.setVisible(true);
	}
	
	//Support event actions. 
	//Action event is generated if the user
	//working with the edit field, press <Enter>.
	@Override
	public void actionPerformed(final ActionEvent ae) {
		//Get the text and display it using a label.
		_jlab.setText("Current contents: " + _jtf.getText());
	}
	
	public static void main(final String[] args) {
		//Create frame in the flow of events.
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run () {
				new JTextFieldDemo();
			}
		});
	}
}