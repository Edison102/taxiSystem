package com.sfu.service;

import java.util.List;

import com.sfu.beans.DispatchInfo;

public interface IDispatchInfoService {
	List<DispatchInfo> selectAllDispatchInfo();
	List<DispatchInfo> selectDispatchInfoByDis(String dis);
	List<DispatchInfo> selectDispatchInfoByUid(Integer uid);
	DispatchInfo selectDispatchInfoById(Integer id);

	int selectAllNumbers();
	List<DispatchInfo> selectDispatchInfoByPage(int start,int count);
	int selectNumbersByUid(Integer uid);
	List<DispatchInfo> selectDispatchInfoByPage(Integer uid,int start,int count);

	void updateDispatchInfo(Integer id);
	void finishDispatchInfo(Integer oid, double payment);
	void finishAllDispatchInfo(Integer id,double payment);
	void insertDispatchInfo(DispatchInfo dispatchInfo);
	boolean aboard(Integer id,Integer uid);
}
