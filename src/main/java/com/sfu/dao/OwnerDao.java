package com.sfu.dao;

import java.util.List;

import com.sfu.beans.Owner;
import org.apache.ibatis.annotations.Param;

public interface OwnerDao {
	List<Owner> quaryAllOwner();
	Owner quaryOwnerById(Integer uid);

	void modifyIsPassByUid(@Param("uid") Integer uid, @Param("is_pass") int is_pass);


	void modifyOwner(Owner owner);
	void addOwner(Owner owner);

	//管理员使用
	int quaryPendingNumbers();
	List<Owner> quaryPendingOwnerByPage(@Param("start")int start, @Param("count")int count);
	int quaryOwnerNumbers();
	List<Owner> quaryOwnerByPage(@Param("start")int start, @Param("count")int count);
}
