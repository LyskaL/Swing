package lyskal.videolesson.jtable.abstracttablemodal;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class TableModel extends AbstractTableModel {
	private static final int columnCount = 3;
	private List<String[]> data;
	
	public TableModel() {
		data = new ArrayList<>();
	}
	
	@Override
	public int getRowCount() {
		return data.size();
	}

	@Override
	public int getColumnCount() {
		return columnCount;
	}

	@Override
	public Object getValueAt(final int rowIndex, final int columnIndex) {
		return data.get(rowIndex)[columnIndex];
	}
	
	@Override
	public String getColumnName(final int columnIndex) {
		switch(columnIndex){
		case 0:
			return "Name";
		case 1:
			return "Age";
		case 2:
			return "Gender";
		}
		return "";
	}
	
	public void addData(final String[] row) {
		String[] rowTable = new String[columnCount];
		rowTable = row;
		data.add(rowTable);
		
	}
	
	
}
