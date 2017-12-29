package cn.et.lesson03.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.et.lesson03.entity.UserInfo;

@Controller
public class RegController {

	@RequestMapping(value="/reg",method=RequestMethod.POST)
	public String queryClassBd(@Valid UserInfo user,BindingResult error){
		if(!user.getPassword().equals(user.getRegPassword())){
			error.addError(new FieldError("user", "regPassword", "输入的密码不一致！"));
		}
		
		if(error.hasErrors()){
			return "/lesson03/reg.jsp";
		}
		return "/lesson03/test.jsp";
	}
}
