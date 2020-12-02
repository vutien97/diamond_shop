package diamondShop.entites;

public class User {
	private long id;
	private boolean role;
	private String user;
	private String password;
	private String display_name;
	private String address;
	private String phone;

	public User() {

	}

	public User(long id, boolean role, String user, String password, String display_name, String address, String phone) {
		super();
		this.id = id;
		this.role = role;
		this.user = user;
		this.password = password;
		this.display_name = display_name;
		this.address = address;
		this.phone = phone;
	}

	public User(long id, boolean role, String user, String password, String display_name) {
		super();
		this.id = id;
		this.role = role;
		this.user = user;
		this.password = password;
		this.display_name = display_name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isRole() {
		return role;
	}

	public void setRole(boolean role) {
		this.role = role;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDisplay_name() {
		return display_name;
	}

	public void setDisplay_name(String display_name) {
		this.display_name = display_name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
