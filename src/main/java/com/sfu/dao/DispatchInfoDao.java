package com.sfu.dao;

import java.util.List;

import com.sfu.beans.DispatchInfo;

public interface DispatchInfoDao {
	List<DispatchInfo> quaryAllDispatchInfo();
	List<DispatchInfo> quaryDispatchInfoByDis(String dis);
	List<DispatchInfo> quaryDispatchInfoByUid(Integer uid);
	
	DispatchInfo quaryDispatchInfoById(Integer id);
	
	void modifyDispatchInfoById(Integer id);
	
	void finishDispatchInfoById(Integer id);
	
	void addDispatchInfo(DispatchInfo dispatchInfo);
}
