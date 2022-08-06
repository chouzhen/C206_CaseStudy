public class Account {
	
	// fields
	private String username;
	private String password;
	private String role;
	private boolean isAvailable;
	
	//constructor
	public Account(String username, String password, String role) {
		this.username = username;
		this.password = password;
		this.role = role;
	}
	
	//methods
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
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	public boolean getIsAvailable() {
		return isAvailable;
	}

	public void setIsAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
}
