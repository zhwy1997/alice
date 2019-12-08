package com.mybatis.po;
import java.util.*;
/**
 *数据库中AgencyTable表的持久化类
 */
public class AgencyTable {
	private Date dealDay;
	private String city;
	private String goodType;
	private Integer amount;
	private Double income;
	public Date getDealDay() {
		return dealDay;
	}
	public void setDealDay(Date dealDay) {
		this.dealDay = dealDay;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getGoodType() {
		return goodType;
	}
	public void setGoodType(String goodType) {
		this.goodType = goodType;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public Double getIncome() {
		return income;
	}
	public void setIncome(Double income) {
		this.income = income;
	}
	@Override
	public String toString() {
		return "AgencyTale [day=" + dealDay +",city=" + city + ",goodType=" + goodType + ",amount=" + amount +",income=" + income + "]";
	}
	
}
