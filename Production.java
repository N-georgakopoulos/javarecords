package application;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;



public class Production {
	
	private int studioTime = 0;
	private Studio studioOfThisProduction;
	private Studio[] allStudios;
	private LocalDate startDate;
	private LocalDate releaseDate;
	private Partner[] partnersOfThisProduction;
	private int count;
	
	public void addPartner(Partner p) {
		partnersOfThisProduction[count++] = p;
		
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
		
		for(int i = 0; i<  partnersOfThisProduction.length; i++) {
			totalPartnersPayPerHour += partnersOfThisProduction[i].getPayPerHour();  
		} //end for
		
		double cost = (double) studioTime * (studioOfThisProduction.getPricePerHour() + totalPartnersPayPerHour);
		
		return cost;
	}

} //end class Production

