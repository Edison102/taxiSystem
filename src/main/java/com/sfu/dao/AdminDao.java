package com.sfu.dao;

import java.util.List;

import com.sfu.beans.Admin;

public interface AdminDao {
	List<Admin> quaryAllAdmin();
	
	void addAdmin(Admin admin);
	void updateAdmin(Admin admin);
	
	void deleteById(Integer aid);
}
