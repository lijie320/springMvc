package cn.et.lesson06.entity;

public class UserInfo {
	String name="BeJson";
	String url="http://www.bejson.com";
	Address address;
	
	
	/**
	 * json格式
	 * {
		"name":"值",
		"url":"值",
		"address":[{
			"name":"值",
			"url":"值",
		},
		{
			"name":"值",
			"url":"值",
		}
		]
	}**/
}
