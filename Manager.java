import java.util.Scanner;

public class Manager extends Person {
	
	Scanner sc=new Scanner(System.in);
	
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
