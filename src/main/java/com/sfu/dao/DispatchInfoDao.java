package com.sfu.dao;

import java.util.List;

import com.sfu.beans.DispatchInfo;
import org.apache.ibatis.annotations.Param;

public interface DispatchInfoDao {
	List<DispatchInfo> quaryAllDispatchInfo();
	List<DispatchInfo> quaryDispatchInfoByDis(String dis);
	List<DispatchInfo> quaryDispatchInfoByUid(Integer uid);

	//分页使用
	int quaryAllNumbers();
	List<DispatchInfo> quaryDispatchInfoByPage(@Param("start")int start, @Param("count")int count);

	//分页使用
	int quaryNumbersByUid(Integer uid);
	List<DispatchInfo> quaryDispatchInfoByPageAndUid(@Param("uid")Integer uid, @Param("start")int start, @Param("count")int count);

	DispatchInfo quaryDispatchInfoById(Integer id);
	
	void modifyDispatchInfoById(Integer id);
	
	void finishDispatchInfoById(Integer id);
	
	void addDispatchInfo(DispatchInfo dispatchInfo);
}
