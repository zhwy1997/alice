package com.mybatis.pojo;

import com.mybatis.po.MyUsr;

public class UsrMessage {
	private MyUsr myUsr;
	/**
	 * ´íÎóĞÅÏ¢
	 */
	private String message;
	
	/**
	 * ´íÎó±àÂë 0Ê§°Ü 1³É¹¦
	 */
	private int messageCode;
	public String getMessage() {
		return message;
	}
	public int getMessageCode() {
		return messageCode;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setMessageCode(int messageCode) {
		this.messageCode = messageCode;
	}
	
	public MyUsr getMyUsr() {
		return myUsr;
	}
	public void setMyUsr(MyUsr myUsr) {
		this.myUsr = myUsr;
	}
	@Override
	public String toString() {
		return "User [uid=" + myUsr.getUid() +",uname=" + myUsr.getuName() + "message" + message+"]";
	}
	
}
