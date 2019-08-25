package com.sfu.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.sfu.beans.Orders;
import com.sfu.util.Fields;
import com.sfu.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sfu.beans.DispatchInfo;
import com.sfu.beans.Owner;
import com.sfu.beans.User;
import com.sfu.service.IDispatchInfoService;
import com.sfu.service.IOwnerService;


@Controller
@RequestMapping("/owner")
public class OwnerController {

	@Autowired
	@Qualifier("ownerService")
	private IOwnerService ownerService;
	
	
	@Autowired
	@Qualifier("dispatchInfoService")
	private IDispatchInfoService dispatchInfoService;
	
	@RequestMapping("toOwnerController")
	public String toOwnerController(HttpSession session){
		User user=(User) session.getAttribute("user");
		Owner owner=ownerService.selectOwnerById(user.getUid());
		session.setAttribute("owner", owner);
		return "redirect:/owner/searchByPageController";
	}
	
	@RequestMapping("toApplyOwnerController")
	public String toApplyOwnerController(){
		return "owner/applyOwner";
	}
	
	/*
	@RequestMapping("searchDispatchInfoController")
	public String searchDispatchInfoController(HttpSession session,Model model,String cancel){
		if(cancel!=null) return "owner/owner";
		User user=(User) session.getAttribute("user");
		List<DispatchInfo> list=dispatchInfoService.selectDispatchInfoByUid(user.getUid());
		model.addAttribute("dispatchInfos", list);
		return "owner/owner";
	}*/

	/*@RequestMapping("noSearchDispatchInfoController")
	public String noSearchDispatchInfoController(Model model){
		model.addAttribute("dispatchInfos", null);
		return "owner/owner";
	}*/

	@RequestMapping("searchByPageController")
	public String searchByPageController(HttpSession session,Model model,Integer page){
		page=page==null?1:page;
		User user=(User) session.getAttribute("user");
		int total=dispatchInfoService.selectNumbersByUid(user.getUid());
		List<DispatchInfo> dataList=dispatchInfoService.selectDispatchInfoByPage(user.getUid(),Fields.getStart(page), Fields.pageSize);
		PageUtil<DispatchInfo> Page=new PageUtil<DispatchInfo>(dataList,page,Fields.pageSize,total);
		model.addAttribute("p", Page);
		return "owner/owner";
	}


	@RequestMapping("toDepartController")
	public String toDepartController(){
		return "owner/depart";
	}
	
	@RequestMapping("departController")
	public String departController(DispatchInfo dispatchInfo,HttpSession session){
		User user=(User) session.getAttribute("user");
		dispatchInfo.setUid(user.getUid());
		dispatchInfo.setNum_peo(0);
		dispatchInfo.setIs_over(0);
		dispatchInfoService.insertDispatchInfo(dispatchInfo);
		return "redirect:/owner/searchByPageController";
	}

	/*
		申请车主功能
		使用到此功能表明用户还不是车主
		如果是初次申请，则将数据插入数据库
		否则更新数据库中的数据
	 */
	@RequestMapping("applyOwnerController")
	public String applyOwnerController(Owner owner,HttpSession session){
		User user=(User) session.getAttribute("user");
		owner.setUid(user.getUid());
		owner.setIs_audit(0);
		owner.setIs_pass(0);
		Owner owner1 = ownerService.selectOwnerById(user.getUid());
		if(owner1==null) ownerService.insertOwner(owner);
		else ownerService.updateOwner(owner);
		return "owner/waiting";
	}
	
}
