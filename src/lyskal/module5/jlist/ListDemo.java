package lyskal.module5.jlist;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class ListDemo implements ListSelectionListener {
	private JFrame _frame = getFrame();
	private JList _days;
	private JList _months;
	private JList _years;
	private JLabel _text = new JLabel("Birthday: NONE");

	public ListDemo() {
		setupListDays();
		setupListMonths();
		setupListYears();
		_frame.add(_text, new GridBagConstraints(0, 1, 7, 1, 1, 1, 
				GridBagConstraints.SOUTH, GridBagConstraints.HORIZONTAL,
				new Insets(1, 1, 1, 1), 0, 0));
	}

	private void setupListDays() {
		JPanel daysPanel = new JPanel(new FlowLayout());
		Integer[] days = new Integer[31];
		for (int i = 0; i < days.length; i++) {
			days[i] = i + 1;
		}
		_days = new JList<>(days);
		_days.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		_days.addListSelectionListener(this);
		
		JScrollPane scroll = new JScrollPane(_days);
		scroll.setPreferredSize(new Dimension(90, 100));
		daysPanel.add(new JLabel("Birth day: "));
		daysPanel.add(scroll);
		_frame.add(daysPanel, new GridBagConstraints(0, 0, 3, 1, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(1, 1, 1, 1), 0, 0));
	}

	private void setupListMonths() {
		JPanel monthsPanel = new JPanel();
		String[] months = new String[] { "January", "February", "March", 
										 "April", "May", "June", 
										 "July", "August","September", 
										 "October", "November", "December"};
		_months = new JList<>(months);
		_months.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		_months.addListSelectionListener(this);
		
		JScrollPane scroll = new JScrollPane(_months);
		scroll.setPreferredSize(new Dimension(90, 100));
		monthsPanel.add(new JLabel("Birth month:"));
		monthsPanel.add(scroll);

		_frame.add(monthsPanel, new GridBagConstraints(3, 0, 3, 1, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(1, 1, 1, 1), 0, 0));
	}

	private void setupListYears() {
		JPanel yearsPanel = new JPanel();
		Integer[] years = new Integer[30];
		for (int i = 0; i < years.length; i++) {
			years[i] = 1987 + i;
		}
		_years = new JList<>(years);
		_years.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		_years.addListSelectionListener(this);
		
		JScrollPane scroll = new JScrollPane(_years);
		scroll.setPreferredSize(new Dimension(90, 100));
		yearsPanel.add(new JLabel("Birth year: "));
		yearsPanel.add(scroll);

		_frame.add(yearsPanel, new GridBagConstraints(6, 0, 3, 1, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(1, 1, 1, 1), 0, 0));
	}

	private JFrame getFrame() {
		JFrame frame = new JFrame("Birthday");
		frame.setLayout(new GridBagLayout());
		frame.setBounds(500, 150, 330, 280);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		return frame;
	}

	public static void main(final String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new ListDemo();
			}
		});
	}

	@Override
	public void valueChanged(final ListSelectionEvent e) {
		StringBuilder text = new StringBuilder ("Birthday: ");
		if (_days.getSelectedIndex() >= 0) {
			text.append(_days.getSelectedValue()+" ");
		}
		if (_months.getSelectedIndex() >= 0) {
			text.append(_months.getSelectedValue()+" ");
		}
		if (_years.getSelectedIndex() >= 0) {
			text.append(_years.getSelectedValue()+" ");
		}
		_text.setText(text.toString());
	}
}