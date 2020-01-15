import java.util.ArrayList;
import java.util.Random;

public class Album {

	public static Random rand = new Random();// declaring random num generator
	// final variables which determine the range of the randomized instance
	static final int PHYSICALPRICERANGE = 101;
	static final int DIGITALPRICERANGE = 51;
	static final int PHYSICALSALESRANGE = 10000001;
	static final int DIGITALSALESRANGE = 2 * PHYSICALSALESRANGE;

	// Generate empty Arraylist of Song objects so that Production can add Songs to
	// Albums
	// Album recording score
	// private int NumberOfSongs = AlbumSongs.size();
	// requesting live performance score of an album
	// double liveScore = Performances.getLiveScore() / NumberOfSongs;
	// variables of album
	private String albumname;
	private double pricep;
	private double priced;
	private int physical;
	private int digital;
	private int artistid;
	private int completed; // acts as boolean concerning if the album is completed or not

	public Album(String albumname, int artistid, int completed) {
		this.albumname = albumname;
		this.completed = completed;
		this.artistid = artistid;
		if (completed == 1) {
			this.pricep = rand.nextInt(PHYSICALPRICERANGE);
			this.priced = rand.nextInt(DIGITALPRICERANGE);
			this.physical = rand.nextInt(PHYSICALSALESRANGE);
			this.digital = rand.nextInt(DIGITALSALESRANGE);
		} else {
			this.pricep = 0;
			this.priced = 0;
			this.physical = 0;
			this.digital = 0;
		}

	}

	public Album(String albumname, double pricep, double priced, int physical, int digital, int artistid,
			int completed) {// creats an Album
		super();
		this.albumname = albumname;
		this.pricep = pricep;
		this.priced = priced;
		this.physical = physical;
		this.digital = digital;
		this.artistid = artistid;
		this.completed = completed;
	}

	@Override
	public String toString() {
		return albumname;
	}

	// setters and getters

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

	public double RecordingScore() throws Exception {
		double recScore = (0.1 * physical + 0.9 * digital) / Database.findNumberOfSongs(this.albumname);
		return recScore;
	}

	public double getPerformanceRevenue() {
		// TODO Auto-generated method stub
		return 0;
	}

}