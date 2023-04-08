package model;

public class UserModel {
	private static UserModel instance = null;
	private static String username, password, DB;
	private static Boolean isCommonUser;

	private UserModel(String username, String password, String DB) {
		super();
		UserModel.username = username;
		UserModel.password = password;
		UserModel.DB = DB;
		if (UserModel.username.length() > 3 && UserModel.username.substring(0, 3).equalsIgnoreCase("C##")) {
			UserModel.isCommonUser = true;
		} else {
			UserModel.isCommonUser = false;
		}
	}

	public static UserModel getInstance(String username, String password, String DB) {
		if (instance == null) {
			instance = new UserModel(username, password, DB);
			System.out.println("Hello 1");
		}
		return instance;
	}

	public Boolean getIsCommonUser() {
		return isCommonUser;
	}

	public void setIsCommonUser(Boolean isCommonUser) {
		UserModel.isCommonUser = isCommonUser;
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
		UserModel.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		UserModel.password = password;
	}
}
