package application.executiveClasses;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;



public class Production {
	
	private int studioTime = 0;
	private Studio studioOfThisProduction;
	private LocalDate startDate;
	private LocalDate releaseDate;
	private Partner partner1;
	private Partner partner2;
	private Partner partner3;
	private Partner partner4;
	private Partner partner5;
	private Partner partner6;
	
	
	public void setPartner1(Partner p) {
		partner1 = p;
	}
	
	public Partner getPartner1() {
		return partner1;
	}
	
	public void setPartner2(Partner p) {
		partner2 = p;
	}
	
	public Partner getPartner2() {
		return partner2;
	}
	
	public void setPartner3(Partner p) {
		partner3 = p;
	}
	
	public Partner getPartner3() {
		return partner3;
	}
	
	public void setPartner4(Partner p) {
		partner4 = p;
	}
	
	public Partner getPartner4() {
		return partner4;
	}
	
	public void setPartner5(Partner p) {
		partner5 = p;
	}
	
	public Partner getPartner5() {
		return partner5;
	}
	
	public void setPartner6(Partner p) {
		partner6 = p;
	}
	
	public Partner getPartner6() {
		return partner6;
	}
	
	public void setStartDate(LocalDate ldate) {
		startDate = ldate;
	}
	
	public LocalDate getStartDate() {
		return startDate;
	}
	
	public void setReleaseDate(LocalDate ldate) {
		releaseDate = ldate;
	}
	
	public LocalDate getReleaseDate() {
		return releaseDate;
	}
	
	public void setStudioTime(int time) {
		studioTime = time;
	}
	
	public int getStudioTime() {
		return studioTime;
	}
	
	public Studio getStudio() {
		return studioOfThisProduction;
	}
	
	public void setStudio(Studio studio) {
		studioOfThisProduction = studio;
	}
	
	public double productionCost() {
		
		double totalPartnersPayPerHour = 0.0;
		
		if(partner1 != null) {
			totalPartnersPayPerHour += partner1.getPayPerHour();
		}
		
		if(partner2 != null) {
			totalPartnersPayPerHour += partner2.getPayPerHour();
		}
		
		if(partner3 != null) {
			totalPartnersPayPerHour += partner3.getPayPerHour();
		}
		
		if(partner4 != null) {
			totalPartnersPayPerHour += partner4.getPayPerHour();
		}
		
		if(partner5 != null) {
			totalPartnersPayPerHour += partner5.getPayPerHour();
		}
		
		if(partner6 != null) {
			totalPartnersPayPerHour += partner6.getPayPerHour();
		}
		
		double cost = (double) studioTime * (studioOfThisProduction.getPricePerHour() + totalPartnersPayPerHour);
		
		return cost;
	}

} //end class Production