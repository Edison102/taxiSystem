package com.sfu.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.sfu.util.Fields;
import com.sfu.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
	
	/*
	作废
	@RequestMapping("toDispatchInfoController")
	public String toDispatchInfoController(){
		return "dispatch/dispatch";
	}

	@RequestMapping("searchAllController")
	public String searchAllController(Model model,String cancel){
		if(cancel!=null) return "dispatch/dispatch";
		List<DispatchInfo> dispatchInfos=dispatchService.selectAllDispatchInfo();
		model.addAttribute("dispatchInfos", dispatchInfos);
		return "dispatch/dispatch";
	}

	@RequestMapping("noSearchController")
	public String noSearchController(Model model){
		model.addAttribute("dispatchInfos", null);
		return "dispatch/dispatch";
	}*/


	@RequestMapping("searchController")
	public String searchController(String dispatch,Model model){
		List<DispatchInfo> dispatchInfos=dispatchService.selectDispatchInfoByDis(dispatch);
		int total=dispatchInfos.size();
		PageUtil<DispatchInfo> Page=new PageUtil<DispatchInfo>(dispatchInfos,1,total,total);
		model.addAttribute("p", Page);
		return "dispatch/dispatch";
	}


	//分页查询
	@RequestMapping("searchByPageController")
	private String searchByPageController(Model model,Integer page){
		page=page==null?1:page;
		int total=dispatchService.selectAllNumbers();
		List<DispatchInfo> dataList=dispatchService.selectDispatchInfoByPage((page-1)* Fields.pageSize,Fields.pageSize);
		PageUtil<DispatchInfo> Page=new PageUtil<DispatchInfo>(dataList,page,Fields.pageSize,total);
		model.addAttribute("p", Page);
		return "dispatch/dispatch";
	}

	@RequestMapping("dispatchInfoMoreController")
	public String dispatchInfoMoreController(int id,Model model){
		DispatchInfo dispatchInfo=dispatchService.selectDispatchInfoById(id);
		Owner owner=ownerService.selectOwnerById(dispatchInfo.getUid());
		model.addAttribute("dispatchInfo", dispatchInfo);
		model.addAttribute("owner", owner);
		return "dispatch/dispatchMore";
	}
	
	@RequestMapping("finishController")
	public String finishController(int id,Model model){
		DispatchInfo dispatchInfo=dispatchService.selectDispatchInfoById(id);
		double payment=0;
		if(dispatchInfo.getNum_peo()>0){
			payment=dispatchInfo.getTotal_price()/dispatchInfo.getNum_peo();
		}
		dispatchService.finishAllDispatchInfo(id,payment);
		return "owner/owner";
	}
	
	@RequestMapping("aboardController")
	private String aboardController(HttpSession session,int id){
		User user=(User) session.getAttribute("user");
		DispatchInfo dispatchInfo=dispatchService.selectDispatchInfoById(id);
		if(dispatchInfo.getNum_peo()>=dispatchInfo.getMax_peo()||dispatchInfo.getIs_over()==1){
			return "aboardError";
		}
		boolean success=dispatchService.aboard(id,user.getUid());
		if(!success) return "aboardError";
		return "redirect:/orders/searchAllController";
	}
}
