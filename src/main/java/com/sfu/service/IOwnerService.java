package com.sfu.service;

import com.sfu.beans.Owner;

import java.util.List;

public interface IOwnerService {
	Owner selectOwnerById(Integer uid);

	void insertOwner(Owner owner);
	void updateOwner(Owner owner);

	int selectPendingNumbers();
	List<Owner> selectPendingOwnerByPage(int start, int count);
	int selectOwnerNumbers();
	List<Owner> selectOwnerByPage(int start, int count);

	void judgeIsPassByUid(Integer uid,int is_pass);
	void cancelOwnerByUid(Integer uid);
}
