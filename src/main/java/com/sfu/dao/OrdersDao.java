package com.sfu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sfu.beans.Orders;

public interface OrdersDao {
	List<Orders> quaryAllOrdersByUid(Integer uid);
	List<Orders> quaryOrdersByDis(Integer did);
	
	Orders quaryOrdersById(Integer id);
	void toPay(Integer id);
	
	void addOrders(Orders order);
	
	void modifyPayment(@Param("id") Integer id, @Param("payment") double payment);
}
