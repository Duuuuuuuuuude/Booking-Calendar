package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Day {
	private List<Booking> bookings;
	private LocalDate date;
	
	

	public Day(List<Booking> bookings, LocalDate date) {
		this.bookings = bookings;
		this.date = date;
	}

	public List<Booking> getBookings() {
		List<Booking> res = new ArrayList<>(bookings);
		return res;
	}
	
	public LocalDate getDate() {
		return date;
	}

	public int getDayOfMonth() {
		return date.getDayOfMonth();
	}	

}
