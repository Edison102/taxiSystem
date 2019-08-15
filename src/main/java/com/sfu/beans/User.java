package com.sfu.beans;

import java.util.Set;

public class User {
	private Integer uid;
	private String name;
	private String password;
	private String phone;
	private int isAdmin;
	
	private Set<Orders> orders;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public User(String name, String password, String phone, int isAdmin) {
		super();
		this.name = name;
		this.password = password;
		this.phone = phone;
		this.isAdmin = isAdmin;
	}




	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	

	public Set<Orders> getOrders() {
		return orders;
	}



	public void setOrders(Set<Orders> orders) {
		this.orders = orders;
	}


	

	public int getIsAdmin() {
		return isAdmin;
	}



	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}



	@Override
	public String toString() {
		return "User [uid=" + uid + ", name=" + name + ", password=" + password
				+ ", phone=" + phone + ", isAdmin=" + isAdmin + ", orders="
				+ orders + "]";
	}


}
