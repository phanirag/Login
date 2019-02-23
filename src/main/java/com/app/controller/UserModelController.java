package com.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.UserModel;
import com.app.service.IUserModelService;
import com.app.util.CoDecUtil;

@Controller
public class UserModelController {
	
	@Autowired
	private IUserModelService serivce;
	
	@Autowired
	private CoDecUtil codec;
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String init() {
		return "index";
	}
	
	@RequestMapping(value="/home",method=RequestMethod.GET)
	public String home() {
		return "UserLogin";
	}
	
	@RequestMapping(value="/userReg",method=RequestMethod.GET)
	public String userReg() {
		return "UserReg";
	}
	
	@RequestMapping(value="/addUser",method = RequestMethod.POST)
	public String addUser(@ModelAttribute UserModel userModel,ModelMap map) {
		String password = userModel.getAddress();
		String enCodedPass = codec.genetareEncode(password);
		userModel.setPassword(enCodedPass);
		int id = serivce.addUserModel(userModel);
		map.addAttribute("msg","Record has been inserted with Id :"+id +" and Password  "+userModel.getPassword());
		return "UserReg";
	}
	
	@RequestMapping(value="/login",method = RequestMethod.GET)
	public String login(@RequestParam("userName") String name,@RequestParam("password") String password,ModelMap map) {
		String page = null;
		try {
			String encoded = password;
			String deCodedPass = codec.genetareDecode(encoded);
			UserModel user = serivce.login(name,deCodedPass);
			if(user !=null) {
				map.addAttribute("userName",name);
				page = "helloPage";
			}else {
				map.addAttribute("msg","Please Enter Valid Details");
				page = "UserLogin";
			}
		}catch (Exception e) {
		e.printStackTrace();
		}
		return page;
	}
	
	@RequestMapping(value="/logout",method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		return "UserLogin";
	}
	
	
}
