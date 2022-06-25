package model;

import java.time.LocalTime;

public class Booking {
	private LocalTime time;
	private Mediator mediator;
	private School school;

	public Booking(LocalTime time, Mediator mediator, School school) {
		this.mediator = mediator;
		this.time = time;
		this.school = school;
	}

	public LocalTime getTime() {
		LocalTime res = this.time;
		return res;
	}

	public Mediator getMediator() {
		return this.mediator;
	}

	public School getSchool() {
		return this.school;
	}

}
