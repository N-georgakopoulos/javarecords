public class Partner {

	private String name;
	private String attribute; // composer,musician,lyricist,producer
	private double payPerHour;

	public Partner(String name, String attribute, double payPerHour) {
		this.name = name;
		this.attribute = attribute;
		this.payPerHour = payPerHour;
	}

	// setters and getters
	public String getName() {
		return name;
	}

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

}