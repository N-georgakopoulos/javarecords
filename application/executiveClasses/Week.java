package application.executiveClasses;

import java.util.ArrayList;

public class Week {
	private Event d1;
	private Event d2;
	private Event d3;
	private Event d4;
	private Event d5;
	private Event d6;
	private Event d7;

	private int monthInt;
	private int numOfWeekInMonth;

	public Week(Event[] weekEvents, int monthInt, int numOfWeek) {
		super();
		d1 = weekEvents[0];
		d2 = weekEvents[1];
		d3 = weekEvents[2];
		d4 = weekEvents[3];
		d5 = weekEvents[4];
		d6 = weekEvents[5];
		d7 = weekEvents[6];

		this.monthInt = monthInt;
		this.numOfWeekInMonth = numOfWeek;
	}


	public Event getD1() {
		return d1;
	}

	public void setD1(Event d1) {
		this.d1 = d1;
	}

	public Event getD2() {
		return d2;
	}

	public void setD2(Event d2) {
		this.d2 = d2;
	}

	public Event getD3() {
		return d3;
	}

	public void setD3(Event d3) {
		this.d3 = d3;
	}

	public Event getD4() {
		return d4;
	}

	public void setD4(Event d4) {
		this.d4 = d4;
	}

	public Event getD5() {
		return d5;
	}

	public void setD5(Event d5) {
		this.d5 = d5;
	}

	public Event getD6() {
		return d6;
	}

	public void setD6(Event d6) {
		this.d6 = d6;
	}

	public Event getD7() {
		return d7;
	}

	public void setD7(Event d7) {
		this.d7 = d7;
	}

	public int getMonthInt() {
		return monthInt;
	}

	public void setMonthInt(int monthInt) {
		this.monthInt = monthInt;
	}

	public int getNumOfWeek() {
		return numOfWeekInMonth;
	}

	public void setNumOfWeek(int numOfWeek) {
		this.numOfWeekInMonth = numOfWeek;
	}

}
