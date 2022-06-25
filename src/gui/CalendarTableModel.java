package gui;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import model.CalMonth;
import model.Day;

public class CalendarTableModel extends DefaultTableModel {
	private static final String[] MONTHS = { "Mandag", "Tirsdag", "Onsdag", "Torsdag", "Fredag", "Lørdag", "Søndag" };
	private Day[][] days;

	public CalendarTableModel() {
		this.days = new Day[6][7];
	}

	public void setModelData(CalMonth data) {
		// Clears the days array.
		for (int i = 0; i < 6; i++) {
			Arrays.fill(days[i], null);
		}

		// Insert new data.
		List<Day> month = data.getDays();
		LocalDate date = month.get(0).getDate();
		int firstDayOfMonth = date.getDayOfWeek().getValue();

		Iterator<Day> monthIt = month.iterator();
		for (int currDay = 1; monthIt.hasNext(); currDay++) {
			int row = (currDay + firstDayOfMonth - 2) / 7;
			int column = (currDay + firstDayOfMonth - 2) % 7;
			days[row][column] = monthIt.next();
		}
		super.fireTableDataChanged();
	}

	@Override
	public String getColumnName(int column) {
		return MONTHS[column];
	}

	@Override
	public Day getValueAt(int row, int column) {
		Day res = days[row][column];
		return res;
	}

	@Override
	public boolean isCellEditable(int row, int column) {
		return false;
	}

	@Override
	public int getRowCount() {
		return 6;
	}

	@Override
	public int getColumnCount() {
		return 7;
	}

	@Override
	public Class<String[]> getColumnClass(int columnIndex) {
		return String[].class;
	}

}
