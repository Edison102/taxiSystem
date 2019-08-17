package com.sfu.web;

import java.util.List;

import javax.servlet.http.HttpSession;

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
		return "owner/owner";
	}
	
	@RequestMapping("toApplyOwnerController")
	public String toApplyOwnerController(){
		return "owner/applyOwner";
	}
	
	
	@RequestMapping("searchDispatchInfoController")
	public String searchDispatchInfoController(HttpSession session,Model model){
		User user=(User) session.getAttribute("user");
		List<DispatchInfo> list=dispatchInfoService.selectDispatchInfoByUid(user.getUid());
		model.addAttribute("dispatchInfos", list);
		return "owner/owner";
	}
	
	@RequestMapping("noSearchDispatchInfoController")
	public String noSearchDispatchInfoController(Model model){
		model.addAttribute("dispatchInfos", null);
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
		return "owner/owner";
	}
	
}
