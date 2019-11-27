
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Database {

	public static void main(String args[]) throws Exception {
		post("Giannis", "1234566");// adds an artist to the array
	}

	public static void post(String username, String password) {//adds artists to the astists array
		try {
			PreparedStatement statement = (PreparedStatement) getConnection()
					.prepareStatement("INSERT INTO artists(username,password) VALUES(?,?)");
			statement.setString(1, username);//adds useranem
			statement.setString(2, password);//addes password
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
