package cn.et.lesson03.entity;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class UserInfo {
/**
 * NotNull @NotEmpty
 * NotEmpty @NotEmpty && ！属性名.equals（""）
 */
	@NotEmpty(message="用户名不能为空！")
	private String userName;
	@NotEmpty(message="密码不能为空！")
	private String password;
	@NotEmpty(message="再次输入密码不能为空！")
	private String regPassword;
	@Size(min=11,max=11,message="手机号码必须为十一位！")
	private String phone;
	@Pattern(message="邮箱格式错误！",regexp=".+@.+\\..+")
	private String email;
	@NotEmpty(message="日期不能为空！")
	private String data;
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRegPassword() {
		return regPassword;
	}
	public void setRegPassword(String regPassword) {
		this.regPassword = regPassword;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
