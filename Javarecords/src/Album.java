import java.util.ArrayList;
/* import Song; best to leave Album recording score as is and not receive data from Song class */

public class Album {
	// Generate empty Arraylist of Song objects so that Production can add Songs to
	// Albums
	ArrayList<String> AlbumSongs = new ArrayList<String>();
	// Album recording score
	private int NumberOfSongs = AlbumSongs.size();
	// requesting live performance score of an album
	double liveScore = Performance.getLiveScore() / NumberOfSongs;
	// variables of album
	private String albumname;
	private double pricep;
	private double priced;
	private int physical;
	private int digital;
	private int completed;
	
	public Album(ArrayList<String> albumSongs, String albumname, double pricep, double priced, int physical,
			int digital, int completed) {
		super();
		AlbumSongs = albumSongs;
		this.albumname = albumname;
		this.pricep = pricep;
		this.priced = priced;
		this.physical = physical;
		this.digital = digital;
		this.completed = completed;
	}



	// setters and getters
	public ArrayList<String> getAlbumSongs() {
		return AlbumSongs;
	}

	public void setAlbumSongs(ArrayList<String> albumSongs) {
		AlbumSongs = albumSongs;
	}

	public void setname(String AlbumName) {
		this.albumname = AlbumName;
	}

	public String getname() {
		return this.albumname;
	}

	public void setpricep(double pricephy) {
		this.pricep = pricephy;
	}

	public double getpricep() {
		return this.pricep;
	}

	public void setpriced(double pricedig) {
		this.priced = pricedig;
	}

	public double getpriced() {
		return this.priced;
	}

	public void setphysical(int physic) {
		this.physical = physic;
	}

	public double getphysical() {
		return this.physical;
	}

	public void setdigital(int digit) {
		this.digital = digit;
	}

	public double getdigital() {
		return this.digital;
	}

	// Album sales
	public double AlbumSales() {
		double sales = physical + digital;
		return sales;
	}

	// Album revenue
	public double AlbumRevenue() {
		double revenue = physical * pricep + digital * priced;
		return revenue;
	}

	public double RecordingScore() {
		double recScore = (0.1 * physical + 0.9 * digital) / NumberOfSongs;
		return recScore;
	}

	// Album live score
	// *
	// liveScore = liveScore / NumberOfSongs;

	// Album Profit Score
	// public double ProfitScore(recScore, liveScore) {
	// double prScore = 0.5 * recScore + 0.5 * liveScore;
	// return prScore;
	// }
}