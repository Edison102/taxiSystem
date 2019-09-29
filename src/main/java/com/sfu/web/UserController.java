package com.sfu.web;

import javax.servlet.http.HttpSession;

import com.sfu.util.VerifyFormat;
import org.apache.ibatis.annotations.Param;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sfu.beans.User;
import com.sfu.service.IUserService;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    @Qualifier("userService")
    private IUserService userService;


    @RequestMapping("/toLoginController")
    public String toLoginController() {
        return "user/login";
    }

    @RequestMapping("/loginController")
    public String loginController(User user, HttpSession session, Model model) {
        User u = userService.selectUserByNameAndPwd(user);
        if (u == null) {
            model.addAttribute("loginError", "用户名或密码错误");
            return "user/login";
        }
        session.setAttribute("user", u);
        return "main/main";
    }

    @RequestMapping("/toRegisterController")
    public String toRegisterController() {
        return "user/register";
    }

    @RequestMapping("/registerController")
    public String registerController(User user, @Param("password2") String password2, Model model) {
        if (!user.getPassword().equals(password2)) {
            model.addAttribute("passwordError", "密码重复输入错误");
            return "user/register";
        }
        else if(!VerifyFormat.verifyPhoneFormat(user.getPhone())){
            model.addAttribute("phoneError", "手机格式错误");
            return "user/register";
        }
        User u = userService.selectUserByName(user);
        if (u != null) {
            model.addAttribute("userNameError", "用户名已存在");
            return "user/register";
        }
        user.setIsAdmin(0);
        userService.insertUser(user);
        return "user/registerSuccess";
    }


    @RequestMapping("/verifyUserNameController")
    @ResponseBody
    public Map<String, Object> verifyUserNameController(User user) {
        Map<String, Object> data = new HashMap<>();
        /*User user = new User();
        user.setName(name);*/
        User u = userService.selectUserByName(user);
        if (u == null) {
            data.put("success", true);
            data.put("message", "用户名可以使用");
        } else {
            data.put("success", false);
            data.put("message", "用户名已被占用");
        }
        return data;
    }

    @RequestMapping("/verifyPasswordController")
    @ResponseBody
    public Map<String, Object> verifyPasswordController(String password,String password2) {
        Map<String, Object> data = new HashMap<>();
        if (password.equals(password2)) {
            data.put("success", true);
            data.put("message", "密码相同");
        } else {
            data.put("success", false);
            data.put("message", "两次输入密码不同");
        }
        return data;
    }

    @RequestMapping("/verifyPhoneFormatController")
    @ResponseBody
    public Map<String, Object> verifyPhoneFormatController(String phone) {
        Map<String, Object> data = new HashMap<>();
        if (VerifyFormat.verifyPhoneFormat(phone)) {
            data.put("success", true);
            data.put("message", "手机格式正确");
        } else {
            data.put("success", false);
            data.put("message", "手机格式错误");
        }
        return data;
    }


    //---------------------------访问主体的四个页面------------------------------
    @RequestMapping(value = "/topController")
    public String topController() {
        return "main/top";
    }

    @RequestMapping(value = "/mainleftController")
    public String adminleftController() {
        return "main/mainleft";
    }

    @RequestMapping(value = "/welcomeController")
    public String welcomeController() {
        return "main/welcome";
    }

    @RequestMapping(value = "/footController")
    public String footController() {
        return "main/foot";
    }
}
