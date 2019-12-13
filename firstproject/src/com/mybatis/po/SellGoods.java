package com.mybatis.po;
import java.util.*;
/**
 *数据库中SellGood表的持久化类
 */

import com.fasterxml.jackson.annotation.JsonInclude;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class SellGoods {
	private Integer gid;
	private Integer belongUsr;
	private Integer buyUsr;
	private String 	goodType;
	private String 	goodName;
	private Double	minPrice;
	private Integer fixedPrice; 
	private Date 	endAuctionTime;
	private String 	goodDescription;
	private String goodIMG;
	private Date 	createTime;
	private Date 	modifyTime;
	private String 	sellState;
	public Integer getGid() {
		return gid;
	}
	public void setGid(Integer gid) {
		this.gid = gid;
	}
	public Integer getBelongUsr() {
		return belongUsr;
	}
	public void setBelongUsr(Integer belongUsr) {
		this.belongUsr = belongUsr;
	}
	public Integer getBuyUsr() {
		return buyUsr;
	}
	public void setBuyUsr(Integer buyUsr) {
		this.buyUsr = buyUsr;
	}
	public String getGoodType() {
		return goodType;
	}
	public void setGoodType(String goodType) {
		this.goodType = goodType;
	}
	public String getGoodName() {
		return goodName;
	}
	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}

	public Double getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(Double minPrice) {
		this.minPrice = minPrice;
	}

	public Integer getFixedPrice() {
		return fixedPrice;
	}
	public void setFixedPrice(Integer fixedPrice) {
		this.fixedPrice = fixedPrice;
	}
	public Date getEndAuctionTime() {
		return endAuctionTime;
	}
	public void setEndAuctionTime(Date endAuctionTime) {
		this.endAuctionTime = endAuctionTime;
	}
	public String getGoodDescription() {
		return goodDescription;
	}
	public void setGoodDescription(String goodDescription) {
		this.goodDescription = goodDescription;
	}
	public String getGoodIMG() {
		return goodIMG;
	}
	public void setGoodIMG(String goodIMG) {
		this.goodIMG = goodIMG;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getModifyTime() {
		return modifyTime;
	}
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
	public String getSellState() {
		return sellState;
	}
	public void setSellState(String sellState) {
		this.sellState = sellState;
	}
	@Override
	public String toString() {
		return "SellGoods [gid=" + gid +",goodName=" + goodName + ",belongto" + belongUsr +
				",goodtype" + goodType + "]";
	}

}
