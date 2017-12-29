package cn.et.lesson03.entity;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class UserInfo {
/**
 * NotNull @NotEmpty
 * NotEmpty @NotEmpty && ��������.equals��""��
 */
	@NotEmpty(message="�û�������Ϊ�գ�")
	private String userName;
	@NotEmpty(message="���벻��Ϊ�գ�")
	private String password;
	@NotEmpty(message="�ٴ��������벻��Ϊ�գ�")
	private String regPassword;
	@Size(min=11,max=11,message="�ֻ��������Ϊʮһλ��")
	private String phone;
	@Pattern(message="�����ʽ����",regexp=".+@.+\\..+")
	private String email;
	@NotEmpty(message="���ڲ���Ϊ�գ�")
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
