package application.executiveClasses;

public class Partner extends Person{
	private String attribute; //composer,musician,lyricist,producer
	private double payPerHour;
	public String getAttribute() {
		return attribute;
	}
	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}
	public double getPayPerHour() {
		return payPerHour;
	}
	public void setPayPerHour(double payPerHour) {
		this.payPerHour = payPerHour;
	}
	public Partner(String username, String password, String attribute, double payPerHour) {
		super(username, password);
		this.attribute = attribute;
		this.payPerHour = payPerHour;
	}
	
	
}
