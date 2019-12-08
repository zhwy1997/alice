package com.mybatis.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.mybatis.po.MyUsr;
import java.util.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UsrMessage {
	private MyUsr myUsr;
	private List<MyUsr> usrList;
	/**
	 * 错误信息
	 */
	private String message;
	
	/**
	 * 错误编码 两位组成
	 * 首位 0 查询失败
	 *    1 查询成功
	  * 末位0: 0-无查询结果 1-密码错误 2-已存在 无法新增
	 *    1: 0 
	 */
	private String messageCode;
	public String getMessage() {
		return message;
	}
	public String getMessageCode() {
		return messageCode;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setMessageCode(String messageCode) {
		this.messageCode = messageCode;
	}
	
	public MyUsr getMyUsr() {
		return myUsr;
	}
	public void setMyUsr(MyUsr myUsr) {
		this.myUsr = myUsr;
	}

	public List<MyUsr> getUsrList() {
		return usrList;
	}
	public void setUsrList(List<MyUsr> usrList) {
		this.usrList = usrList;
	}
	@Override
	public String toString() {
		return "User [uid=" + myUsr.getUid() +",uname=" + myUsr.getuName() + "message" + message+"]";
	}
	
}
