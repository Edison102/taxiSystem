package com.sfu.web;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sfu.beans.User;
import com.sfu.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	@Qualifier("userService")
	private IUserService userService;
	
	@RequestMapping("/toLoginController")
	public String toLoginController(){
		return "login";
	}
	
	@RequestMapping("/loginController")
	public String loginController(User user,HttpSession session,Model model){
		User u=userService.selectUserByNameAndPwd(user);
		if(u==null){
			model.addAttribute("loginError", "用户名或密码错误");
			return "login";
		}
		session.setAttribute("user", u);
		return "main";
	}
	
	@RequestMapping("/toRegisterController")
	public String toRegisterController(){
		return "register";
	}
	
	@RequestMapping("registerController")
	public String registerController(User user,@Param("password2") String password2,Model model){
		if(!user.getPassword().equals(password2)){
			model.addAttribute("passwordError", "密码重复输入错误");
			return "register";
		}
		User u=userService.selectUserByName(user);
		if(u!=null){
			model.addAttribute("userNameError", "用户名已存在");
			return "register";
		}
		user.setIsAdmin(0);
		userService.insertUser(user);
		return "registerSuccess";
	}
	
	
	
	//---------------------------访问主体的四个页面------------------------------
			@RequestMapping(value="/topController")
			public String topController(){
				return "top";
			}
			
			@RequestMapping(value="/mainleftController")
			public String adminleftController(){
				return "mainleft";
			}
			
			@RequestMapping(value="/welcomeController")
			public String welcomeController(){
				return "welcome";
			}
			
			@RequestMapping(value="/footController")
			public String footController(){
				return "foot";
			}
}
