package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mybatis.DAO.SellGoodsDAO;
import com.mybatis.po.SellGoods;
import com.mybatis.pojo.SellGoodsParam;

import service.interfaces.SellGoodsService;

@Service("sellGoodsService")
public class SellGoodsServiceImpl implements SellGoodsService {
	@Autowired
	private SellGoodsDAO sellGoodsDAO;
	
	
	@Override
	public SellGoods sellGoodsInfo(int gid) {
		// TODO Auto-generated method stub
		SellGoods result = sellGoodsDAO.selectSellGoodsByGid(gid);
		return result;
	}

	@Override
	public List<SellGoods> usrSellGoodsList(int usrId) {
		// TODO Auto-generated method stub
		List<SellGoods> result = sellGoodsDAO.selectSellGoodsByUsr(usrId);
		return result;
	}

	@Override
	public List<SellGoods> allSellGoodsList() {
		// TODO Auto-generated method stub
		List<SellGoods> result = sellGoodsDAO.selectAllSellGoods();
		return result;
	}

	@Override
	public List<SellGoods> search(SellGoodsParam param) {
		// TODO Auto-generated method stub
		List<SellGoods> result = sellGoodsDAO.selectSellGoods(param);
		return result;
	}

	@Override
	public SellGoods addGoods(SellGoods sellGoods) {
		// TODO Auto-generated method stub
		
		sellGoodsDAO.addSellGoods(sellGoods);
		SellGoods result = sellGoodsDAO.selectLatestSellGoodsByUsr(sellGoods.getBelongUsr());
		return result;
	}

	@Override
	public SellGoods Auction(SellGoods sellGoods) {
		// TODO Auto-generated method stub
		int flag = sellGoodsDAO.updateSellGoodsOfPrice(sellGoods);//修改价格
		if(flag==1) {
			SellGoods result = sellGoodsDAO.selectSellGoodsByGid(sellGoods.getGid());
			return result;
		} else {
			return null;
		}
	}

	@Override
	public SellGoods AuctionEnd(SellGoods sellGoods) {
		// TODO Auto-generated method stub
		int flag = sellGoodsDAO.updateSellGoodsEnd(sellGoods);//修改最后金额与成交日期
		if(flag==1) {
			SellGoods result = sellGoodsDAO.selectSellGoodsByGid(sellGoods.getGid());
			return result;
		} else {
			return null;
		}
	}


	@Override
	public SellGoods modifyInfo(SellGoods sellGoods) {
		// TODO Auto-generated method stub
		int flag = sellGoodsDAO.updateSellGoods(sellGoods);
		if(flag==1) {
			SellGoods result = sellGoodsDAO.selectSellGoodsByGid(sellGoods.getGid());
			return result;
		} else {
			return null;
		}
		
	}

	@Override
	public boolean deleteSellGoods(Integer gid) {
		// TODO Auto-generated method stub
		int result = sellGoodsDAO.deleteSellGoods(gid);
		if (result>0)
			return true;
		else {
			return false;
		}
	}

}
