import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Arrays;

import application.managerHomeController;
import application.ratingController;

public class Manager extends Person {

	Artist[] artists;
	protected ArrayList<Artist> Artists = new ArrayList<Artist>();// arraylist with the artists of each manager
	private int managerid;
	private static int count = 0;

	public Manager(int managerid, String username, String password, ArrayList<Artist> Artists) {// creates manager
		super(username, password);
		this.Artists = Artists;
		this.managerid = managerid;
	}

	public int getId() {
		return this.managerid;
	}

	public ArrayList<Artist> getArtists() {
		return Artists;
	}

	public void setArtists(Artist[] artists) {
		this.artists = artists;
	}

	public Manager(String username, String password) {
		super(username, password);

	}

	@SuppressWarnings("null")
	public static ArrayList<Artist> rankArtists(ArrayList<Artist> artists) throws Exception {
		try {
			Artist[] artArray = (Artist[]) artists.toArray();

			double[] scoreSum = null;
			for (int i = 0; i < artArray.length; i++) {
				Album[] albums = (Album[]) Database.findWhichAlbum(artArray[i].getId()).toArray();// finds the album
																									// from database
																									// base from the
																									// artistid
				scoreSum[i] = artArray[i].calculateAlbumScore(albums);// calculates album scores
			}
			Artist[] rankedArtArray = insertionSort(scoreSum, artArray);
			ArrayList<Artist> rankedArts = new ArrayList<Artist>(Arrays.asList(rankedArtArray));
			return rankedArts;
		} catch (Exception e) {
			System.out.println(e);
		}
		return artists;
	}

	// modified insertionSort method to update the array of artistScores according
	// to their scores
	public static Artist[] insertionSort(double array[], Artist[] rankedArtists) {
		int n = array.length;// how many artists
		for (int j = 1; j < n; j++) {
			double key = array[j];
			int i = j - 1;
			while ((i > -1) && (array[i] > key)) {
				array[i + 1] = array[i];
				rankedArtists[i + 1] = rankedArtists[i];
				i--;
			}
			array[i + 1] = key;
		}
		return rankedArtists;
	}

}