package cn.et.lesson04.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Locale;


import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.et.lesson04.entity.UserInfo;


@Controller
public class ViewController {

	@RequestMapping(value="/r",method=RequestMethod.GET)
	public String queryClassBd(){
		
		return "lesson04/res";
	}
	@Autowired
	MessageSource ms;
	@RequestMapping(value="/nation",method=RequestMethod.GET)
	public String reg(HttpServletResponse response,OutputStream os,Locale locale) throws NoSuchMessageException, IOException{
		response.setContentType("text/html;charset=UTF-8");
		os.write(ms.getMessage("key", null, locale).getBytes("UTF-8"));
		return null;
	}
	
	@RequestMapping(value="/mid",method=RequestMethod.GET)
	public String mid() throws IOException{
		
		return "lesson04/reg";
	}
	
	@RequestMapping(value="/myreg",method=RequestMethod.POST)
	public String mid(@Valid UserInfo user,BindingResult result) throws IOException{
		if(result.hasErrors()){
			return "lesson04/reg";
		}
		return null;
	}
}
