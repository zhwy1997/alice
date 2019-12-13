package com.mybatis.DAO;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.mybatis.po.DealTable;
@Repository
@Mapper
/*使用Spring自动扫描MyBatis的接口并装配
（Spring将指定包中所有被@Mapper注解标注的接口自动装配为MyBatis的映射接口*/
public interface DealTableDAO {
	public List <DealTable> selectAllDealTable();
	public DealTable selectDealTableByGid(Integer gid);
	public int addDealTable(DealTable dealTable);
	public List <DealTable> selectDealTableByUsrSell(Integer sellUsr);
	public List <DealTable> selectDealTableByUsrBuy(Integer buyUsr);
	public int deleteDealTable(Integer gid);
}
