package cn.et.lesson06.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.et.lesson06.dao.MyFoodDao;
import cn.et.lesson06.service.MyFoodService;

@Service
public class MyFoodServiceImpl implements MyFoodService {
	
	@Autowired
	MyFoodDao my;

	public List<Map<String, Object>> queryFood(String name) {

		return my.queryFood(name);
	}

	public void deleteFood(String id){
		my.deleteFood(id);
	}

	public void saveFood(String foodname, String money) {
		my.saveFood(foodname, money);
		
	}

	public void updateFood(String id, String foodname, String money) {
		my.updateFood(id, foodname, money);
		
	}
}
