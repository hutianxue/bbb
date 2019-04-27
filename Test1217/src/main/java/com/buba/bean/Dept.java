package com.buba.bean;

public class Dept {
	private int id;
	private String deptName;
	private String deptCode;
	private double avgMoney;
	private int maxMoney;
	@Override
	public String toString() {
		return "Dept [id=" + id + ", deptName=" + deptName + ", deptCode=" + deptCode + ", avgMoney=" + avgMoney
				+ ", maxMoney=" + maxMoney + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public double getAvgMoney() {
		return avgMoney;
	}
	public void setAvgMoney(double avgMoney) {
		this.avgMoney = avgMoney;
	}
	public int getMaxMoney() {
		return maxMoney;
	}
	public void setMaxMoney(int maxMoney) {
		this.maxMoney = maxMoney;
	}
}
