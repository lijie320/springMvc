package cn.et.lesson05.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.et.lesson05.dao.MoneyDao;
import cn.et.lesson05.service.MoneyService;

@Service
public class MoneyServiceImpl implements MoneyService {

	@Autowired
	MoneyDao moneyDao;
	public int selectMoney() {
		int money = moneyDao.selectMoney();
		return money;
	}

	public void trasnateMoney(int money) {
		moneyDao.trasnateMoney(money);

	}

}
