package cn.et.lesson06.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.et.lesson06.service.MyFoodService;

@Controller
public class MyFoodController {
	
	@Autowired
    MyFoodService my;
	//最原始的方式
	@RequestMapping(value="/myQueryFood",method={RequestMethod.GET,RequestMethod.POST})
	public String queryFood(String foodName,OutputStream os) throws IOException{
		List<Map<String, Object>> queryFood = my.queryFood(foodName);
		JSONArray array = JSONArray.fromObject(queryFood);
		String jsonStr = array.toString();
		os.write(jsonStr.getBytes("UTF-8"));
		return null;
	}
	
	@ResponseBody
	@RequestMapping(value="/queryFood",method={RequestMethod.GET,RequestMethod.POST})
	public byte[] queryFoodId(String foodName) throws IOException{
		List<Map<String, Object>> queryFood = my.queryFood(foodName);
		JSONArray array = JSONArray.fromObject(queryFood);
		String jsonStr = array.toString();
		return jsonStr.getBytes("UTF-8");
	}
	
	@RequestMapping(value="/deleteFood/{foodid}",method={RequestMethod.DELETE})
	public String deleFood(@PathVariable String foodid,OutputStream os) throws IOException{
		try {
			my.deleteFood(foodid);
			os.write("1".getBytes("UTF-8"));
		} catch (Exception e) {
			os.write("0".getBytes("UTF-8"));
		}
		return null;
	}

	@RequestMapping(value="/updateFood/{foodid}",method=RequestMethod.PUT)
	public String updateFood(@PathVariable String foodid,String foodname,String money,OutputStream os) throws IOException{
		try {
			my.updateFood(foodid, foodname, money);
			os.write("1".getBytes("UTF-8"));
		} catch (Exception e) {
			os.write("0".getBytes("UTF-8"));
		}
		return null;
	}
	
	@RequestMapping(value="/saveFood",method=RequestMethod.POST)
	public String saveFood(String foodname,String money,OutputStream os) throws IOException{
		try {
			my.saveFood(foodname, money);
			os.write("1".getBytes("UTF-8"));
		} catch (Exception e) {
			os.write("0".getBytes("UTF-8"));
		}
		return null;
	}
}
