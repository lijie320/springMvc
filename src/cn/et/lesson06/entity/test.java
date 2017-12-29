package cn.et.lesson06.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class test {

	/**
	 * @param args
	 */
	
	public static void parest(){
		Map map = new HashMap();
		map.put("id", 1);
		map.put("name", "zs");
		JSONObject jo = JSONObject.fromObject(map);
		System.out.println(jo.toString());
	}
	
	public static void parest1(){
		Map map = new HashMap();
		map.put("id", 1);
		map.put("name", "zs");
		
		Map address = new HashMap();
		
		address.put("city", "sz");
		address.put("stree", "gl");
		
		map.put("address", address);
		
		
		JSONObject array = JSONObject.fromObject(map);
		System.out.println(array.toString());
	}
	
	public static void main(String[] args) {
		parest1();
	}

}
