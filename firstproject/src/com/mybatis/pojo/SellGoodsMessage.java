package com.mybatis.pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.mybatis.po.SellGoods;

/**
 * @author zhwy
 * 用于返回json的货物信息;
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SellGoodsMessage {
	private SellGoods sellGoods;
	private List<SellGoods> sellGoodsList;
	
	/**
	 * 错误信息
	 */
	private String message;
	
	/**
	 * 错误编码 
	 * 首位 0 查询失败
	 *    1 查询成功
	 */
	private String messageCode;

	public SellGoods getSellGoods() {
		return sellGoods;
	}

	public List<SellGoods> getSellGoodsList() {
		return sellGoodsList;
	}

	public String getMessage() {
		return message;
	}

	public String getMessageCode() {
		return messageCode;
	}

	public void setSellGoods(SellGoods sellGoods) {
		this.sellGoods = sellGoods;
	}

	public void setSellGoodsList(List<SellGoods> sellGoodsList) {
		this.sellGoodsList = sellGoodsList;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setMessageCode(String messageCode) {
		this.messageCode = messageCode;
	}
	
	@Override
	public String toString() {
		return "SellGoodsMsg:"+ message;
	}
	
}
