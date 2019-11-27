import java.util.Scanner;

public class Artist extends Person {
	static Scanner sc = new Scanner(System.in);
	private double rating;
	private double relevancyIndex;
	private Album[] albums;
	private Timeline timeline;
	private String genre;
	private double payPercentage;
	
	public Artist(String username, String password, double rating, double relevancyIndex, Album[] albums,
			Timeline timeline, String genre, double payPercentage) {
		super(username,password);
		this.username = username;
		this.password = password;
		this.rating = rating;
		this.relevancyIndex = relevancyIndex;
		this.albums = albums;
		this.timeline = timeline;
		this.genre = genre;
		this.payPercentage = payPercentage;
	}

	@Override
	public String toString() {
		return "Artist [username=" + username + ", password=" + password + ", rating=" + rating + ", relevancyIndex="
				+ relevancyIndex + ", genre=" + genre + ", payPercentage=" + payPercentage + "]";
	}

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

	public Album[] getAlbums() {
		return albums;
	}

	public void setAlbums(Album[] albums) {
		this.albums = albums;
	}

	public Timeline getTimeline() {
		return timeline;
	}

	public void setTimeline(Timeline timeline) {
		this.timeline = timeline;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public double getPayPercentage() {
		return payPercentage;
	}

	public void setPayPercentage(double payPercentage) {
		this.payPercentage = payPercentage;
	}

	public void logIn() {
		String[] givenCreds = this.askCredentials(); // keep in mind givenCreds[0] contains username ,givenCreds [1]
														// contains password
		boolean allGood = false; //checks if login is successful
		while (!allGood) {
			if (usernameExists()) { // TODO usernameExists which will lookup given username in DB
				String realPass = lookUpPass(givenCreds[0]); // lookUpPass returns the correct password from DB for each
																// username
				if (realPass == givenCreds[1]) {
					allGood = true;
					break;
				} else {
					System.out.println("Incorrect password try again");
					this.logIn(); 
				}
			}else {
				System.out.println("Username was not found");
				this.logIn();
			}
		}
	}

	public String[] askCredentials() {
		System.out.println("Insert ur username");
		String username = sc.nextLine();
		System.out.println("Insert ur password");
		String password = sc.nextLine();
		String[] creds = { username, password };
		return creds;
	}
}

=======
import java.util.Scanner;

public class Artist extends Person {
	static Scanner sc = new Scanner(System.in);
	private double rating;
	private double relevancyIndex;
	private Album[] albums;
	private Timeline timeline;
	private String genre;
	private double payPercentage;
	
	public Artist(String username, String password, double rating, double relevancyIndex, Album[] albums,
			Timeline timeline, String genre, double payPercentage) {
		super(username,password);
		this.username = username;
		this.password = password;
		this.rating = rating;
		this.relevancyIndex = relevancyIndex;
		this.albums = albums;
		this.timeline = timeline;
		this.genre = genre;
		this.payPercentage = payPercentage;
	}

	@Override
	public String toString() {
		return "Artist [username=" + username + ", password=" + password + ", rating=" + rating + ", relevancyIndex="
				+ relevancyIndex + ", genre=" + genre + ", payPercentage=" + payPercentage + "]";
	}

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

	public Album[] getAlbums() {
		return albums;
	}

	public void setAlbums(Album[] albums) {
		this.albums = albums;
	}

	public Timeline getTimeline() {
		return timeline;
	}

	public void setTimeline(Timeline timeline) {
		this.timeline = timeline;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public double getPayPercentage() {
		return payPercentage;
	}

	public void setPayPercentage(double payPercentage) {
		this.payPercentage = payPercentage;
	}

	public void logIn() {
		String[] givenCreds = this.askCredentials(); // keep in mind givenCreds[0] contains username ,givenCreds [1]
														// contains password
		boolean allGood = false; //checks if login is successful
		while (!allGood) {
			if (usernameExists()) { // TODO usernameExists which will lookup given username in DB
				String realPass = lookUpPass(givenCreds[0]); // lookUpPass returns the correct password from DB for each
																// username
				if (realPass == givenCreds[1]) {
					allGood = true;
					break;
				} else {
					System.out.println("Incorrect password try again");
					this.logIn(); 
				}
			}else {
				System.out.println("Username was not found");
				this.logIn();
			}
		}
	}

	public String[] askCredentials() {
		System.out.println("Insert ur username");
		String username = sc.nextLine();
		System.out.println("Insert ur password");
		String password = sc.nextLine();
		String[] creds = { username, password };
		return creds;
	}
}

