package model;

import java.util.ArrayList;
import java.util.List;

public class CalMonth {
	private List<Day> days;

	
	/**
	 * List<Day> days skal indeholde alle dagene i måneden, også selvom dagen ikke indeholder nogen bookings.
	 * @param en liste over dage i denne måned.
	 */
	public CalMonth(List<Day> days) {
		this.days = days;
	}

	public List<Day> getDays() {
		List<Day> res = new ArrayList<>(this.days);
		return res;
	}

}
