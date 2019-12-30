
import java.util.ArrayList;
import java.util.Scanner;

public class Manager extends Person {
	
	Scanner sc=new Scanner(System.in);
	protected ArrayList<Artist> Artists = new ArrayList<Artist>();//dont delete this
	
	
	public ArrayList<Artist> getArtists() {//dont delete this
		return Artists;
	}

	public void setArtists(ArrayList<Artist> artists) {//dont delete this
		Artists = artists;
	}

	
	public Manager(String username,String password) {
		super(username,password);
		this.username=username;
		this.password=password;
	}

	public void createPerformance() {
		System.out.println("Δημιουργία Συναυλίας");
		System.out.println("Επιλέξτε καλλιτέχνη");
		System.out.println(Database.returnArtists());//shows artists
		
	}
}
