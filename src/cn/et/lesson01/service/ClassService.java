package cn.et.lesson01.service;

import java.util.List;
import java.util.Map;

import cn.et.lesson01.utils.PageTools;

public interface ClassService {
	public List<Map<String, Object>> queryAll();
	
	public PageTools queryContent(String foodname,int curPage);
	
	 public void saveClass(String title,String content,String path);
	 
	 public void updateClass(String foodid,String foodname,String money,String path);
	 
	 public void deleteClass(String id);
	 
	 public Map<String, Object> findid(String id);
}
