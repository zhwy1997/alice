package com.mybatis.pojo;
import java.util.*;
/*
 * 记录起始年月日 、城市
 */
public class AgencyTableParam {
	private Date startDay;
	private Date endDay;
	private String city;
	public Date getStartDay() {
		return startDay;
	}
	public Date getEndDay() {
		return endDay;
	}
	public String getCity() {
		return city;
	}
	public void setStartDay(Date startDay) {
		this.startDay = startDay;
	}
	public void setEndDay(Date endDay) {
		this.endDay = endDay;
	}
	public void setCity(String city) {
		this.city = city;
	}

}
