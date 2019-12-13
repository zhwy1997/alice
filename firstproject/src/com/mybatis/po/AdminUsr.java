package com.mybatis.po;


import com.fasterxml.jackson.annotation.JsonInclude;
/**
 *数据库中adminUsr表的持久化类
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AdminUsr {
	private Integer uid;//主键
	private String uAccount;
	private String password;
	public Integer getUid() {
		return uid;
	}
	public String getuAccount() {
		return uAccount;
	}
	public String getPassword() {
		return password;
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
	@Override
	public String toString() {
		return "User [uid=" + uid +",uname=" + uAccount +"]";
	}
}
