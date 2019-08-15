package com.sfu.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sfu.beans.Orders;
import com.sfu.beans.Owner;
import com.sfu.beans.User;
import com.sfu.service.IOrdersService;
import com.sfu.service.IOwnerService;

@Controller
@RequestMapping("orders")
public class OrdersController {
	
	@Autowired
	@Qualifier("ordersService")
	private IOrdersService ordersService;
	
	
	@Autowired
	@Qualifier("ownerService")
	private IOwnerService ownerService;
	
	@RequestMapping("searchAllController")
	private String searchAllController(HttpSession session,Model model){
		User user=(User)session.getAttribute("user");
		List<Orders> list=ordersService.selectAllOrdersByUid(user.getUid());
		model.addAttribute("orders", list);
		return "orders";
	}
	
	
	@RequestMapping("ordersMoreController")
	private String ordersMoreController(int id,Model model){
		Orders orders=ordersService.selectOrdersById(id);
		Owner owner=ownerService.selectOwnerById(orders.getDispatchInfo().getUid());
		model.addAttribute("orders", orders);
		model.addAttribute("owner", owner);
		return "ordersMore";
	}
	
	@RequestMapping("topayController")
	private String topayController(int oid,int uid,double score){
		ordersService.toPay(oid, uid, score);
		return "redirect:/orders/searchAllController";
	}
}
