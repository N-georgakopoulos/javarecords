package application.executiveClasses;

public class Venues {
	private double cost;
	private String name;
	private int capacity;

	public Venues(double cost, String name, int capacity) {
		super();
		this.cost = cost;
		this.name = name;
		this.capacity = capacity;
	}

	@Override
	public String toString() {
		return name;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

}
