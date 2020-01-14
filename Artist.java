import java.util.Scanner;
import java.util.ArrayList;

public class Artist extends Person {
	
	static Scanner sc = new Scanner(System.in);
	private double rating;
	private double relevancyIndex;
	private int id;//artistid
	private double payPercentage;

	public Artist(int id, String username, String password, double rating, double relevancyIndex,
			double payPercentage) {//creates an Artist
		super(username, password);
		this.rating = rating;
		this.relevancyIndex = relevancyIndex;
		this.payPercentage = payPercentage;
		this.setId(id);

	}

	@Override
	public String toString() {
		return "Artist [username=" + this.getUsername() + ", password=" + this.getPassword() + ", rating=" + rating
				+ ", relevancyIndex=" + relevancyIndex + ", payPercentage=" + payPercentage + "]";
	}

	// setters and getters
	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public double getRelevancyIndex() {
		return relevancyIndex;
	}

	public void setRelevancyIndex(double relevancyIndex) {
		this.relevancyIndex = relevancyIndex;
	}

	public double getPayPercentage() {
		return payPercentage;
	}

	public void setPayPercentage(double payPercentage) {
		this.payPercentage = payPercentage;
	}

	public double calculateAlbumScore(Album[] albums) {// calculates the score of each album
		double scoreSum = 0;
		for (int i = 0; i < albums.length; i++) {
			Album temp = albums[i];
			double tempScore = temp.AlbumRevenue(); // according to our
													// research a revenue of
													// an album is about 50%
													// from either physical
													// or digital sales
													// therefore we
													// calculate a score
													// this way since they
													// are
													// equally important
			scoreSum += tempScore;
		}
		return scoreSum;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}