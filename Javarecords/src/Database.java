
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Database {

	public static void main(String args[]) throws Exception {
		createTables();
		viewAlbum();
		startInserts();
	}

	// CREATE TABLE METHOD

	public static void createTables() {// creates the tables
		try {
			Connection con = getConnection();
			PreparedStatement createArtists = con.prepareStatement("CREATE TABLE IF NOT EXISTS  Artists(\n"
					+ "    artistid int,\n" + "    username char(30) NOT NULL,\n" + "    password char(30),\n"
					+ "    rating decimal(10,2),\n " + "    relevancyIndex decimal(10,2),\n" + "    genre char(20),\n"
					+ "    payPercentage decimal(10,2)\n," + "    managerid int\n,"
					+ "     FOREIGN KEY (managerid) REFERENCES Managers(managerid),\n"
					+ "    PRIMARY KEY (artistid))\n\n");// create Artists table

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
			PreparedStatement createPartners = con
					.prepareStatement("CREATE TABLE IF NOT EXISTS Partners(partname char(20),\r\n"
							+ "								    attribute char(30),\r\n"
							+ "                                    payPerHour decimal(10,2),\r\n"
							+ "                                    PRIMARY KEY (partname)");//create Partner Table

			PreparedStatement createStudios = con
					.prepareStatement("CREATE TABLE IF NOT EXISTS Studios(studioname char(30),\r\n"
							+ "								   pricePerHour decimal(10,2),\r\n"
							+ "                                   PRIMARY KEY (studioname)");//create Studios table

			createArtists.executeUpdate();
			createlistOfVenues.executeUpdate();
			createManagers.executeUpdate();
			createAlbums.executeUpdate();
			createSongs.executeUpdate();
			createPartners.executeUpdate();
			createStudios.executeUpdate();
		} catch (Exception e) {
			System.out.println("Something went wrong :(");
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
	}

//CONNECTION METHOD

	public static Connection getConnection() throws Exception {// connecting to database
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
			System.out.println("Something went wrong :(");
			return null;
		}
	}
}
