package com.buba.bean;

public class User {
	private int id;
	private String userName;
	private String userAge;
	private int userMoney;
	private int deptId;
	private String deptName;
	private String deptCode;
	private double avgMoney;
	private int maxMoney;
	public int getMaxMoney() {
		return maxMoney;
	}
	public void setMaxMoney(int maxMoney) {
		this.maxMoney = maxMoney;
	}
	public double getAvgMoney() {
		return avgMoney;
	}
	public void setAvgMoney(double avgMoney) {
		this.avgMoney = avgMoney;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserAge() {
		return userAge;
	}
	public void setUserAge(String userAge) {
		this.userAge = userAge;
	}
	public int getUserMoney() {
		return userMoney;
	}
	public void setUserMoney(int userMoney) {
		this.userMoney = userMoney;
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getDeptCode() {
		return deptCode;
	}
	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", userAge=" + userAge + ", userMoney=" + userMoney
				+ ", deptId=" + deptId + ", deptName=" + deptName + ", deptCode=" + deptCode + "]";
	}
}
