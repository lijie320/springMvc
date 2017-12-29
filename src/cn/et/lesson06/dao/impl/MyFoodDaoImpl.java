package cn.et.lesson06.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cn.et.lesson06.dao.MyFoodDao;

@Repository
public class MyFoodDaoImpl implements MyFoodDao{
	
	@Autowired
	JdbcTemplate jdbc;

	public List<Map<String, Object>> queryFood(String name) {
		return jdbc.queryForList("select * from food where foodname like '%"+name+"%'");
	}
	
	public void deleteFood(String id) {
		jdbc.execute("delete from food where foodid="+id);
	}

	public void saveFood(String foodname, String money) {
		jdbc.execute("insert into food(foodname,money)values('"+foodname+"','"+money+"')");
		
	}

	public void updateFood(String id,String foodname, String money) {
		jdbc.execute("update food set foodname='"+foodname+"',money='"+money+"' where foodid="+id);
		
	}

}
