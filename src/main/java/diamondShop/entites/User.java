package diamondShop.entites;

import java.sql.Timestamp;

public class User {
	private long id;
	private boolean role;
	private String email;
	private String password;
	private String display_name;
	private String address;
	private String phone;
	private Timestamp created_at;
	private int status;

	public User() {

	}

	public User(long id, boolean role, String email, String password, String display_name, String address, String phone,
			Timestamp created_at, int status) {
		super();
		this.id = id;
		this.role = role;
		this.email = email;
		this.password = password;
		this.display_name = display_name;
		this.address = address;
		this.phone = phone;
		this.created_at = created_at;
		this.status = status;
	}

	public User(long id, boolean role, String email, String password, String display_name, Timestamp created_at) {
		super();
		this.id = id;
		this.role = role;
		this.email = email;
		this.password = password;
		this.display_name = display_name;
		this.created_at = created_at;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public Timestamp getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
