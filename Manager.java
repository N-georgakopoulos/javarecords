package application.executiveClasses;

import java.util.ArrayList;

public class Manager extends Person {
	
	ArrayList<Artist> artists = new ArrayList<Artist>();

	public ArrayList<Artist> getArtists() {
		return artists;
	}

	public void setArtists(ArrayList<Artist> artists) {
		this.artists = artists;
	}

	public Manager(String username, String password) {
		super(username, password);

	}

	public static void loadObj() {
		Manager x = new Manager("", " ");
		for (int i = 0; i < 5; i++) {
			Album[] y = new Album[4];
			Artist z = new Artist("", "", i, i, y, "", i, "");
			x.artists.add(z);
		}
	}
}