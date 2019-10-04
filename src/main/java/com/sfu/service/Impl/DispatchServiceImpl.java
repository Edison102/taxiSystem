package com.sfu.service.Impl;

import java.util.List;

import com.sfu.beans.DispatchInfo;
import com.sfu.beans.Orders;
import com.sfu.dao.DispatchInfoDao;
import com.sfu.dao.OrdersDao;
import com.sfu.service.IDispatchInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service("dispatchInfoService")
@Transactional(isolation = Isolation.READ_COMMITTED)
public class DispatchServiceImpl implements IDispatchInfoService{

	@Autowired
	@Qualifier("dispatchInfoDao")
	private DispatchInfoDao dao;

	@Autowired
	@Qualifier("ordersDao")
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
	@Cacheable(value = "redisCacheManager",key="'redis_dispatchInfo_'+#id")
	public DispatchInfo selectDispatchInfoById(Integer id) {
		return dao.quaryDispatchInfoById(id);
	}

	@Override
	public int selectAllNumbers() {
		return dao.quaryAllNumbers();
	}

	@Override
	public List<DispatchInfo> selectDispatchInfoByPage(int start, int count) {
		return dao.quaryDispatchInfoByPage(start,count);
	}

	@Override
	public int selectNumbersByUid(Integer uid) {
		return dao.quaryNumbersByUid(uid);
	}

	@Override
	@Cacheable(value = "redisCacheManager")
	public List<DispatchInfo> selectDispatchInfoByPage(Integer uid, int start, int count) {
		return dao.quaryDispatchInfoByPageAndUid(uid,start,count);
	}

	@Override
	public List<DispatchInfo> selectDispatchInfoByUid(Integer uid) {
		return dao.quaryDispatchInfoByUid(uid);
	}

	@Override
	@CachePut(value = "redisCacheManager",key="'redis_dispatchInfo_'+#id")
	public void updateDispatchInfo(Integer id) {
		dao.modifyDispatchInfoById(id);
	}

	@Override
	public void finishDispatchInfo(Integer oid, double payment) {
		//dao.finishDispatchInfoById(did);
		ordersDao.modifyPayment(oid, payment);
	}

	@Override
	public void finishAllDispatchInfo(Integer id,double payment) {
		dao.finishDispatchInfoById(id);
		List<Orders> orders=ordersDao.quaryOrdersByDis(id);
		for(Orders order :orders){
			finishDispatchInfo(order.getId(), payment);
		}
	}


	@Override
	public void insertDispatchInfo(DispatchInfo dispatchInfo) {
		dao.addDispatchInfo(dispatchInfo);
	}

	@Override
	public boolean aboard(Integer id, Integer uid) {
		DispatchInfo dispatchInfo=dao.quaryDispatchInfoById(id);
		if(dispatchInfo.getNum_peo()>=dispatchInfo.getMax_peo()||dispatchInfo.getIs_over()==1){
			return false;
		}
		Orders order=new Orders();
		order.setUid(uid);
		order.setOrigin(dispatchInfo.getOrigin());
		order.setStart_time(dispatchInfo.getStart_time());
		order.setEnd_location(dispatchInfo.getEnd_location());
		order.setPayment(0);
		order.setIs_pay(0);
		order.setDispatchInfo(dispatchInfo);
		dao.modifyDispatchInfoById(id);
		ordersDao.addOrders(order);
		return true;
	}


}
