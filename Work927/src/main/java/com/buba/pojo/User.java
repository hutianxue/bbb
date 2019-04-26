package com.buba.pojo;

public class User {
	private String id;
	private String usercode;
	private String username;
	private String password;
	private String level;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsercode() {
		return usercode;
	}
	public void setUsercode(String usercode) {
		this.usercode = usercode;
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
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", usercode=" + usercode + ", username=" + username + ", password=" + password
				+ ", level=" + level + "]";
	}
}
