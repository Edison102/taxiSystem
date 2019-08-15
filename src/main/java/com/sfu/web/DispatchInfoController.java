package com.sfu.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sfu.beans.DispatchInfo;
import com.sfu.beans.Orders;
import com.sfu.beans.Owner;
import com.sfu.beans.User;
import com.sfu.service.IDispatchInfoService;
import com.sfu.service.IOrdersService;
import com.sfu.service.IOwnerService;


@Controller
@RequestMapping("/dispatchInfo")
public class DispatchInfoController {
	
	@Autowired
	@Qualifier("dispatchInfoService")
	private IDispatchInfoService dispatchService;
	
	
	@Autowired
	@Qualifier("ownerService")
	private IOwnerService ownerService;
	
	@Autowired
	@Qualifier("ordersService")
	private IOrdersService ordersService;
	
	@RequestMapping("toDispatchInfoController")
	public String toDispatchInfoController(){
		return "dispatch";
	}
	
	
	@RequestMapping("searchController")
	public String searchController(String dispatch,Model model){
		List<DispatchInfo> dispatchInfos=dispatchService.selectDispatchInfoByDis(dispatch);
		model.addAttribute("dispatchInfos", dispatchInfos);
		return "dispatch";
	}
	
	
	@RequestMapping("searchAllController")
	public String searchAllController(Model model){
		List<DispatchInfo> dispatchInfos=dispatchService.selectAllDispatchInfo();
		model.addAttribute("dispatchInfos", dispatchInfos);
		return "dispatch";
	}
	
	
	@RequestMapping("noSearchController")
	public String noSearchController(Model model){
		model.addAttribute("dispatchInfos", null);
		return "dispatch";
	}
	
	@RequestMapping("dispatchInfoMoreController")
	public String dispatchInfoMoreController(int id,Model model){
		DispatchInfo dispatchInfo=dispatchService.selectDispatchInfoById(id);
		Owner owner=ownerService.selectOwnerById(dispatchInfo.getUid());
		model.addAttribute("dispatchInfo", dispatchInfo);
		model.addAttribute("owner", owner);
		return "dispatchMore";
	}
	
	@RequestMapping("finishController")
	public String finishController(int id,Model model){
		DispatchInfo dispatchInfo=dispatchService.selectDispatchInfoById(id);
		double payment=0;
		if(dispatchInfo.getNum_peo()>0){
			payment=dispatchInfo.getTotal_price()/dispatchInfo.getNum_peo();
		}
		List<Orders> orders=ordersService.selectOrdersByDis(id);
		for(Orders order :orders){
			dispatchService.finishDispatchInfo(id, order.getId(), payment);
		}
		return "owner";
	}
	
	@RequestMapping("aboardController")
	private String aboardController(HttpSession session,int id){
		User user=(User) session.getAttribute("user");
		DispatchInfo dispatchInfo=dispatchService.selectDispatchInfoById(id);
		if(dispatchInfo.getNum_peo()>=dispatchInfo.getMax_peo()||dispatchInfo.getIs_over()==1){
			return "aboardError";
		}
		synchronized (this) {
			if(dispatchInfo.getNum_peo()>=dispatchInfo.getMax_peo()||dispatchInfo.getIs_over()==1){
				return "aboardError";
			}
			Orders order=new Orders();
			order.setUid(user.getUid());
			order.setOrigin(dispatchInfo.getOrigin());
			order.setStart_time(dispatchInfo.getStart_time());
			order.setEnd_location(dispatchInfo.getEnd_location());
			order.setPayment(0);
			order.setIs_pay(0);
			order.setDispatchInfo(dispatchInfo);
			dispatchService.updateDispatchInfo(id);
			ordersService.insertOrders(order);
		}
		return "redirect:/orders/searchAllController";
	}
}
