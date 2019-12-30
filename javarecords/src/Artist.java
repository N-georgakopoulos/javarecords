import java.util.Scanner;
import java.util.ArrayList;

public class Artist extends Person {
	static Scanner sc = new Scanner(System.in);
	ArrayList<String> wannabeAlbum = new ArrayList<String>();
	String imgPerson;
	private double rating;
	private double relevancyIndex;	
	private String genre;
	private double payPercentage; 
	
	public Artist(String username, String password, double rating, double relevancyIndex, Album[] albums,
			String genre, double payPercentage, String imgPerson) {
		super(username,password);
		this.username = username;
		this.password = password;
		this.rating = rating;
		this.relevancyIndex = relevancyIndex;
		this.albums = albums;
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
	
	//Artist creates list of songs/wannabe album that he has in mind to create//
	public ArrayList<String> registerAlbum () {
		System.out.println("Insert album name: ");
		String name = sc.nextLine();
		wannabeAlbum.add(name);       //first line of list is the album name//
		String answer  = "no"; 
		do {
			System.out.println("Insert song name: ");
			name = sc.nextLine();
			wannabeAlbum.add(name);
			System.out.println("Insert another song name, yes or no;");
		    answer = sc.nextLine();
		} while (answer == "yes");
		return wannabeAlbum;
	}
	
	public void showRatings() {
		for (int l =0; l < numberOfAlbumsByAnArtist; l++) {
			System.out.println("The popularity of each album by artist " + username + "is: " +  Album.AlbumSales());
		}
	}
	
	public double popularityOfAlbums() {
		double allAlbumsPopularity = 0;
		for(int i = 1; i <= numberOfAlbumsByAnArtist; i++) {
			allAlbumsPopularity += Album.AlbumSales();
		}				
		double pop = albumPopularity/numberOfAlbumsByAnArtist;
		return pop;
	}
	
	ArrayList<String> artistsPerformances = new ArrayList<String>();
	public ArrayList<String> myPerfomances() {
		//με βαση την κλαση performance παιρνω το ημερολογιο//
		return artistsPerformances.contains();
	}
	
	public static void LivePopularity() {
		double attendance = Performance.ticketSales / Performance.ticketPrice;
		System.out.println("While the venue has capacity of " 
				+ Venue.getcapacity() + "people, the number of people that actually attended is "
				+ attendance);		
	}
	
	/*public double ArtistScore() {
		ArrayList<Double> score = new ArrayList<Double>();               
		ArrayList<String> name = new ArrayList<String>();                -logika xreiazetai sto gui-
		ArrayList<Integer> place = new ArrayList<Integer>();
				
	}*/
	
}

