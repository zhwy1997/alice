package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mybatis.DAO.BuyGoodsDAO;
import com.mybatis.po.BuyGoods;

import com.mybatis.pojo.BuyGoodsParam;

import service.interfaces.BuyGoodsService;
@Service("buyGoodsService")
public class BuyGoodsServiceImpl implements BuyGoodsService {

	@Autowired
	private BuyGoodsDAO buyGoodsDAO;
	
	
	@Override
	public BuyGoods buyGoodsInfo(int gid) {
		// TODO Auto-generated method stub
		BuyGoods result = buyGoodsDAO.selectBuyGoodsByGid(gid);
		return result;
	}

	@Override
	public List<BuyGoods> usrBuyGoodsList(int usrId) {
		// TODO Auto-generated method stub
		List<BuyGoods> result = buyGoodsDAO.selectBuyGoodsByUsr(usrId);
		return result;
	}

	@Override
	public List<BuyGoods> allBuyGoodsList() {
		// TODO Auto-generated method stub
		List<BuyGoods> result = buyGoodsDAO.selectAllBuyGoods();
		return result;
	}

	@Override
	public List<BuyGoods> search(BuyGoodsParam param) {
		// TODO Auto-generated method stub
		List<BuyGoods> result = buyGoodsDAO.selectBuyGoods(param);
		return result;
	}

	@Override
	public BuyGoods addGoods(BuyGoods buyGoods) {
		// TODO Auto-generated method stub
		
		buyGoodsDAO.addBuyGoods(buyGoods);
		BuyGoods result = buyGoodsDAO.selectLatestBuyGoodsByUsr(buyGoods.getBelongUsr());
		return result;
	}

	
	


	@Override
	public BuyGoods modifyInfo(BuyGoods buyGoods) {
		// TODO Auto-generated method stub
		int flag = buyGoodsDAO.updateBuyGoods(buyGoods);
		if(flag==1) {
			BuyGoods result = buyGoodsDAO.selectBuyGoodsByGid(buyGoods.getGid());
			return result;
		} else {
			return null;
		}
		
	}

	@Override
	public boolean deleteBuyGoods(Integer gid) {
		// TODO Auto-generated method stub
		int result = buyGoodsDAO.deleteBuyGoods(gid);
		if (result>0)
			return true;
		else {
			return false;
		}
	}

}
