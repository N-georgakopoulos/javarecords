package application.executiveClasses;

public class Person {
	private String username;
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Person(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
}
