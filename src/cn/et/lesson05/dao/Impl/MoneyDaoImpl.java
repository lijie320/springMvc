package cn.et.lesson05.dao.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cn.et.lesson05.dao.MoneyDao;

@Repository
public class MoneyDaoImpl implements MoneyDao {

	@Autowired
	JdbcTemplate jdbc;
	public void trasnateMoney(int money) {
		String sql = "Update class set money=money-"+money+" where id=1";
		jdbc.execute(sql);
	}
	
	public int selectMoney(){
		String sql = "select money from class where id =1";
		int money = jdbc.queryForObject(sql, int.class);
		return money;
	}

}
