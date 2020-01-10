package javarecords;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Database {

	public static void main(String args[]) throws Exception {
		createTables();
		//viewAlbum();
		//startInserts();
	}

	// CREATE TABLE METHOD

	public static void createTables() {// creates the tables
		try {
			Connection con = getConnection();
			PreparedStatement createlistOfVenues = con
					.prepareStatement("CREATE TABLE IF NOT EXISTS listOfVenues(venueid int,\r\n"
							+ "                           venuename char(30),\r\n"
							+ "						      distanceVenueArtist int,\r\n"
							+ "						      OrganizerName char(30),\r\n"
							+ "                           location char (20),\r\n"
							+ "                           clean decimal(10,2),\r\n"
							+ "                           veninstall decimal(10,2),\r\n"
							+ "                           duration int,\r\n"
							+ "                           cut decimal(10,2),\n\n"
							+ "                           PRIMARY KEY (venueid))");// create listOfVenues table
			PreparedStatement createManagers = con
					.prepareStatement("CREATE TABLE IF NOT EXISTS Managers( managerid int,\r\n"
							+ "							 username char(30),\r\n"
							+ "							 managerpassword char(50),\r\n"
							+ "                          PRIMARY KEY (managerid))");// create listOfManagers table
			
			PreparedStatement createPartners = con
					.prepareStatement("CREATE TABLE IF NOT EXISTS Partners(partname char(20),\r\n"
							+ "								    attribute char(30),\r\n"
							+ "                                    payPerHour decimal(10,2),\r\n"
							+ "                                    PRIMARY KEY (partname)");// create Partner Table

			PreparedStatement createStudios = con
					.prepareStatement("CREATE TABLE IF NOT EXISTS Studios(studioname char(30),\r\n"
							+ "								   pricePerHour decimal(10,2),\r\n"
							+ "                                   PRIMARY KEY (studioname)");// create Studios table
			
			PreparedStatement createArtists = con.prepareStatement("CREATE TABLE IF NOT EXISTS  Artists(\n"
					+ "    artistid int,\n" + "    username char(30) NOT NULL,\n" + "    password char(30),\n"
					+ "    rating decimal(10,2),\n " + "    relevancyIndex decimal(10,2),\n" 
					+ "    payPercentage decimal(10,2)\n," + "    managerid int\n,"

					+ "    PRIMARY KEY (artistid),\n"// create Artists table
			+ "     FOREIGN KEY (managerid) REFERENCES Managers(managerid))\n\n");

			

			PreparedStatement createAlbums = con
					.prepareStatement("CREATE TABLE IF  NOT EXISTS Albums(albumName char(30),\r\n"
							+ "								      pricep decimal(10,2),\r\n"
							+ "                                   priced decimal(10,2),\r\n"
							+ "                                   physical int,\r\n"
							+ "                                   digital int,\r\n"
							+ "                                   artistid int,\r\n"
							+ "                                   completed int,\r\n"
							+ "                                   PRIMARY KEY (albumName),"
							+ "                                   FOREIGN KEY (artistid) REFERENCES Artist(artistid))");// create
																														// Albums
			PreparedStatement createSongs = con
					.prepareStatement("CREATE TABLE IF NOT EXISTS Songs(songname char(30),\r\n"
							+ "								 albumName char(30),\r\n"
							+ "                              PRIMARY KEY (songname, albumname),\r\n"
							+ "								 FOREIGN KEY(albumName) REFERENCES Albums(albumName))");// create
																													// Songs
																													// table
	
			createlistOfVenues.executeUpdate();
			createManagers.executeUpdate();
			createArtists.executeUpdate();
			createAlbums.executeUpdate();
			createSongs.executeUpdate();
			createPartners.executeUpdate();
			createStudios.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	// ADDING METHODS

	public static void addsArtists(int artistid, String username, String password, double rating, double relevancyIndex,
			String genre, double payPercentage, int managerid) {// inserts new artists
		try {
			PreparedStatement statement = (PreparedStatement) getConnection().prepareStatement(
					"INSERT INTO Artists(artistid,username,password,rating,relevancyIndex,genre,payPercentage,managerid) VALUES (?,?,?,?,?,?,?,?)");
			statement.setInt(1, artistid);// adds artistid
			statement.setString(2, username);// addes username
			statement.setString(3, password);// adds password
			statement.setDouble(4, rating);// adds rating
			statement.setDouble(5, relevancyIndex);// adds relevancyIndex
			statement.setString(6, genre);// adds genre
			statement.setDouble(7, payPercentage);// addes payPercentage
			statement.setInt(8, managerid);// adds managerid
			statement.executeUpdate();// execute the insert
			statement.close();
			System.out.println("added succesfully!!!:)");
		} catch (Exception e) {
			System.out.println("Could not add artist to database because it already exists :(");
		}
	}

	public static void addsManagers(int managerid, String username, String password) {// inserts new managers
		try {
			PreparedStatement statement = (PreparedStatement) getConnection()
					.prepareStatement("INSERT INTO Managers(managerid,username,password) VALUES(?,?,?)");
			statement.setInt(1, managerid);// adds managerid
			statement.setString(2, username);// addes username
			statement.setString(3, password);// adds password
			statement.executeUpdate();// execute the insert
			statement.close();
			System.out.println("added succesfully!!!:)");
		} catch (Exception e) {
			System.out.println("Could not add VENUE to database because it already exists :(");
		}
	}

	public static void addsVenues(int venueid, String venuename, int distanceVenueArtist, String OrganizerName,
			String location, double clean, double veninstall, int duration, double cut) {// inserts
																							// new
																							// venues
		try {
			PreparedStatement statement = (PreparedStatement) getConnection().prepareStatement(
					"INSERT INTO listOfVenues(venueid, venuename, distanceVenueArtist, OrganizerName, location, clean, veninstall, duration, cut) VALUES(?,?,?,?,?,?,?,?,?,?,?)");
			statement.setInt(1, venueid);// adds venueid
			statement.setString(2, venuename);// addes venuename
			statement.setInt(3, distanceVenueArtist);// adds distanceVenueArtist
			statement.setString(4, OrganizerName);// adds OrganizerName
			statement.setString(5, location);// addes location
			statement.setDouble(6, clean);// adds clean
			statement.setDouble(7, veninstall);// adds veninstall
			statement.setInt(8, duration);// addes duration
			statement.setDouble(9, cut);// adds cut
			statement.executeUpdate();// execute the insert
			statement.close();
			System.out.println("added succesfully!!!:)");
		} catch (Exception e) {
			System.out.println("Could not add venue to database because it already exists :(");
		}
	}

	public static void addsAlbums(String albumName, double pricep, double priced, int physical, int digital,
			int completed) {// inserts
		// new
		// albums
		try {
			PreparedStatement statement = (PreparedStatement) getConnection().prepareStatement(
					"INSERT INTO Albums(albumName, pricep, priced, physical, digital, completed) VALUES(?,?,?,?,?,?)");
			statement.setString(1, albumName);// adds albumName
			statement.setDouble(2, pricep);// adds pricep
			statement.setDouble(3, priced);// adds priced
			statement.setInt(4, physical);// adds physical
			statement.setInt(5, digital);// adds digital
			statement.setInt(6, completed);// adds completed
			statement.executeUpdate();// execute the insert
			statement.close();
			System.out.println("added succesfully!!!:)");
		} catch (Exception e) {
			System.out.println("Could not add album to database because it already exists :(");
		}
	}

	public static void addsSongs(String songname, String albumName) {// inserts new songs
		try {
			PreparedStatement statement = (PreparedStatement) getConnection()
					.prepareStatement("INSERT INTO Songs(songname, albumName) VALUES(?,?)");
			statement.setString(1, songname);// adds songname
			statement.setString(2, albumName);// adds albumName
			statement.executeUpdate();// execute the insert
			statement.close();
			System.out.println("added succesfully!!!:)");
		} catch (Exception e) {
			System.out.println("Could not add song to database because it already exists :(");
		}
	}

	// VIEW METHODS

	public static void viewAlbum() {// fills Albums arrayList with albums from database
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("SELECT * FROM Albums");
			ResultSet result = statement.executeQuery();
			Artist art = null;
			art.getAlbums().clear();// emptying Albums arraylist to update it
			Album album;
			while (result.next()) {
				album = new Album(findWhichSongs(result.getString("albumName")), result.getString("albumName"),
						result.getDouble("pricep"), result.getDouble("priced"), result.getInt("physical"),
						result.getInt("digital"), result.getInt("completed"));// TODO constructor Album
				art.getAlbums().add(album);// adds new album to the Albums arraylist
			}
			System.out.println("Done!");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void viewAllArtists() {
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("SELECT * FROM Artists");
			ResultSet result = statement.executeQuery();
			Manager man = null;
			man.getArtists().clear();// emptying Artists arraylist to update it
			Artist art;
			while (result.next()) {
				art = new Artist(result.getInt("artistid"), result.getString("username"), result.getString("password"),
						result.getDouble("rating"), result.getDouble("relevancyIndex"),
						findWhichAlbum(result.getInt("artistid")), result.getString("genre"),
						result.getDouble("payPercentage"));
				man.getArtists().add(art);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void viewSongs() {
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("SELECT * FROM Songs");
			ResultSet result = statement.executeQuery();
			Album alb = null;// ???
			alb.getAlbumSongs().clear();// emptying Songs arraylist to update it
			while (result.next()) {
				alb.getAlbumSongs().add(result.getString("songname"));
			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static ArrayList<Artist> viewManagersArtist(int managerid) {// shows all the artists of each manager
		ArrayList<Artist> managersArtists = new ArrayList<Artist>();
		try {
			Connection con = getConnection();
			PreparedStatement statement = con
					.prepareStatement("SELECT * FROM Artists WHERE " + managerid + "=Artists.managerid");
			ResultSet result = statement.executeQuery();
			Manager man = null;
			man.getArtists().clear();// emptying Artists arraylist to update it
			Artist art;
			while (result.next()) {
				art = new Artist(result.getInt("artistid"), result.getString("username"), result.getString("password"),
						result.getDouble("rating"), result.getDouble("relevancyIndex"),
						findWhichAlbum(result.getInt("artistid")), result.getString("genre"),
						result.getDouble("payPercentage"));
				managersArtists.add(art);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return managersArtists;
	}

//METHODS TO FIND STAFFS FROM DATABASES TABLES

	public static boolean credentialsOkArtist(String username, String password) throws Exception {
		Connection con = getConnection();
		PreparedStatement statement = con.prepareStatement("SELECT * FROM ARTISTS WHERE ARTISTS.username="+username);
		ResultSet result = statement.executeQuery();
		if(result.getString("username")==null) {
			return false;
		}else if(result.getString("username")==username&&result.getString("password")=="password") {
			return true;
		}else 
			return false;
		
	}

	public static boolean credentialsOkManager(String username, String password) {
		try {
		Connection con = getConnection();
		PreparedStatement statement = con.prepareStatement("SELECT * FROM MANAGERS WHERE ARTISTS.username="+username);
		ResultSet result = statement.executeQuery();
		if(result.getString("username")==null) {
			return false;
		}else if(result.getString("username")==username&&result.getString("password")=="password") {
			return true;
		}else 
			return false;
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}

	public static Manager returnManager(String onoma) {
		Manager man=null;
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("SELECT * FROM MANAGERS WHERE username=" + onoma);
			ResultSet result = statement.executeQuery();
			man = new Manager(result.getInt("managerid"), result.getString("username"),
					result.getString("managerpassword"), findWhichArtist(result.getInt("managerid")));
		} catch (Exception e) {
			System.out.println(e);
		}
		return man;
	}

	public static Artist returnArtist(String onoma) {
		Artist art=null;
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("SELECT * FROM ARTISTS WHERE username=" + onoma);
			ResultSet result = statement.executeQuery();
			art = new Artist(result.getInt("artistid"), result.getString("username"), result.getString("password"),
					result.getDouble("rating"), result.getDouble("relevancyIndex"),
					findWhichAlbum(result.getInt("artistid")), result.getString("genre"),
					result.getDouble("payPercentage"));
		} catch (Exception e) {
			System.out.println(e);
		}
		return art;
	}

	public static ArrayList<Album> findWhichAlbum(int artistid) {// finds the album for the artist
		ArrayList<Album> Albums = new ArrayList<Album>();// temp album arraylist
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement(
					"SELECT albumName, pricep,priced,physical,digital  FROM Artists, Albums WHERE artistid.Artist=artistid.Albums");
			ResultSet result = statement.executeQuery();
			Album album;
			while (result.next()) {
				album = new Album(findWhichSongs(result.getString("albumName")), result.getString("albumName"),
						result.getDouble("pricep"), result.getDouble("priced"), result.getInt("physical"),
						result.getInt("digital"), result.getInt("completed"));
				Albums.add(album);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return Albums;
	}

	public static ArrayList<Artist> findWhichArtist(int managerid){
		ArrayList<Artist> Artists=new ArrayList<Artist>();
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("SELECT artistid  username  password rating relevancyIndex  genre payPercentage managerid FROM Artists A, MANAGER M WHERE A.managerid=M.managerid");
			ResultSet result = statement.executeQuery();
			Artist art;
			while (result.next()) {
				art=new Artist(result.getInt("artistid"), result.getString("username"), result.getString("password"),
						result.getDouble("rating"), result.getDouble("relevancyIndex"),
						findWhichAlbum(result.getInt("artistid")), result.getString("genre"),
						result.getDouble("payPercentage"));
				Artists.add(art);
			}
	} catch (Exception e) {
		System.out.println(e);
	}
		return Artists;
	}

	public static ArrayList<String> findWhichSongs(String albumName) {
		ArrayList<String> Songs = new ArrayList<String>();// temp songs arraylist
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement(
					"SELECT songname, albumName FROM Songs,Albums WHERE Songs.albumName=ALbum.albumName");
			ResultSet result = statement.executeQuery();
			String song;
			while (result.next()) {
				song = new String(result.getString("songname"));
				Songs.add(song);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return Songs;
	}

//METHOD TO FILL THE DATABASE TABLES

	public static void startInserts() {// adds staffs to the database tables
		addsAlbums("rock", 2.4, 5.86, 345, 4366, 0);
		addsArtists(1, "eminem", "123efvwv", 213.23, 1244.55, "rock", 14.4, 1);
		addsVenues(1, "rockfestival", 505, "mitsos", "SKG", 15.6, 16.6, 13, 13.8);
		addsSongs("TA MATOKLADA SOU LAMPOUN", "rock");
		addsManagers(1, "ela poios", "21e dewcdwe");
		
		addsSongs("Good Times For Me", "The Broken Man");
		addsSongs("Bad Sign Of Hurting", "The Broken Man");
		addsSongs("Desire", "The Broken Man");
		addsSongs("Troubles", "The Broken Man");
		addsSongs("Thunder", "The Broken Man");
		addsSongs("Smile", "The Broken Man");
		addsSongs("Lazy Dreams", "The Broken Man");
		addsSongs("Come on", "The Broken Man");
		addsSongs("Madness", "The Broken Man");
		addsSongs("Cant go on", "The Broken Man");
		addsSongs("Oklahoma", "The Broken Man");
		addsSongs("Do Me A Favour", "The Broken Man");
		addsSongs("Storm", "The Broken Man");
		addsSongs("Past", "The Broken Man");
		addsSongs("Yesterday", "The Broken Man");
		addsSongs("Sunshine", "The Broken Man");
		addsSongs("Soyuncu", "The Broken Man");
		addsSongs("Hometown", "The Broken Man");
		addsSongs("Faded Moon", "The Broken Man");
		addsSongs("Faded River", "The Broken Man");
		addsSongs("Sweet Dreams", "The Broken Man");
		addsSongs("Cowboy", "III");
		addsSongs("Riding Alone", "III");
		addsSongs("Ministry", "III");
		addsSongs("Rodeo", "III");
		addsSongs("Wild Choices", "III");
		addsSongs("Edge", "III");
		addsSongs("Dream On", "III");
		addsSongs("YNWA", "III");
		addsSongs("Crazy", "III");
		addsSongs("Space", "III");
		addsSongs("Bills For The Bills", "III");
		addsSongs("Storyline", "III");
		addsSongs("Honey", "III");
		addsSongs("The Streets", "III");
		addsSongs("Turn", "III");
		addsSongs("Tomorrow", "III");
		addsSongs("Cool Blues", "III");
		addsSongs("Im Feeling Good", "III");
		addsSongs("Charm", "III");
		addsSongs("Travels", "III");
		addsSongs("Together", "III");
		addsSongs("Paradise", "III");
		addsSongs("Eternity", "RAP GOD");
		addsSongs("Forever", "RAP GOD");
		addsSongs("You Can Dance", "RAP GOD");
		addsSongs("Heart Of Your Moment", "RAP GOD");
		addsSongs("Memories", "RAP GOD");
		addsSongs("Sky Of Dreams", "RAP GOD");
		addsSongs("Life Of My Obsession", "RAP GOD");
		addsSongs("Remember My Dance", "RAP GOD");
		addsSongs("Friends Forever", "RAP GOD");
		addsSongs("Golden Dreams", "RAP GOD");
		addsSongs("Magic Romance", "RAP GOD");
		addsSongs("Tender Beats", "RAP GOD");
		addsSongs("Breathe For Another Night", "RAP GOD");
		addsSongs("Moment Of Understanding", "RAP GOD");
		addsSongs("Bliss Of My Promises", "RAP GOD");
		addsSongs("Twisted", "RAP GOD");
		addsSongs("Survival", "RAP GOD");
		addsSongs("Devil", "RAP GOD");
		addsSongs("Remember My Ways", "RAP GOD");
		addsSongs("Fever Dream", "");
		addsSongs("I Wish", "RAP GOD");
		addsSongs("Beast Mode", "RAP GOD");
		addsSongs("Funky", "Dark Poetry");
		addsSongs("Sweet Chances", "Dark Poetry");
		addsSongs("Jamming", "Dark Poetry");
		addsSongs("Sound Of His People", "Dark Poetry");
		addsSongs("I Know You Dont Care", "Dark Poetry");
		addsSongs("Draw", "Dark Poetry");
		addsSongs("Reckless Serenade", "Dark Poetry");
		addsSongs("Wrong", "Dark Poetry");
		addsSongs("Waltz", "Dark Poetry");
		addsSongs("Dark Mode", "Dark Poetry");
		addsSongs("Just Ask", "Dark Poetry");
		addsSongs("Da Frame 2R", "Dark Poetry");
		addsSongs("777", "AM");
		addsSongs("Puzzled", "AM");
		addsSongs("Mad Sounds", "AM");
		addsSongs("Arabella", "AM");
		addsSongs("Summertime", "AM");
		addsSongs("Miracle Aligner", "AM");
		addsSongs("Aviation", "AM");
		addsSongs("Expectations", "AM");
		addsSongs("In My Room", "AM");
		addsSongs("Used To Be My Girl", "AM");
		addsSongs("Mistakes Were Made", "AM");
		addsSongs("TN", "AM");
		addsSongs("Riot Van", "AM");
		addsSongs("Calm Like You", "AM");
		addsSongs("Still Take You Home", "AM");
		addsSongs("Black Treacle", "AM");
		addsSongs("Audacity", "AM");
		addsSongs("Cornerstone", "AM");
		addsSongs("Laserquest", "AM");
		addsSongs("Fireside", "AM");
		addsSongs("Drago", "AM");
		addsSongs("Walk Out", "Dark Poetry");
		addsSongs("Hello!", "Dark Poetry");
		addsSongs("Dancing Shoes", "Dark Poetry");
		addsSongs("Bad Thing", "AM");
		addsSongs("Balaclava", "AM");
		addsSongs("Buses", "Dark Poetry");
		addsSongs("Circus", "Dark Poetry");
		addsSongs("Brianstorm", "AM");
		addsSongs("Teddy Picker", "Dark Poetry");
		addsSongs("Old Yellow Bricks", "Dark Poetry");
		addsSongs("505", "Dark Poetry");
		addsSongs("Romance", "Dark Poetry");
		addsSongs("Mardy Bum", "Dark Poetry");
		addsSongs("Party Anthem 66", "Notion");
		addsSongs("When The Sun Goes Down", "Dark Poetry");
		addsSongs("Bakery", "Dark Poetry");
		addsSongs("Secure", "Dark Poetry");
		addsSongs("Red Lights", "Notion");
		addsSongs("My Propeller", "Notion");
		addsSongs("Moving To New York", "Notion");
		addsSongs("Ice Cream", "Notion");
		addsSongs("Silk", "Notion");
		addsSongs("Icon", "Notion");
		addsSongs("Legend", "Notion");
		addsSongs("Vittorio", "Notion");
		addsSongs("Fresh", "Notion");
		addsSongs("KTLVN", "Notion");
		addsSongs("Avaro", "Notion");
		addsSongs("Heartless", "Notion");
		addsSongs("Roxanne", "Notion");
		addsSongs("G19", "Notion");
		addsSongs("Panic", "Notion");
		addsSongs("Borders","Notion");
		addsSongs("Colpo Grosso", "Notion");
		addsSongs("OCD", "Notion");
		addsSongs("Africa", "Notion");
		addsSongs("Brand", "Notion");
		addsSongs("Sportex", "Every Country's Sun");
		addsSongs("Deja Vu", "Every Country's Sun");
		addsSongs("Down Rodeo", "Every Country's Sun");
		addsSongs("Two Fingers", "Every Country's Sun");
		addsSongs("Golden Skans", "Every Country's Sun");
		addsSongs("Dreams And Nightmares", "Every Country's Sun");
		addsSongs("Panther", "Every Country's Sun");
		addsSongs("Escapade", "Every Country's Sun");
		addsSongs("Loud", "Every Country's Sun");
		addsSongs("Amsterdam", "Every Country's Sun");
		addsSongs("Daewoo", "Every Country's Sun");
		addsSongs("Midnight", "Every Country's Sun");
		addsSongs("Hype", "Every Country's Sun"); 
		addsSongs("Sun", "Every Country's Sun");
		addsSongs("Hoollywood", "Every Country's Sun");
		addsSongs("The Enemy", "Every Country's Sun");
		addsSongs("August", "Every Country's Sun");
		addsSongs("Go Your Own Way", "Every Country's Sun");
		addsSongs("Answer", "Indie Cindy");
		addsSongs("The Middle", "Indie Cindy");
		addsSongs("31", "Indie Cindy");
		addsSongs("Sugar", "Indie Cindy");
		addsSongs("Wait", "Indie Cindy");
		addsSongs("You And I", "Indie Cindy");
		addsSongs("Lord Willing", "Indie Cindy");
		addsSongs("Booming", "Indie Cindy");
		addsSongs("Pretender", "Indie Cindy");
		addsSongs("Cyan", "Indie Cindy");
		addsSongs("2 Weeks", "Indie Cindy");
		addsSongs("Single Again", "Indie Cindy");
		addsSongs("Allez", "El Camino");
		addsSongs("Mosca", "El Camino");
		addsSongs("Sandra", "El Camino"); 
		addsSongs("Returns", "El Camino");
		addsSongs("Options", "El Camino");
		addsSongs("Hate Myself", "El Camino");
		addsSongs("Thinking", "El Camino");
		addsSongs("Change", "El Camino");
		addsSongs("Leave Me Alone", "El Camino");
		addsSongs("Roza", "El Camino");
		addsSongs("Time", "El Camino");
		addsSongs("Good Place", "El Camino");
		addsSongs("Hit", "El Camino");
		addsSongs("F16", "El Camino");
		addsSongs("80s", "El Camino");
		addsSongs("Revenge", "Age of Aquarius");
		addsSongs("Club Poor", "Age of Aquarius");
		addsSongs("Netflix", "Age of Aquarius");
		addsSongs("Stay Safe", "Age of Aquarius");
		addsSongs("Short King", "Age of Aquarius");
		addsSongs("Stolen Dance", "Age of Aquarius");
		addsSongs("Heaven", "Age of Aquarius");
		addsSongs("Funeral", "Age of Aquarius");
		addsSongs("Riptide", "Age of Aquarius");
		addsSongs("Emotionless", "Age of Aquarius");
		addsSongs("Upset", "Indie Cindy");
		addsSongs("Tunnel", "Indie Cindy");
		addsSongs("Cheetah", "Indie Cindy");
		addsSongs("Walk Man", "El Camino");
		addsSongs("Drip", "El Camino");
		addsSongs("Limitless", "El Camino");
		addsSongs("Blessings", "Dark Poetry");
		addsSongs("No Name", "Dark Poetry");
		addsSongs("Business", "III");
		addsSongs("Immortal", "III");
		addsSongs("Neighbors", "III");
		addsSongs("No Favors", "Dark Poetry");
		addsSongs("Land Of The Free", "The Broken Man");
		addsSongs("Babylon", "The Broken Man");
		addsSongs("Trophies", "The Broken Man");
		addsSongs("Flame", "The Broken Man");

		addsVenues(1, "OAKA", 20 , "Giorgos Alexakis","Maroussi",20,50,2,0.4);
		addsVenues(2, "Eclipse", 70 , "Giannos","Thiva",15,40,1,0.25);
		addsVenues(3, "Vex", 150 , "Paris Babis","Patra",18,30,3,0.2);
		addsVenues(4, "Jinx",300 , "Ioannis Petrakis","Ioannina",15,35,1,0.1);
		addsVenues(5, "Forte",650, "Vasilis Giousis","Thessaloniki",25,45,2,0.35);
		addsVenues(6, "Riot",850 , "Stefanos Androulakis","Alexandroupoli",15,25,2,0.1);
		
		addsArtists(1, "Eminem", "123efvwv", 213.23, 1244.55, "rock", 34.40, 2);
		addsArtists(2, "Matt Elliott", "njse792she", 536.92, 862.38, "folk", 22.00, 4);
		addsArtists(3, "Naxatras", "nax123atr45as6", 632.10, 700.78, "psychedelic rock", 24.50, 5);
		addsArtists(4, "Vodka Juniors", "jbbeifh73s", 590.22, 509.32, "hardcore punk", 10.60, 5);
		addsArtists(5, "Tash Sultana", "iuwe7382jn", 702.32, 2344.33, "psychedelic rock", 30.10, 1);
		addsArtists(6, "Mogwai", "JBWEF73HD", 309.44, 904.44, "post rock", 29.30, 3);
		addsArtists(7, "Pixies", "jef73hew7he", 739.34, 2423.10, "alternative rock", 32.30, 2);
		addsArtists(8, "The Black Keys", "jnef67efuw", 832.30, 2938.44, "garage rock", 40.20, 4);
		addsArtists(9, "Arctic Monkeys", "mjinnjue", 943.32, 3034.34, "AM", 50.50, 1);
		addsArtists(10, "Villager's of Ioannina City", "jnwuiefu83", 230.23, 890.34, "folk rock", 18.00, 1);
		
		//0 for not completed album, 1 for completed//
		addsAlbums("RAP GOD", 0, 0, 0, 0, 0);
		addsAlbums("The Broken Man", 4.50, 1.33, 120, 345, 1);
		addsAlbums("III", 2.34, 1.00, 110, 97, 1);
		addsAlbums("Dark Poetry", 2.50, 1.24, 150, 102, 1);
		addsAlbums("Notion", 0, 0, 0, 0, 0);
		addsAlbums("Every Country's Sun", 2.20, 1.15, 203, 309, 1);
		addsAlbums("Indie Cindy", 4.50, 2.56, 403221, 25, 1);
		addsAlbums("El Camino", 4.32, 2.45, 319343, 98344, 1);
		addsAlbums("AM", 5.20, 3.04, 932094, 308234, 1);
		addsAlbums("Age of Aquarius", 0, 0, 0, 0, 0);
		
		
		addsManagers(1, "Frank Johnson", "bsfojbaej2jbu");
		addsManagers(2, "Dave Smith", "nuef8jihuw89");
		addsManagers(3, "Kate Hamilton", "jbiue8ohie8h8hgy6");
		addsManagers(4, "Iris Karanikolaou", "jbuu9e763y63");
		addsManagers(5, "Matt Collins", "kjnwueiy2y3r");
	}

//CONNECTION METHOD

	public static Connection getConnection() {// connecting to database
		try {
			// String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://remotemysql.com:3306/49YiSU5950";
			String username = "49YiSU5950";
			String password = "JCbOC8Tsqd";
			// Class.forName(driver);

			Connection conn = DriverManager.getConnection(url, username, password);
			System.out.println("Connected");
			return conn;
		} catch (Exception e) {
			System.out.println("Could not connect to the Database :(");
			return null;
		}
	}
}