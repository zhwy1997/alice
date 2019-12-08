package com.mybatis.po;
/**
 *数据库中BuyGood表的持久化类
 */
import java.io.InputStream;
import java.util.Date;

public class BuyGoods {
	private Integer gid;
	private Integer belongUsr;
	private String 	goodType;
	private String 	goodName;
	private Double 	minPrice;
	private Double 	maxPrice; 
	private Date 	endAuctionTime;
	private String goodDescription;
	private Date 	createTime;
	private Date 	modifyTime;
	private String 	sellState;
	private InputStream goodIMG;
	public void setMinPrice(Double minPrice) {
		this.minPrice = minPrice;
	}
	public void setMaxPrice(Double maxPrice) {
		this.maxPrice = maxPrice;
	}
	public Double getMinPrice() {
		return minPrice;
	}
	public Double getMaxPrice() {
		return maxPrice;
	}
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
	public InputStream getGoodIMG() {
		return goodIMG;
	}
	public void setGoodIMG(InputStream goodIMG) {
		this.goodIMG = goodIMG;
	}
	@Override
	public String toString() {
		return "BuyGoods [gid=" + gid +",goodName=" + goodName + "belongto" + belongUsr +"]";
	}

	  

}
