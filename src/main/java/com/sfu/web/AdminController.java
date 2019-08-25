package com.sfu.web;


import com.sfu.beans.Owner;
import com.sfu.service.IOwnerService;
import com.sfu.util.Fields;
import com.sfu.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    @Qualifier("ownerService")
    private IOwnerService ownerService;

    //分页查询
    @RequestMapping("searchPendingByPageController")
    private String searchByPageController(Model model, Integer page){
        page=page==null?1:page;
        int total=ownerService.selectPendingNumbers();
        List<Owner> dataList=ownerService.selectPendingOwnerByPage(Fields.getStart(page),Fields.pageSize);
        PageUtil<Owner> Page=new PageUtil<Owner>(dataList,page,Fields.pageSize,total);
        model.addAttribute("p", Page);
        return "admin/pending";
    }

    @RequestMapping("auditJudgmentController")
    public String auditJudgmentController(int pass,Integer uid){
        ownerService.judgeIsPassByUid(uid,pass);
        return "redirect:/admin/searchPendingByPageController";
    }


    //分页查询
    @RequestMapping("searchOwnerByPageController")
    private String searchOwnerByPageController(Model model, Integer page){
        page=page==null?1:page;
        int total=ownerService.selectOwnerNumbers();
        List<Owner> dataList=ownerService.selectOwnerByPage(Fields.getStart(page),Fields.pageSize);
        PageUtil<Owner> Page=new PageUtil<Owner>(dataList,page,Fields.pageSize,total);
        model.addAttribute("p", Page);
        return "admin/ownerInfo";
    }

    @RequestMapping("cancelController")
    public String cancelController(Integer uid){
        ownerService.cancelOwnerByUid(uid);
        return  "redirect:/admin/searchOwnerByPageController";
    }

}
