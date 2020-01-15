package application.executiveClasses;

import java.time.LocalDate;
import java.util.Date;

public class Performances {
	private Venues venue;
	private double ticketPrice;
	private double ticketSales;
	private Album AlbumPlayed1;
	private LocalDate date;
	
	public double calculateProfit() {
		try {
		double cost = venue.getCost();
		double income = ticketPrice*ticketSales;
		return income-cost;
		}catch(NullPointerException e) {
		
		}
		return 0;
	}
	public double getLiveScore(){
		int capacity = venue.getCapacity();
		double LiveScore = 0;
		if (capacity <= 1000) {
			LiveScore = (this.ticketSales / capacity) * 100;
		} else if (capacity <= 10000) {
			LiveScore = (this.ticketSales / capacity) * 100;
		} else if (capacity <= 100000) {
			LiveScore = (this.ticketSales / capacity) * 100;
		}
		return LiveScore;
	}

	

	public double getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	public double getTicketSales() {
		return ticketSales;
	}

	public void setTicketSales(double ticketSales) {
		this.ticketSales = ticketSales;
	}

	public Album getAlbumPlayed1() {
		return AlbumPlayed1;
	}

	public void setAlbumPlayed1(Album albumPlayed1) {
		AlbumPlayed1 = albumPlayed1;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Performances(Venues venue, double ticketPrice, double ticketSales, Album albumPlayed1, LocalDate date) {
		super();
		this.venue = venue;
		this.ticketPrice = ticketPrice;
		this.ticketSales = ticketSales;
		AlbumPlayed1 = albumPlayed1;
		this.date = date;
	}
	
}
