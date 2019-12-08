package com.mybatis.po;
import java.util.*;

import com.fasterxml.jackson.annotation.JsonInclude;
/**
 *数据库中MyUsr表的持久化类
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MyUsr {
	private Integer uid;//主键
	private String uAccount;
	private String password;
	private String uType;
	private String uName;
	private String phoneNumber;
	private String ulevel;
	private String city;
	private Date   regTime;
	private Date   modifyTime;

	public Integer getUid() {
		return uid;
	}
	public String getuAccount() {
		return uAccount;
	}
	public String getPassword() {
		return password;
	}
	public String getuType() {
		return uType;
	}
	public String getuName() {
		return uName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public String getUlevel() {
		return ulevel;
	}
	public String getCity() {
		return city;
	}
	public Date getRegTime() {
		return regTime;
	}
	public Date getModifyTime() {
		return modifyTime;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public void setuAccount(String uAccount) {
		this.uAccount = uAccount;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setuType(String uType) {
		this.uType = uType;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public void setUlevel(String ulevel) {
		this.ulevel = ulevel;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setRegTime(Date regTime) {
		this.regTime = regTime;
	}
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid +",uname=" + uName +"]";
	}
}