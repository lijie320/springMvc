package cn.et.lesson01.service.Impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.et.lesson01.dao.ClassDao;
import cn.et.lesson01.service.ClassService;
import cn.et.lesson01.utils.PageTools;

@Service
public class ClassServiceImpl implements ClassService {

	@Autowired
	private ClassDao classDao;
	public void deleteClass(String id) {
		classDao.deleteClass(id);
	}

	public List<Map<String, Object>> queryAll() {
		return classDao.queryAll();
	}

	public PageTools queryContent(String foodname,int curPage) {
		if(foodname == null){
			foodname = "";
		}
		int totalCount=classDao.tableListCount(foodname);
		PageTools pt=new PageTools(curPage,totalCount,2);
		List<Map<String, Object>> tableListPager = classDao.queryContent(foodname, pt.getStartIndex()-1, pt.getPageCount());
		pt.setData(tableListPager);
		return pt;
	}

	public void saveClass(String title, String content,String path) {
		classDao.saveClass(title, content,path);

	}

	public void updateClass(String id, String foodname, String money,String path) {
		classDao.updateClass(id, foodname, money,path);

	}

	public Map<String, Object> findid(String id) {
		// TODO Auto-generated method stub
		return classDao.findid(id);
	}

}
