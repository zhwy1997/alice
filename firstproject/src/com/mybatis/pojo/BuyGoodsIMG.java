package com.mybatis.pojo;

import org.springframework.web.multipart.MultipartFile;

public class BuyGoodsIMG {
	private MultipartFile goodIMG;
	private Integer gid;
	private Integer belongUsr; 
	private String 	goodType;
	private String 	goodName;
	private Double	minPrice;
	private Double maxPrice; 
	private String 	goodDescription;
	public Integer getGid() {
		return gid;
	}
	public void setGid(Integer gid) {
		this.gid = gid;
	}
	public MultipartFile getGoodIMG() {
		return goodIMG;
	}
	public String getGoodType() {
		return goodType;
	}
	public String getGoodName() {
		return goodName;
	}
	public Double getMinPrice() {
		return minPrice;
	}
	public Double getMaxPrice() {
		return maxPrice;
	}
	public String getGoodDescription() {
		return goodDescription;
	}
	public void setGoodIMG(MultipartFile goodIMG) {
		this.goodIMG = goodIMG;
	}
	public void setGoodType(String goodType) {
		this.goodType = goodType;
	}
	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}
	public void setMinPrice(Double minPrice) {
		this.minPrice = minPrice;
	}
	public void setMaxPrice(Double maxPrice) {
		this.maxPrice = maxPrice;
	}
	public void setGoodDescription(String goodDescription) {
		this.goodDescription = goodDescription;
	}
	public Integer getBelongUsr() {
		return belongUsr;
	}
	public void setBelongUsr(Integer belongUsr) {
		this.belongUsr = belongUsr;
	}
}
