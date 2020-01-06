
import java.util.ArrayList;
import java.util.Scanner;

public class Manager extends Person {

	Scanner sc = new Scanner(System.in);

	protected ArrayList<Artist> Artists = new ArrayList<Artist>();// dont delete this
	private int managerid;
	private static int count=0;

	public Manager(int managerid, String username, String password, ArrayList<Artist> Artists) {
		super(username, password);
		this.username = username;
		this.password = password;
		this.Artists=Artists;
		managerid=count;
		count++;
		this.managerid=managerid;
	}

	public ArrayList<Artist> getArtists() {// dont delete this
		return Artists;
	}

	public void setArtists(ArrayList<Artist> artists) {// dont delete this
		Artists = artists;
	}

	public void createPerformance() {
		System.out.println("Δημιουργία Συναυλίας");
		System.out.println("Επιλέξτε καλλιτέχνη");
		System.out.println(Database.viewManagersArtist(managerid));// shows artists

	}
}
