package com.sfu.service;

import java.util.List;

import com.sfu.beans.Orders;

public interface IOrdersService {
	List<Orders> selectAllOrdersByUid(Integer uid);
	List<Orders> selectOrdersByDis(Integer did);
	Orders selectOrdersById(Integer id);
	void toPay(Integer oid, Integer uid, double score);
	
	void insertOrders(Orders order);
}
