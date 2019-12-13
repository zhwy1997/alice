package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mybatis.DAO.DealTableDAO;
import com.mybatis.po.DealTable;
import com.mybatis.po.SellGoods;

import service.interfaces.DealTableService;
@Service("dealTableService")
public class DealTableServiceImpl implements DealTableService {
	@Autowired
	private DealTableDAO dealTableDAO;
	
	@Override
	public DealTable generateDeal(SellGoods sellGoods) {
		// TODO Auto-generated method stub
		DealTable dealTable = new DealTable();
		dealTable.setGid(sellGoods.getGid());	//Éú³É¶©µ¥
		dealTable.setBuyUsr(sellGoods.getBuyUsr());
		dealTable.setSellUsr(sellGoods.getBelongUsr());
		dealTable.setDealPrice(sellGoods.getMinPrice());
		int flag = dealTableDAO.addDealTable(dealTable);
		if(flag!=0) {
			DealTable result=dealTableDAO.selectDealTableByGid(dealTable.getGid());
			return result;
		} else {
			return null;
		}
		
	}

	@Override
	public List<DealTable> allDealTable() {
		// TODO Auto-generated method stub
		List<DealTable> result = dealTableDAO.selectAllDealTable();
		return result;
	}

	@Override
	public DealTable dealTableInfo(Integer gid) {
		// TODO Auto-generated method stub
		DealTable result = dealTableDAO.selectDealTableByGid(gid);
		return result;
	}

	@Override
	public List<DealTable> usrBuyList(Integer usrid) {
		// TODO Auto-generated method stub
		List<DealTable> result = dealTableDAO.selectDealTableByUsrBuy(usrid);
		return result;
	}

	@Override
	public List<DealTable> usrSellList(Integer usrid) {
		// TODO Auto-generated method stub
		List<DealTable> result = dealTableDAO.selectDealTableByUsrSell(usrid);
		return result;
	}

}
