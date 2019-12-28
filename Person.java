
public class Person {
	private String username;
	private String password;
	static private int id;
	
	public Person(String username, String password) {
		super();
		this.username = username;
		this.password = password;
		Person.id=id++; //If this was : this.id=id++ there would have been "field should be accessed in a static way" error ask @N-georgakopoulos
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void getPassword(String password) {
		this.password = password;
	}

}

=======

public class Person {
	private String username;
	private String password;
	static private int id;
	
	public Person(String username, String password) {
		super();
		this.username = username;
		this.password = password;
		Person.id=id++; //If this was : this.id=id++ there would have been "field should be accessed in a static way" error ask @N-georgakopoulos
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void getPassword(String password) {
		this.password = password;
	}

}

