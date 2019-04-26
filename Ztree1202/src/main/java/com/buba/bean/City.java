package com.buba.bean;

public class City {
	private int id;
	private String name;
	private boolean isParent=true;
	private int pid;
	private boolean open;
	public boolean getOpen() {
		return true;
	}
	public void setOpen(boolean open) {
		this.open = open;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public boolean getIsParent() {
		return isParent;
	}
	public void setIsParent(boolean isParent) {
		this.isParent = isParent;
	}
	@Override
	public String toString() {
		return "City [id=" + id + ", name=" + name + ", pid=" + pid + "]";
	}
	
}
