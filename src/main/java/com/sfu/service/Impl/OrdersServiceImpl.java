package com.sfu.service.Impl;

import java.util.List;


import com.sfu.beans.Orders;
import com.sfu.dao.EvaluationDao;
import com.sfu.dao.OrdersDao;
import com.sfu.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("ordersService")
public class OrdersServiceImpl implements IOrdersService {

	@Autowired
	@Qualifier("ordersDao")
	private OrdersDao dao;

	@Autowired
	@Qualifier("evaluationDao")
	private EvaluationDao evaluationDao;

	public void setDao(OrdersDao dao) {
		this.dao = dao;
	}


	public void setEvaluationDao(EvaluationDao evaluationDao) {
		this.evaluationDao = evaluationDao;
	}


	@Override
	public List<Orders> selectAllOrdersByUid(Integer uid) {
		return dao.quaryAllOrdersByUid(uid);
	}


	@Override
	public Orders selectOrdersById(Integer id) {
		return dao.quaryOrdersById(id);
	}


	@Override
	public void toPay(Integer oid, Integer uid, double score) {
		dao.toPay(oid);
		evaluationDao.modifyScoreByUid(uid, score);
	}


	@Override
	public void insertOrders(Orders order) {
		dao.addOrders(order);
	}


	@Override
	public List<Orders> selectOrdersByDis(Integer did) {
		return dao.quaryOrdersByDis(did);
	}

}
