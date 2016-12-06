package lyskal.module1;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Coder implements ActionListener {

	private JTextField _jtfPlaintext;
	private  JTextField _jtfCiphertext;
	
	private static final int ENCODE_STRING = 1;
	private static final int DECODE_STRING = -1;
	
	public Coder() {
		JFrame jfrm = new JFrame("Coder Machine");
		jfrm.setLayout(new FlowLayout());
		jfrm.setSize(340, 140);
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel jlabPlaintext = new JLabel("  Plain Text: ");
		JLabel jlabCiphertext = new JLabel("Cipher Text: ");
		
		_jtfPlaintext = new JTextField(20);
		_jtfCiphertext = new JTextField(20);
		
		_jtfPlaintext.setActionCommand("Encode");
		_jtfCiphertext.setActionCommand("Decode");
		
		_jtfPlaintext.addActionListener(this);
		_jtfCiphertext.addActionListener(this);
		
		jfrm.add(jlabPlaintext);
		jfrm.add(_jtfPlaintext);
		jfrm.add(jlabCiphertext);
		jfrm.add(_jtfCiphertext);
		
		JButton jbtnEncode = new JButton("Encode");
		JButton jbtnDecode = new JButton("Decode");
		JButton jbtnReset = new JButton("Recet");
		
		jbtnEncode.addActionListener(this);
		jbtnDecode.addActionListener(this);
		jbtnReset.addActionListener(this);
		
		jfrm.add(jbtnEncode);
		jfrm.add(jbtnDecode);
		jfrm.add(jbtnReset);
		
		jfrm.setVisible(true);
	}

	@Override
	public void actionPerformed(final ActionEvent ae) {
		if(ae.getActionCommand().equals("Encode")) {
			_jtfCiphertext.setText(changeText(_jtfPlaintext.getText(), ENCODE_STRING));
		} else if (ae.getActionCommand().equals("Decode")) {
			_jtfPlaintext.setText(changeText(_jtfCiphertext.getText(), DECODE_STRING));
		} else {
			_jtfPlaintext.setText("");
			_jtfCiphertext.setText("");
		}
	}
	
	public static void main(final String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Coder();
			}
		});
	}
	
	/*
	 * Method change the string.
	 * 
	 * If the index is 1(ENCODE_STRING) string is encoded.
	 * If the index is -1(DECODE_STRING) string is decode.
	 */
	public static String changeText(final String text, 
									final int index) {
		if(text != null && (index == DECODE_STRING || index == ENCODE_STRING)) {
			// Get the text and pass it to the object.
			StringBuilder ourText = new StringBuilder(text);
			// Add one to each character in the string.
			for (int i = 0; i < ourText.length(); i++) {
				ourText.setCharAt(i, (char) (ourText.charAt(i) + index));
			}
			return ourText.toString();
		}
		return "";
	}
}