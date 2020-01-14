
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Database {

	// CREATE TABLE METHOD

	public static void createTables() {// creates the tables (already been executed)
		try {
			Connection con = getConnection();
			PreparedStatement createArtists = con.prepareStatement("CREATE TABLE IF NOT EXISTS  Artists(\n"
					+ "    artistid int,\n" + "    username char(30) NOT NULL,\n" + "    password char(30),\n"
					+ "    rating decimal(10,2),\n " + "    relevancyIndex decimal(10,2),\n"
					+ "    payPercentage decimal(10,2)\n," + "    managerid int\n,"
					+ "     FOREIGN KEY (managerid) REFERENCES Managers(managerid),\n"
					+ "    PRIMARY KEY (artistid))\n\n");// create Artists table

			PreparedStatement createlistOfVenues = con
					.prepareStatement("CREATE TABLE IF NOT EXISTS Venues(venuename char(30),\r\n"
							+ "                                  cost decimal(10,2),\r\n"
							+ "                                  capacity int,\r\n"
							+ "                                  PRIMARY KEY (venuename))");// create Venues table
			PreparedStatement createManagers = con
					.prepareStatement("CREATE TABLE IF NOT EXISTS Managers( managerid int,\r\n"
							+ "							 username char(30),\r\n"
							+ "							 managerpassword char(50),\r\n"
							+ "                          PRIMARY KEY (managerid))");// create listOfManagers table
			PreparedStatement createAlbums = con
					.prepareStatement("CREATE TABLE IF  NOT EXISTS Albums(albumName char(30),\r\n"
							+ "								   pricep decimal(10,2),\r\n"
							+ "                                   priced decimal(10,2),\r\n"
							+ "                                   physical int,\r\n"
							+ "                                   digital int,\r\n"
							+ "                                   artistid int,\r\n"
							+ "                                   completed int,\r\n"
							+ "                                   PRIMARY KEY (albumName),\r\n"
							+ "                                   FOREIGN KEY (artistid) REFERENCES Artists(artistid))");// create
																															// Albums
			PreparedStatement createSongs = con
					.prepareStatement("CREATE TABLE IF NOT EXISTS Songs(songname char(30),\r\n"
							+ "								 albumName char(30),\r\n"
							+ "                              PRIMARY KEY (songname, albumname),\r\n"
							+ "								 FOREIGN KEY(albumName) REFERENCES Albums(albumName))");// create
																													// Songs
																													// table
			PreparedStatement createPartners = con
					.prepareStatement("CREATE TABLE IF NOT EXISTS Partners(partname char(20),\r\n"
							+ "								    attribute char(30),\r\n"
							+ "                                    payPerHour decimal(10,2),\r\n"
							+ "                                    PRIMARY KEY (partname))");// create Partner Table

			PreparedStatement createStudios = con
					.prepareStatement("CREATE TABLE IF NOT EXISTS Studios(studioname char(30),\r\n"
							+ "								   pricePerHour decimal(10,2),\r\n"
							+ "                                   PRIMARY KEY (studioname))");// create Studios table

			PreparedStatement createTimeline = con
					.prepareStatement("CREATE TABLE IF NOT EXISTS Timeline(artistid int,\r\n"
							+ "									imera int,\r\n"
							+ "                                    minas int,\r\n"
							+ "                                    kind char(20),\r\n"
							+ "									FOREIGN KEY (artistid) REFERENCES Artists(artistid))");// create
																														// table
																														// timeline

			createManagers.executeUpdate();
			createArtists.executeUpdate();
			createlistOfVenues.executeUpdate();
			createAlbums.executeUpdate();
			createSongs.executeUpdate();
			createPartners.executeUpdate();
			createStudios.executeUpdate();
			createTimeline.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	// ADDING METHODS

	public static void addsArtists(int artistid, String username, String password, double rating, double relevancyIndex,
			double payPercentage, int managerid) {// inserts new artists
		try {
			PreparedStatement statement = (PreparedStatement) getConnection().prepareStatement(
					"INSERT INTO Artists(artistid,username,password,rating,relevancyIndex,payPercentage,managerid) VALUES (?,?,?,?,?,?,?)");
			statement.setInt(1, artistid);// adds artistid
			statement.setString(2, username);// addes username
			statement.setString(3, password);// adds password
			statement.setDouble(4, rating);// adds rating
			statement.setDouble(5, relevancyIndex);// adds relevancyIndex
			statement.setDouble(6, payPercentage);// addes payPercentage
			statement.setInt(7, managerid);// adds managerid
			statement.executeUpdate();// execute the insert
			statement.close();
			System.out.println("added succesfully!!!:)");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void addsManagers(int managerid, String username, String password) {// inserts new managers
		try {
			PreparedStatement statement = (PreparedStatement) getConnection()
					.prepareStatement("INSERT INTO Managers VALUES(?,?,?)");
			statement.setInt(1, managerid);// adds managerid
			statement.setString(2, username);// addes username
			statement.setString(3, password);// adds password
			statement.executeUpdate();// execute the insert
			statement.close();
			System.out.println("added succesfully!!!:)");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void addsVenues(double cost, String name, int capacity) {// inserts
																			// new
																			// venues
		try {
			PreparedStatement statement = (PreparedStatement) getConnection()
					.prepareStatement("INSERT INTO Venues(venuename,cost,capacity) VALUES(?,?,?)");
			statement.setString(1, name);// adds venueid
			statement.setDouble(2, cost);// addes venuename
			statement.setInt(3, capacity);// adds distanceVenueArtist
			statement.executeUpdate();// execute the insert
			statement.close();
			System.out.println("added succesfully!!!:)");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void addsAlbums(String albumName, double pricep, double priced, int physical, int digital,
			int artistid, int completed) {// inserts
		// new
		// albums
		try {

			PreparedStatement statement = (PreparedStatement) getConnection().prepareStatement(
					"INSERT INTO Albums(albumName, pricep, priced, physical, digital,artistid, completed) VALUES(?,?,?,?,?,?,?)");
			statement.setString(1, albumName);// adds albumName
			statement.setDouble(2, pricep);// adds pricep
			statement.setDouble(3, priced);// adds priced
			statement.setInt(4, physical);// adds physical
			statement.setInt(5, digital);// adds digital
			statement.setInt(6, artistid);// adds artistid
			statement.setInt(7, completed);// adds completed
			statement.executeUpdate();// execute the insert
			statement.close();
			System.out.println("added succesfully!!!:)");
			Album album = new Album(albumName, pricep, priced, physical, artistid, completed, completed);
			findWhichAlbum(artistid).add(album);

		} catch (Exception e) {
			e.printStackTrace();
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
			System.out.println(e);
		}
	}

	public static void addsPartners(String name, String attribute, Double payPerHour) {
		try {
			PreparedStatement statement = (PreparedStatement) getConnection()
					.prepareStatement("INSERT INTO Partners(partname,attribute,payPerHour) VALUES(?,?,?)");
			statement.setString(1, name);// adds name of the partner
			statement.setString(2, attribute);// adds the attribute
			statement.setDouble(3, payPerHour);// adds payPerHour
			statement.executeUpdate();// execute the insert
			statement.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void addsStudios(String name, Double pricePerHour) {
		try {
			PreparedStatement statement = (PreparedStatement) getConnection()
					.prepareStatement("INSERT INTO Studios(studioname,pricePerHour) VALUES(?,?)");
			statement.setString(1, name);// adds name of the studio
			statement.setDouble(2, pricePerHour);// adds priceperHour
			statement.executeUpdate();// execute the insert
			statement.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void addsEvent(int artistid, int imera, int minas, String kind) {// kind can be production or
																					// performance
		try {
			PreparedStatement statement = (PreparedStatement) getConnection()
					.prepareStatement("INSERT INTO Timeline(artistid, imera, minas, kind) VALUES (?,?,?,?)");
			statement.setInt(1, artistid);// adds artistid
			statement.setInt(2, imera);// adds day
			statement.setInt(3, minas);// adds month
			statement.setString(4, kind);// adds kind
			statement.executeUpdate();// execute the insert
			statement.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

//METHODS TO FIND STAFFS FROM DATABASES TABLES

	public static Artist findArtist(int artistid) throws Exception {// finds Artist with the giver artistid
		Connection con = getConnection();
		PreparedStatement statement = con.prepareStatement("SELECT * FROM Artists  WHERE artistid=" + artistid);
		ResultSet result = statement.executeQuery();
		result.beforeFirst();
		result.next();
		Artist art = new Artist(result.getInt("artistid"), result.getString("username"), result.getString("password"),
				result.getDouble("rating"), result.getDouble("relevancyIndex"), result.getDouble("payPercentage"));
		con.close();
		return art;

	}

	public static ArrayList<Album> findWhichAlbum(int artistid) throws Exception {// finds the albums of the artist with
																					// given artistid
		ArrayList<Album> Albums = new ArrayList<Album>();// arraylist of albums
		Connection con = getConnection();
		PreparedStatement statement = con.prepareStatement("SELECT * FROM Albums WHERE artistid= " + artistid);
		ResultSet result = statement.executeQuery();
		Album album;
		while (result.next()) {
			album = new Album(result.getString("albumName"), result.getInt("artistid"), result.getInt("completed"));
			Albums.add(album);// adds album to the arraylist
		}
		con.close();
		return Albums;

	}

	public static ArrayList<String> findWhichSongs(String albumName) throws Exception {
		ArrayList<String> Songs = new ArrayList<String>();// arraylist of songs

		Connection con = getConnection();
		PreparedStatement statement = con.prepareStatement("SELECT * FROM Songs WHERE albumName ='" + albumName + "'");
		ResultSet result = statement.executeQuery();
		String song;
		while (result.next()) {
			song = result.getString("songname");
			Songs.add(song);
		}
		con.close();
		return Songs;
	}

	public static ArrayList<Venues> returnVenues() throws Exception {// returns all the events
		ArrayList<Venues> venues = new ArrayList<Venues>();
		Connection con = getConnection();
		PreparedStatement statement = con.prepareStatement("SELECT * FROM Venues");
		ResultSet result = statement.executeQuery();
		Venues venue = null;// initialize
		while (result.next()) {
			venue = new Venues(result.getDouble("cost"), result.getString("venuename"), result.getInt("capacity"));
			venues.add(venue);
		}
		con.close();
		return venues;
	}

	public static Album findAlbumByName(String albumName) throws Exception {// finds the album with the given albumname
		Connection con = getConnection();
		PreparedStatement statement = con.prepareStatement("SELECT * FROM Albums WHERE albumName='" + albumName + "'");
		ResultSet result = statement.executeQuery();
		Album alb = null;
		while (result.next()) {
			alb = new Album(result.getString("albumName"), result.getInt("artistid"), result.getInt("completed"));
		}
		con.close();
		return alb;
	}

	public static int findNumberOfSongs(String albumName) throws Exception {// finds numbers of songs that exist in the
																			// album with the given albumname
		Connection con = getConnection();
		PreparedStatement statement = con.prepareStatement("SELECT * FROM Songs WHERE albumName='" + albumName + "'");
		ResultSet result = statement.executeQuery();
		int count = 0;
		while (result.next()) {
			count += 1;
		}
		con.close();
		return count;
	}

	public static boolean credentialsOkArtist(String username, String password) throws Exception {// checks if the
																									// username and
																									// paasword of the
																									// artist is ok
		try {
			Connection con = getConnection();
			PreparedStatement statement = con
					.prepareStatement("SELECT * FROM Artists WHERE username='" + username + "'");
			ResultSet result = statement.executeQuery();
			boolean foundAUser = false;
			boolean credsOk = false;
			while (result.next()) {
				String correctUsername = result.getString(2);
				String correctPassword = result.getString(3);
				System.out.println(correctUsername + "pass " + correctPassword);
				System.out.println("GIVEN" + username + " pass " + password);
				if (correctUsername.equalsIgnoreCase(username) && correctPassword.equalsIgnoreCase(password)) {// its
																												// all
																												// good
					System.out.println("found both");
					System.out.println(returnArtist(username));
					credsOk = true;
					return true;
				} else// something is wrong

					System.out.println("else");
			}
			con.close();
			return credsOk;
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("finished");
		return false;

	}

	public static boolean credentialsOkManager(String username, String password) {// checks if the username and password
																					// of the manager is ok
		try {
			Connection con = getConnection();
			PreparedStatement statement = con
					.prepareStatement("SELECT * FROM Managers WHERE username='" + username + "'");
			ResultSet result = statement.executeQuery();
			boolean foundAUser = false;
			boolean credsOk = false;
			while (result.next()) {
				String correctUsername = result.getString(2);
				String correctPassword = result.getString(3);
				System.out.println(correctUsername + "pass " + correctPassword);
				System.out.println("GIVEN" + username + " pass " + password);
				if (correctUsername.equalsIgnoreCase(username) && correctPassword.equalsIgnoreCase(password)) {// its
																												// all
																												// good
					System.out.println("found both");
					System.out.println(returnManager(username));
					credsOk = true;
					return true;
				} else// something is wrong

					System.out.println("else");
			}
			con.close();
			return credsOk;
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("finished");
		return false;
	}

	public static Manager returnManager(String onoma) {// returns manager with the given name
		Manager man = null;
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("SELECT * FROM Managers WHERE username='" + onoma + "'");
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				man = new Manager(result.getInt("managerid"), result.getString("username"),
						result.getString("managerpassword"), findWhichArtist(result.getInt("managerid")));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return man;
	}

	public static Artist returnArtist(String onoma) {// returns artist with the given name
		Artist art = null;
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("SELECT * FROM Artists WHERE username='" + onoma + "'");
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				art = new Artist(result.getInt("artistid"), result.getString("username"), result.getString("password"),
						result.getDouble("rating"), result.getDouble("relevancyIndex"),
						result.getDouble("payPercentage"));
			}
			System.out.println("Artist beign returned from db " + art.toString());
		} catch (Exception e) {
			System.out.println(e);
		}
		return art;
	}

	public static ArrayList<Artist> findWhichArtist(int managerid) {// finds artists that been managered from the
																	// manager with the given managerid
		ArrayList<Artist> Artists = new ArrayList<Artist>();
		Artist art;
		try {
			Connection con = getConnection();
			PreparedStatement statement = con
					.prepareStatement("SELECT * FROM Artists WHERE managerid='" + managerid + "'");
			ResultSet result = statement.executeQuery();

			while (result.next()) {
				art = new Artist(result.getInt("artistid"), result.getString("username"), result.getString("password"),
						result.getDouble("rating"), result.getDouble("relevancyIndex"),
						result.getDouble("payPercentage"));
				Artists.add(art);
			}
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
		return Artists;
	}

	public static int returnArtistid(String name) {// returns artistid base to the given username of the artist
		int id = 0;
		try {
			Connection con = getConnection();
			PreparedStatement statement = con
					.prepareStatement("SELECT artistid FROM Artists WHERE username='" + name + "'");
			ResultSet result = statement.executeQuery();
			result.beforeFirst();
			result.next();
			id = result.getInt("artistid");
		} catch (Exception e) {
			System.out.println(e);
		}
		return id;
	}

	public static ArrayList<Partner> returnPartners() {// return alla partners
		Partner part;
		ArrayList<Partner> partners = new ArrayList<Partner>();
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("SELECT * FROM Partners");
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				part = new Partner(result.getString("partname"), result.getString("attribute"),
						result.getDouble("payPerHour"));
				partners.add(part);
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		return partners;

	}

	public static ArrayList<Studio> returnStudios() {// return all studios
		Studio stud;
		ArrayList<Studio> studios = new ArrayList<Studio>();
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("SELECT * FROM Studios");
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				stud = new Studio(result.getString("studioname"), result.getDouble("pricePerHour"));
				studios.add(stud);
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return studios;

	}

	public static ArrayList<Event> returnEvent(int artistid) {// return the events of oine artist with the given
																// artistid
		ArrayList<Event> events = new ArrayList<Event>();
		Event event;
		try {
			Connection con = getConnection();
			PreparedStatement statement = con
					.prepareStatement("SELECT * FROM Timeline WHERE artistid='" + artistid + "'");
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				event = new Event(result.getInt("artistid"), result.getInt("imera"), result.getInt("minas"),
						result.getString("kind"));
				events.add(event);
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return events;
	}

	// Methods to update tables

	public static void updateAlbum(String albumname, double pricep, double priced, int physical, int digital,
			int artistid, int completed) {// update an insert in the album table in the database
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement(
					"UPDATE Albums\r\n" + "SET albumName ='" + albumname + "'" + ", pricep = " + pricep + ",priced = "
							+ priced + " ,physical = " + physical + " ,digital = " + digital + " ,artistid = "
							+ artistid + " ,completed = " + completed + "\r\n" + "WHERE albumName='" + albumname + "'");
			statement.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static Connection getConnection() throws Exception {// connecting to database
		try {
			// String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://remotemysql.com:3306/49YiSU5950";
			String username = "49YiSU5950";
			String password = "JCbOC8Tsqd";
			// Class.forName(driver);

			Connection conn = DriverManager.getConnection(url, username, password);
			// System.out.println("Connected");
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Could not connect to database! AT THE GET CONNECTION METHOD");
			return null;
		}

	}

	// METHOD TO FILL THE DATABASE TABLES

	public static void startInserts() {// adds staffs to the database tables (already been executed)

		// adds new Managers

		addsManagers(1, "Frank Johnson", "bsfojbaej2jbu");
		addsManagers(2, "Dave Smith", "nuef8jihuw89");
		addsManagers(3, "Kate Hamilton", "jbiue8ohie8h8hgy6");
		addsManagers(4, "Iris Karanikolaou", "jbuu9e763y63");
		addsManagers(5, "Matt Collins", "kjnwueiy2y3r");

		// adds new Venues

		addsVenues(40000.00, "again n again", 5000);
		addsVenues(1005000.00, "bees travel", 30000);
		addsVenues(5000.00, "OHHH", 5500);
		addsVenues(15000.00, "kosni", 7000);

		// adds new Artists

		addsArtists(1, "Eminem", "123efvwv", 213.23, 1244.55, 34.40, 2);
		addsArtists(2, "Matt Elliott", "njse792she", 536.92, 862.38, 22.00, 4);
		addsArtists(3, "Naxatras", "nax123atr45as6", 632.10, 700.78, 24.50, 5);
		addsArtists(4, "Vodka Juniors", "jbbeifh73s", 590.22, 509.32, 10.60, 5);
		addsArtists(5, "Tash Sultana", "iuwe7382jn", 702.32, 2344.33, 30.10, 1);
		addsArtists(6, "Mogwai", "JBWEF73HD", 309.44, 904.44, 29.30, 3);
		addsArtists(7, "Pixies", "jef73hew7he", 739.34, 2423.10, 32.30, 2);
		addsArtists(8, "The Black Keys", "jnef67efuw", 832.30, 2938.44, 40.20, 4);
		addsArtists(9, "Arctic Monkeys", "mjinnjue", 943.32, 3034.34, 50.50, 1);
		addsArtists(10, "Villager's of Ioannina City", "jnwuiefu83", 230.23, 890.34, 18.00, 1);

		// adds new Albums (0 for register and 1for completed album)

		addsAlbums("RAP GOD", 0, 0, 0, 0, 1, 0);
		addsAlbums("The Broken Man", 4.50, 1.33, 120, 345, 3, 1);
		addsAlbums("III", 2.34, 1.00, 110, 97, 5, 1);
		addsAlbums("Dark Poetry", 2.50, 1.24, 150, 102, 2, 1);
		addsAlbums("Notion", 0, 0, 0, 0, 6, 0);
		addsAlbums("Every Country's Sun", 2.20, 1.15, 203, 309, 9, 1);
		addsAlbums("Indie Cindy", 4.50, 2.56, 403221, 25, 10, 1);
		addsAlbums("El Camino", 4.32, 2.45, 319343, 98344, 7, 1);
		addsAlbums("AM", 5.20, 3.04, 932094, 308234, 8, 1);
		addsAlbums("Age of Aquarius", 0, 0, 0, 0, 5, 0);
		addsAlbums("AEK", 324, 340, 3, 32, 1, 0);

		// adds new Partners

		addsPartners("John Papanikolaou", "Vocals", 0.03);
		addsPartners("Stefanos Dibler", "Tromponi", 0.025);
		addsPartners("Thanases Alexandris", "Piano", 0.035);
		addsPartners("Lang Lang", "Piano", 0.05);
		addsPartners("James Galway", "Flute", 0.03);
		addsPartners("David Xyn", "Drams", 0.01);
		addsPartners("Chris James", "Vocals", 0.013);
		addsPartners("Lady Gigi", "Guitar", 0.02);
		addsPartners("Giannis Psaras", "Electric Guitar", 0.03);

		// adds new Studios

		addsStudios("Xoros Melodias", 200.00);
		addsStudios("Sound Quality", 250.00);
		addsStudios("Spinning Records", 449.00);

		// adds new songs

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
		addsSongs("Borders", "Notion");
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

	}
}