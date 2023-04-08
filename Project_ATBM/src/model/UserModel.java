package model;

public class UserModel {
	private String username, password, DB;

	public UserModel(String username, String password, String DB) {
		super();
		this.username = username;
		this.password = password;
		this.DB = DB;
	}

	public String getDB() {
		return DB;
	}

	public void setDB(String dB) {
		DB = dB;
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

	public void setPassword(String password) {
		this.password = password;
	}
}
