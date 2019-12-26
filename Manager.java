import java.util.Scanner;

public class Manager extends Person {
	
	Scanner sc=new Scanner(System.in);
	Performance perf =new Performance();
	public Manager(String username,String password) {
		super(username,password);
		this.username=username;
		this.password=password;
	}

	public void createPerformance() {
		System.out.println("");
		System.out.println(""");
		System.out.println(Database.returnArtists());//shows artists
		
	}
	
	public displayTimeline() {
		
	}
	
	public displayLeaderboard() {
		
	}
	
	public manageProduction() {
		
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
