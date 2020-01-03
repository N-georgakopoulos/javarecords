import java.util.Scanner;
import java.util.ArrayList;

public class Artist extends Person {
	static Scanner sc = new Scanner(System.in);
	protected ArrayList<Album> Albums = new ArrayList<Album>();// dont delete this
	private double rating;
	private double relevancyIndex;
	// Albums=Database.viewAlbum();//fills arraylist albums with albums from the
	// databse
	private int id;
	private static int count=0;
	private String genre;
	private double payPercentage;

	public Artist(int id, String username, String password, double rating, double relevancyIndex, ArrayList<Album> albums,
			String genre, double payPercentage) {
		super(username, password);
		this.username = username;
		this.password = password;
		this.rating = rating;
		this.relevancyIndex = relevancyIndex;
		this.Albums = Albums;
		this.genre = genre;
		this.payPercentage = payPercentage;
		id=count;
		count++;
		this.id=id;
		
	}

	public ArrayList<Album> getAlbums() {// dont delete this
		return Albums;
	}

	public void setAlbums(ArrayList<Album> albums) {
		Albums = albums;
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

	// Artist creates list of songs/wannabe album that he has in mind to create//
	public void registerAlbum() {
		System.out.println("Insert album name: ");
		String albumname = sc.nextLine();
		Database dat = null;
		dat.addsAlbums(albumname, 0, 0, 0, 0);// creates a new halfdone album
		String answer = "no";
		do {
			System.out.println("Insert song name: ");
			String songname = sc.nextLine();
			dat.addsSongs(songname, albumname);// adds songs to the album
			System.out.println("Insert another song name, yes or no;");
			answer = sc.nextLine();
		} while (answer == "yes");
	}

	public void showRatings() {
		for (int p = 0; p < Albums.size(); p++) {
			System.out.println("The popularity of each song by artist " + username + "is: " + Song.Popularity(p)); // p
																													// η
																													// σειρα
																													// του
																													// καθε
																													// τραγουδιου//
		}
		for (int l = 0; l <  Albums.size(); l++) {
			System.out.println("The popularity of each album by artist " + username + "is: " + Album.getPopularity);
		}
	}

	public double popularityOfAlbums() {
		double allAlbumsPopularity = 0;
		for (int i = 1; i <=  Albums.size(); i++) {
			allAlbumsPopularity += Album.getPopularity();
		}
		for (int o = 0; o < Albums.size(); o++) {

		}

		double pop = albumPopularity /  Albums.size(); // χρηση του σταθμισμενου μεσου ορου//
		return pop;
	}

	ArrayList<String> artistsPerformances = new ArrayList<String>();

	public ArrayList<String> myPerfomances() {
		// με βαση την κλαση performance παιρνω το ημερολογιο//
		return artistsPerformances.contains();
	}

	public static void LivePopularity() {
		double attendance = Performance.sales / Performance.price;
		System.out.println("While the venue has capacity of " + Venue.getcapacity()
				+ "people, the number of people that actually attended is " + attendance);
	}

}
