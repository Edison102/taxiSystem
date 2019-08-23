package com.sfu.service;

import java.util.List;

import com.sfu.beans.Orders;
import org.apache.ibatis.annotations.Param;

public interface IOrdersService {
	List<Orders> selectAllOrdersByUid(Integer uid);
	List<Orders> selectOrdersByDis(Integer did);

	int selectNumbersBuUid(Integer uid);
	List<Orders> selectOrdersByPage(Integer uid, int start, int count);

	Orders selectOrdersById(Integer id);
	void toPay(Integer oid, Integer uid, double score);
	
	void insertOrders(Orders order);
}
