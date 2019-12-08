package com.mybatis.DAO;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.mybatis.po.BuyGoods;
import com.mybatis.pojo.BuyGoodsParam;
@Repository
@Mapper
/*使用Spring自动扫描MyBatis的接口并装配
（Spring将指定包中所有被@Mapper注解标注的接口自动装配为MyBatis的映射接口*/
public interface BuyGoodsDAO {
	public BuyGoods selectBuyGoodsByUsr(Integer belongUsr);
	public List<BuyGoods>  selectAllBuyGoods();
	public BuyGoods selectBuyGoodsByGid(Integer gid);
	public List<BuyGoods> selectBuyGoods(BuyGoodsParam param);
	public int addBuyGoods(BuyGoods buyGoods);
	public int updateSellGoodsEnd(BuyGoods buyGoods);
	public int updateBuyGoods(BuyGoods buyGoods);
	public int deleteBuyGoodsd(BuyGoods buyGoods);
}
