package cn.et.lesson05.controller;

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
import cn.et.lesson05.service.MoneyService;


@Controller
public class InterController {

	@RequestMapping(value="/inter",method=RequestMethod.GET)
	public String inter(OutputStream os) throws IOException{
		os.write("hello".getBytes());
		return null;
	}
	
	@Autowired
	MoneyService mdi;
	@RequestMapping(value="/tm",method=RequestMethod.GET)
	public String inter(int money,OutputStream os) throws IOException{
		mdi.trasnateMoney(money);
		os.write(("ʣ�ࣺ"+mdi.selectMoney()).getBytes("UTF-8"));
		return null;
	}
	
}
