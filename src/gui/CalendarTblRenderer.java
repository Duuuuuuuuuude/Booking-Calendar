package gui;

import java.awt.Color;
import java.awt.Component;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JEditorPane;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

import model.Booking;
import model.Day;

public class CalendarTblRenderer extends JEditorPane implements TableCellRenderer {

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		setContentType("text/html");

		// Insert bookings and day number.
		if (value != null) {

			String res = "<html><p style='width:" + (table.getColumnModel().getColumn(column).getWidth() * 0.7)
					+ "px; margin: 0px 0px 10px;'><b>" + ((Day) value).getDayOfMonth() + "</b><br>";
			
			for (Booking currBooking : ((Day) value).getBookings()) {

				res += String.format("&ensp;%s:<br>&emsp;&ensp;%s - %s<br>", currBooking.getSchool().getSchoolName(),
						currBooking.getMediator().getFullName(),
						currBooking.getTime().format(DateTimeFormatter.ofPattern("HH:mm")));

			}
			setText(res);

			table.setRowHeight(row, this.getPreferredSize().height);
		} else {
			setText(null);
		}

		if (value != null) {
			// Change cell colour for weekend, week and today.
			if (column == 6 || column == 5) {
				setBackground(new Color(255, 205, 205)); // Red
			} else {
				setBackground(new Color(255, 255, 255)); // White
			}

			// Change color for today.
			
			if ((value.equals(String.valueOf(LocalDate.now().getDayOfMonth())))) {
				setBackground(new Color(210, 205, 255)); // Purple
			}

			// cell background color when selected.
			if (isSelected) {
				setBackground(new Color(175, 205, 230)); // Blue
			}
		} else {
			// Set color for null cells.
			setBackground(new Color(247, 247, 247)); // Light gray
		}

		return this;
	}
}