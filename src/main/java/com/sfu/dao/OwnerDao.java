package com.sfu.dao;

import java.util.List;

import com.sfu.beans.Owner;

public interface OwnerDao {
	List<Owner> quaryAllOwner();
	Owner quaryOwnerById(Integer uid);
	
	void updatePassById(Integer uid, boolean is_pass);
	void updateOwner(Owner owner);
	
	void addOwner(Owner owner);
}
