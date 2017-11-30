package edu.sdp.com.entities;

public class User {
	// | id | username | password | email |
	private Integer id;
	private String username;
	private String password;
	private String eamil;
	public User() {
		super();
	}
	public User(Integer id, String username, String password, String eamil) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.eamil = eamil;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public String getEamil() {
		return eamil;
	}
	public void setEamil(String eamil) {
		this.eamil = eamil;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", eamil=" + eamil + "]";
	}
	
}
