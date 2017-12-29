package cn.et.lesson01.dao;

import java.util.List;
import java.util.Map;

public interface ClassDao {

	public Integer tableListCount(String foodname);
	
	public abstract List<Map<String, Object>> queryAll();

	public List<Map<String, Object>> queryContent(String foodname,int startIndex,int length);

	public abstract void saveClass(String title, String foodname,String path);

	public abstract void updateClass(String id, String foodname, String money,String path);

	public abstract void deleteClass(String id);
	
	public Map<String, Object> findid(String id);

}