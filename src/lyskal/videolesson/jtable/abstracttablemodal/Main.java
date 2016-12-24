package lyskal.videolesson.jtable.abstracttablemodal;

import javax.swing.*;
import java.awt.*;

public class Main {
	static JFrame jFrame = getJFrame();
	static JPanel jPanel = new JPanel();

	public static void main(final String[] args) {
		jFrame.add(jPanel);
		jPanel.setLayout(new GridBagLayout());
		
		TableModel tableModel = new TableModel();
		JTable table = new JTable(tableModel);
		JScrollPane scrollTable = new JScrollPane(table);
		scrollTable.setPreferredSize(new Dimension(300, 200));
		
		tableModel.addData(new String[] {"Lyuda", "23", "Female"});
		tableModel.addData(new String[] {"Denis", "15", "Male"});
		tableModel.addData(new String[] {"Max", "33", "Male"});
		tableModel.addData(new String[] {"Maria", "28", "Female"});
		
		jPanel.add(scrollTable, new GridBagConstraints(0, 0, 1, 1, 1, 1,
				GridBagConstraints.NORTH, GridBagConstraints.BOTH, 
				new Insets(1, 1, 1, 1), 0, 0));
		jPanel.revalidate();
	}
	
	public static JFrame getJFrame() {
		JFrame jFrame = new JFrame();
		jFrame.setBounds(400, 200, 400, 200);	
		jFrame.setTitle("My table");
		jFrame.setVisible(true);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		return jFrame;
	}
}
