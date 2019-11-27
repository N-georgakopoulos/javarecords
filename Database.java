
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Database {

	public static void main(String args[]) throws Exception {
		createAlbum();
		createArtist();
		inserttoartist("Lady GAGA", "pop");// adds an artist to the array
	}

	public static void createAlbum() throws Exception {//createAlbum
		try {
		Connection con = getConnection();
		PreparedStatement create = con.prepareStatement("CREATE TABLE IF NOT EXISTS ALBUM(numberofsongs int, artistname char(30))");
		create.executeUpdate();
		}catch(Exception e) {
			System.out.println("Couldn'n create table);
		}finally {
			 System.out.println("Function completed!");
		}
	}
	
	public static void createArtist() throws Exception {//createArtist
		try {
		Connection con = getConnection();
		PreparedStatement create = con.prepareStatement("CREATE TABLE IF NOT EXISTS ARTISTS(aname char(30),kind char(30))");
		create.executeUpdate();
		}catch(Exception e) {
			System.out.println("Couldn'n create table);
		}finally {
			 System.out.println("Function completed!");
		}
	}
	
	
	public static void post(String aname, String kind) {//adds artists to the astists array
		try {
			PreparedStatement statement = (PreparedStatement) getConnection()
					.prepareStatement("INSERT INTO ARTISTS(aname,kind) VALUES(?,?)");
			statement.setString(1, aname);//adds useranem
			statement.setString(2, kind);//addes password
			statement.executeUpdate();//execute 
			statement.close();
			getConnection().close();
			System.out.println("Done!");
		} catch (Exception e) {
			System.out.println("Something went wrong :(");
		}
	}

	public static Connection getConnection() throws Exception {//connecting to database
		try {
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://remotemysql.com:3306/H8UkwVGHXz";
			String username = "H8UkwVGHXz";
			String password = "Jjve2Zejdy";
			Class.forName(driver);

			Connection conn = DriverManager.getConnection(url, username, password);
			System.out.println("Connected");
			return conn;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
}
