package com.mybatis.po;
import java.util.*;
/**
 *数据库中DealTable表的持久化类
 */
public class DealTable {
	private Integer gid;
	private Integer sellUsr;
	private Integer buyUsr;
	private Date dealTime;
	private Double dealPrice;
	private Double buyAgencyFee;
	private Double sellAgencyFee;
	
	public Integer getGid() {
		return gid;
	}
	public void setGid(Integer gid) {
		this.gid = gid;
	}
	public Integer getSellUsr() {
		return sellUsr;
	}
	public void setSellUsr(Integer sellUsr) {
		this.sellUsr = sellUsr;
	}
	public Integer getBuyUsr() {
		return buyUsr;
	}
	public void setBuyUsr(Integer buyUsr) {
		this.buyUsr = buyUsr;
	}
	public Date getDealTime() {
		return dealTime;
	}
	public void setDealTime(Date dealTime) {
		this.dealTime = dealTime;
	}
	public void setDealPrice(Double dealPrice) {
		this.dealPrice = dealPrice;
	}
	public void setBuyAgencyFee(Double buyAgencyFee) {
		this.buyAgencyFee = buyAgencyFee;
	}
	public void setSellAgencyFee(Double sellAgencyFee) {
		this.sellAgencyFee = sellAgencyFee;
	}
	public Double getDealPrice() {
		return dealPrice;
	}
	public Double getBuyAgencyFee() {
		return buyAgencyFee;
	}
	public Double getSellAgencyFee() {
		return sellAgencyFee;
	}
	@Override
	public String toString() {
		return "DealTable [gid=" + gid +",buyid=" + buyUsr + "sellid" + sellUsr +"]";
	}
}
