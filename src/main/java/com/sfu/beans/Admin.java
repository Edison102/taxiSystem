package com.sfu.beans;

public class Admin {
	private Integer aid;
	private String name;
	private String password;
	
	
	
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Admin(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}


	public Integer getAid() {
		return aid;
	}
	public void setAid(Integer aid) {
		this.aid = aid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Admin [aid=" + aid + ", name=" + name + ", password="
				+ password + "]";
	}
	
	
	
}
