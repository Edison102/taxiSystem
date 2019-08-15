package com.sfu.service;

import java.util.List;

import com.sfu.beans.DispatchInfo;

public interface IDispatchInfoService {
	List<DispatchInfo> selectAllDispatchInfo();
	List<DispatchInfo> selectDispatchInfoByDis(String dis);
	List<DispatchInfo> selectDispatchInfoByUid(Integer uid);
	DispatchInfo selectDispatchInfoById(Integer id);
	void updateDispatchInfo(Integer id);
	void finishDispatchInfo(Integer did, Integer oid, double payment);
	void insertDispatchInfo(DispatchInfo dispatchInfo);
}
