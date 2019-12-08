package com.mybatis.DAO;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.mybatis.po.SellGoods;
import com.mybatis.pojo.SellGoodsParam;;
@Repository
@Mapper
/*使用Spring自动扫描MyBatis的接口并装配
（Spring将指定包中所有被@Mapper注解标注的接口自动装配为MyBatis的映射接口*/
public interface SellGoodsDAO {
	public SellGoods selectSellGoodsByUsr(Integer belongUsr);
	public List<SellGoods>  selectAllSellGoods();
	public SellGoods selectSellGoodsByGid(Integer gid);
	public List<SellGoods> selectSellGoods(SellGoodsParam param);
	public int addSellGoods(SellGoods sellGoods);
	public int updateSellGoodsEnd(SellGoods sellGoods);
	public int updateSellGoodsOfState(SellGoods sellGoods);
	public int updateSellGoods(SellGoods sellGoods);
	public int deleteSellGoods(Integer gid);
	
}	
