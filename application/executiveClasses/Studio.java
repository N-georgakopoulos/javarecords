package application.executiveClasses;


import java.util.ArrayList;

public class Studio {
	
	private String name;
	private double pricePerHour;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setPricePerHour(double pricePerHour) {
		this.pricePerHour = pricePerHour;
	}
	
	public double getPricePerHour() {
		return pricePerHour;
	}

	public Studio(String name, double pricePerHour) {
		super();
		this.name = name;
		this.pricePerHour = pricePerHour;
	}

	@Override
	public String toString() {
		return "Studio [name=" + name + ", pricePerHour=" + pricePerHour + "]";
	}
	
}