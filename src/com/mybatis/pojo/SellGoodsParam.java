package com.mybatis.pojo;

public class SellGoodsParam {
	private String 	good_Type = null;
	private String 	good_Name = "%";
	private Double	min_Price = 0.0;		//价格区间
	private Double	max_Price =  Double.MAX_VALUE;		//价格区间
	public String getGood_Type() {
		return good_Type;
	}
	public String getGood_Name() {
		return good_Name;
	}
	public Double getMin_Price() {
		return min_Price;
	}
	public Double getMax_Price() {
		return max_Price;
	}
	public void setGood_Type(String good_Type) {
		this.good_Type = good_Type;
	}
	public void setGood_Name(String good_Name) {
		this.good_Name = good_Name;
	}
	public void setMin_Price(Double min_Price) {
		this.min_Price = min_Price;
	}
	public void setMax_Price(Double max_Price) {
		this.max_Price = max_Price;
	}
}
