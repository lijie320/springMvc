package cn.et.lesson01.dao.Impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cn.et.lesson01.dao.ClassDao;

@Repository
public class ClassDaoImpl implements ClassDao {
	@Autowired
	private JdbcTemplate jdbc;
	
	
	public Integer tableListCount(String foodname){
		 if(foodname==null){
			 foodname="";
	        }
		String sql = "select count(*) as count from food where foodname like '%"+foodname+"%'";
		List<Map<String, Object>> queryForList = jdbc.queryForList(sql);
		return Integer.parseInt(queryForList.get(0).get("count").toString());
	}
	/* (non-Javadoc)
	 * @see cn.et.lesson01.dao.Impl.ClassDao#queryAll()
	 */
	public List<Map<String, Object>> queryAll() {
		String sql = "select * from class";
		return jdbc.queryForList(sql);
	}

	/* (non-Javadoc)
	 * @see cn.et.lesson01.dao.Impl.ClassDao#queryContent(java.lang.String)
	 */
	public List<Map<String, Object>> queryContent(String foodname,int startIndex,int length) {
		String sql = "select * from food t  where t.foodname like '%"+foodname+"%' limit  "+startIndex+","+length;
		return jdbc.queryForList(sql);
	}

	/* (non-Javadoc)
	 * @see cn.et.lesson01.dao.Impl.ClassDao#saveClass(java.lang.String, java.lang.String)
	 */
	public void saveClass(String title, String content,String path) {
		String sql = "insert into food(foodname,money,imagepath)values('"+title+"','"+content+"','"+path+"')";
		jdbc.execute(sql);
	}

	/* (non-Javadoc)
	 * @see cn.et.lesson01.dao.Impl.ClassDao#updateClass(java.lang.String, java.lang.String, java.lang.String)
	 */
	public void updateClass(String id,String claname,String file,String path) {
		String sql = "update food set foodname='"+claname+"',money='"+file+"',imagepath='"+path+"' where foodid='"+id+"'";
		jdbc.update(sql);
	}
	/* (non-Javadoc)
	 * @see cn.et.lesson01.dao.Impl.ClassDao#deleteClass(java.lang.String)
	 */
	public void deleteClass(String id) {
		String sql = "delete from food where foodid='"+id+"'";
		jdbc.update(sql);
	}
	
	public Map<String, Object> findid(String id) {
		String sql = "select * from food where foodid='"+id+"'";
		List<Map<String, Object>> classList = jdbc.queryForList(sql);
		return classList.get(0);
	}
}
