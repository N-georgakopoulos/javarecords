
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Database {

	public static void main(String args[]) throws Exception {
		createTables();
	}

	public static void createTables() {
		// SQL statement for creating a new table
		try {
			Connection con = getConnection();
			PreparedStatement createArtists = con.prepareStatement("CREATE TABLE IF NOT EXISTS  Artists(\n" + "    id int,\n"
					+ "    username char(30) NOT NULL,\n" + "    password char(30),\n" + "    rating decimal(10,2),\n "
					+ "    relevancyIndex decimal(10,2),\n" + "    genre char(20),\n"
					+ "    payPercentage decimal(10,2)\n," + "    img char(30)\n," + "     PRIMARY KEY (id))\n\n");//create Artists table
			
			PreparedStatement createlistOfVenues = con.prepareStatement( "CREATE TABLE IF NOT EXISTS listOfVenues( venuesname char(30),\r\n"
					+ "						   distanceVenueArtist int,\r\n"
					+ "						   OrganizerName char(30),\r\n"
					+ "                           Ventype char(50),\r\n"
					+ "                           style char(50),\r\n"
					+ "                           location char (20),\r\n"
					+ "                           clean char(30),\r\n"
					+ "                           veninstall char(20),\r\n"
					+ "                           duration int,\r\n" 
					+ "                           cut char(20))\n\n");//create listOfVenues table
			PreparedStatement createlistOfManagers = con.prepareStatement( "CREATE TABLE IF NOT EXISTS listOfManagers( username char(30),\r\n" 
					+ "							 password char(50))");// create listOfManagers table
			PreparedStatement createAlbums = con.prepareStatement( "CREATE TABLE IF  NOT EXISTS Albums(albumName char(30),\r\n" + 
					"								   pricep decimal(10,2),\r\n" + 
					"                                   priced decimal(10,2),\r\n" + 
					"                                   physical int,\r\n" + 
					"                                   digital int,\r\n" + 
					"                                   PRIMARY KEY (albumName))");
			PreparedStatement createSongs = con.prepareStatement("CREATE TABLE IF NOT EXISTS Songs(songname char(30),\r\n" + 
					"								 albumName char(30),\r\n" + 
					"								 FOREIGN KEY(albumName) REFERENCES Albums(albumName))");
			
			createArtists.executeUpdate();
			createlistOfVenues.executeUpdate();
			createlistOfManagers.executeUpdate();
			createAlbums.executeUpdate();
			createSongs.executeUpdate();
		} catch (Exception e) {
			System.out.println("Something went wrong :(");
		}

	}

	public static void post(String username, String password) {
		try {
			PreparedStatement statement = (PreparedStatement) getConnection()
					.prepareStatement("INSERT INTO artists(username,password) VALUES(?,?)");
			statement.setString(1, username);// adds useranem
			statement.setString(2, password);// addes password
			statement.executeUpdate();// execute
			statement.close();
			getConnection().close();
			System.out.println("Done!");
		} catch (Exception e) {
			System.out.println("Something went wrong :(");
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
			System.out.println("Connected");
			return conn;
		} catch (Exception e) {
			System.out.println("Something went wrong :(");
			return null;
		}
	}
}
