import java.util.ArrayList;

public class Studio {

	private String name;
	private double pricePerHour;
	public static ArrayList slist;

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

}