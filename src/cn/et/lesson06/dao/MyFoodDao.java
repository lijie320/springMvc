package cn.et.lesson06.dao;

import java.util.List;
import java.util.Map;

public interface MyFoodDao {
	public List<Map<String, Object>> queryFood(String name);
	public void deleteFood(String id);
	public void saveFood(String foodname,String money);
	public void updateFood(String id,String foodname,String money);
}
