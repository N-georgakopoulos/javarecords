
import java.util.Scanner;

public class ClassMain {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		boolean exit = false; 
		while(!exit) {
			displayHome();
			int ans = sc.nextInt(); //
			switch (ans) {
			case 1:
				// Artist.logIn();
				chooseArtistMethod();
				break;
			case 2:
				//Manager.logIn();
				printArtList();
				int artistAns = pickAnArtist();
				chooseManagerMethod();
				break;
			case 3:
				System.out.println("Goodbye");
				exit = true;
			}
		}

	}

	public static void displayHome() {
		System.out.println("Insert 1 for Artist or 2 for Manager 3 to quit the erp");
	}

	public static void printArtistMenu() {
		System.out.println("1. Display Timeline");
		System.out.println("2. Display Ratings/Data");
		System.out.println("3. Register Album");
		System.out.println("4. Log out");
	}

	public static void chooseArtistMethod() {

		boolean logout = false;
		while (logout == false) {
			printArtistMenu();
			int ans = sc.nextInt();
			switch (ans) {
			case 1:
				System.out.println("Displaying Timeline");
				// Artist.displayTimeline();\
				break;
			case 2:
				System.out.println("Displaying Rating/Data");
				// Artist.displayRating;
				break;
			case 3:
				System.out.println("Registering Album");
				break;
			// Artist.registerAlbum;
			case 4:
				System.out.println("Logging out");
				logout = true;
				break;
			}
		}
	}
	
	public static void printArtList() {
	/*	for(int i = 0; i < ArtList.length ; i++) { //ArtList=Artist list to be made
			System.out.println(i+1 + ArtList.getIndex[i].toString ); 
		}		*/
	}
	
	public static int pickAnArtist() {
		System.out.println("Insert artist number"); //+exceptions!!!!!!!!!!!!!!!!!!
		int ans = sc.nextInt();
		return ans;
	}

	public static void printManagerMenu() {
		System.out.println("1. Display Timeline");
		System.out.println("2. Display Leaderboard");
		System.out.println("3. Display Album");
		System.out.println("4. Create a Performance");
		System.out.println("5. Create an Album");
		System.out.println("6. Big boi logout");
	}
	
	public static void chooseManagerMethod() {
		boolean logout = false;
		while (logout == false) {
			printManagerMenu();
			int ans = sc.nextInt();
			switch (ans) {
			case 1:
				System.out.println("Displaying Timeline");   /* to do : actually write methods for the manager 
				not the arttist*/
				
				break;
			case 2:
				System.out.println("Displaying Leaderboard");
		
				break;
			case 3:
				System.out.println("Displaying Album");
				break;
			
			case 4: 
				System.out.println("Creating performance");
				break;
			case 5:
				System.out.println("Creating an Album");
				break;
			case 6:
				System.out.println("Logging out");
				logout = true;
				break;
			}
		}
	}
}

=======
import java.util.Scanner;

public class ClassMain {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		boolean exit = false; 
		while(!exit) {
			displayHome();
			int ans = sc.nextInt(); //
			switch (ans) {
			case 1:
				// Artist.logIn();
				chooseArtistMethod();
				break;
			case 2:
				//Manager.logIn();
				printArtList();
				int artistAns = pickAnArtist();
				chooseManagerMethod();
				break;
			case 3:
				System.out.println("Goodbye");
				exit = true;
			}
		}

	}

	public static void displayHome() {
		System.out.println("Insert 1 for Artist or 2 for Manager 3 to quit the erp");
	}

	public static void printArtistMenu() {
		System.out.println("1. Display Timeline");
		System.out.println("2. Display Ratings/Data");
		System.out.println("3. Register Album");
		System.out.println("4. Log out");
	}

	public static void chooseArtistMethod() {

		boolean logout = false;
		while (logout == false) {
			printArtistMenu();
			int ans = sc.nextInt();
			switch (ans) {
			case 1:
				System.out.println("Displaying Timeline");
				// Artist.displayTimeline();\
				break;
			case 2:
				System.out.println("Displaying Rating/Data");
				// Artist.displayRating;
				break;
			case 3:
				System.out.println("Registering Album");
				break;
			// Artist.registerAlbum;
			case 4:
				System.out.println("Logging out");
				logout = true;
				break;
			}
		}
	}
	
	public static void printArtList() {
	/*	for(int i = 0; i < ArtList.length ; i++) { //ArtList=Artist list to be made
			System.out.println(i+1 + ArtList.getIndex[i].toString ); 
		}		*/
	}
	
	public static int pickAnArtist() {
		System.out.println("Insert artist number"); //+exceptions!!!!!!!!!!!!!!!!!!
		int ans = sc.nextInt();
		return ans;
	}

	public static void printManagerMenu() {
		System.out.println("1. Display Timeline");
		System.out.println("2. Display Leaderboard");
		System.out.println("3. Display Album");
		System.out.println("4. Create a Performance");
		System.out.println("5. Create an Album");
		System.out.println("6. Big boi logout");
	}
	
	public static void chooseManagerMethod() {
		boolean logout = false;
		while (logout == false) {
			printManagerMenu();
			int ans = sc.nextInt();
			switch (ans) {
			case 1:
				System.out.println("Displaying Timeline");   /* to do : actually write methods for the manager 
				not the arttist*/
				
				break;
			case 2:
				System.out.println("Displaying Leaderboard");
		
				break;
			case 3:
				System.out.println("Displaying Album");
				break;
			
			case 4: 
				System.out.println("Creating performance");
				break;
			case 5:
				System.out.println("Creating an Album");
				break;
			case 6:
				System.out.println("Logging out");
				logout = true;
				break;
			}
		}
	}
}


