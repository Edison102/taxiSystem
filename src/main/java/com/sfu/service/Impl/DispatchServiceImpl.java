package com.sfu.service.Impl;

import java.util.List;

import com.sfu.beans.DispatchInfo;
import com.sfu.dao.DispatchInfoDao;
import com.sfu.dao.OrdersDao;
import com.sfu.service.IDispatchInfoService;

public class DispatchServiceImpl implements IDispatchInfoService{

	private DispatchInfoDao dao;
	private OrdersDao ordersDao;
	
	public void setDao(DispatchInfoDao dao) {
		this.dao = dao;
	}
	
	

	public void setOrdersDao(OrdersDao ordersDao) {
		this.ordersDao = ordersDao;
	}



	@Override
	public List<DispatchInfo> selectAllDispatchInfo() {
		return dao.quaryAllDispatchInfo();
	}

	@Override
	public List<DispatchInfo> selectDispatchInfoByDis(String dis) {
		return dao.quaryDispatchInfoByDis(dis);
	}

	@Override
	public DispatchInfo selectDispatchInfoById(Integer id) {
		return dao.quaryDispatchInfoById(id);
	}

	@Override
	public List<DispatchInfo> selectDispatchInfoByUid(Integer uid) {
		return dao.quaryDispatchInfoByUid(uid);
	}

	@Override
	public void updateDispatchInfo(Integer id) {
		dao.modifyDispatchInfoById(id);
	}

	@Override
	public void finishDispatchInfo(Integer did, Integer oid, double payment) {
		dao.finishDispatchInfoById(did);
		ordersDao.modifyPayment(oid, payment);
	}



	@Override
	public void insertDispatchInfo(DispatchInfo dispatchInfo) {
		dao.addDispatchInfo(dispatchInfo);
	}

}
