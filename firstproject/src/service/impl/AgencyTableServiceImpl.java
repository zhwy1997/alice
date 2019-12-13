package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mybatis.DAO.AgencyTableDAO;
import com.mybatis.DAO.MyUsrDAO;
import com.mybatis.DAO.SellGoodsDAO;
import com.mybatis.po.AgencyTable;
import com.mybatis.po.DealTable;
import com.mybatis.po.MyUsr;
import com.mybatis.pojo.AgencyTableParam;

import service.interfaces.AgencyTableService;

@Service("agencyTableService")
public class AgencyTableServiceImpl implements AgencyTableService {

	@Autowired
	private AgencyTableDAO agencyTableDAO;
	@Autowired
	private MyUsrDAO myUsrDAO;
	@Autowired
	private SellGoodsDAO sellGoodsDAO;
	
	
	@Override
	public AgencyTable addAgencyTable(DealTable dealTable) {
		// TODO Auto-generated method stub
		MyUsr user =  myUsrDAO.selectUserByuid(dealTable.getSellUsr());	
		AgencyTable agencyTable = new AgencyTable();
		agencyTable.setCity(user.getCity());
		agencyTable.setDealDay(dealTable.getDealTime());
		agencyTable.setGoodType(sellGoodsDAO.selectSellGoodsByGid(dealTable.getGid()).getGoodType());   
		agencyTable.setIncome(dealTable.getDealPrice());
		
		agencyTableDAO.addAgencyTable(agencyTable);
		
		AgencyTable result = agencyTableDAO.selectAgencyTableByPrimary(agencyTable);
		
		return result;
	}

	@Override
	public List<AgencyTable> allinfo() {
		// TODO Auto-generated method stub
		List<AgencyTable> result = agencyTableDAO.selectAllAgencyTable();
		return result;
	}

	@Override
	public List<AgencyTable> AgencyTableByDay(AgencyTableParam param) {
		// TODO Auto-generated method stub
		List<AgencyTable> result = agencyTableDAO.selectAgencyTableByDay(param);
		return result;
	}

}
