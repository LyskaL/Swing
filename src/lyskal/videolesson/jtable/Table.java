package lyskal.videolesson.jtable;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;

public class Table extends JFrame {
	JTable _table;
	
	public Table() {
		setLayout(new FlowLayout());
		String[] column = {"Word", "Transcription", "Translation"};
		
		String[][] data = {
				{"construction","[kənˈstrʌkʃən]","конструктор"},
				{"synchronization","[sɪŋkrənaɪˈzeɪʃn]","синхронизации"},
				{"implementation","[ɪmplɪmenˈteɪʃn]","реализация"},
				{"compatible","[kəmˈpætəbl]","совместимый"},
				{"provide","[prəˈvaɪd]","обеспечивать"}
		};
		
		_table = new JTable(data, column);
		_table.setPreferredScrollableViewportSize(new Dimension(400, 80));
		_table.setFillsViewportHeight(true);
		
		// Align the table on center.
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		_table.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
		_table.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
		_table.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
		
		JScrollPane scrollTable = new JScrollPane(_table);
		add(scrollTable);
	}

	public static void main(final String[] args) {
		Table table = new Table();
		table.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		table.setBounds(500, 100, 500, 300);
		table.setTitle("My dictionary");
		table.setVisible(true);
	}
}