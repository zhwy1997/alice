package com.mybatis.DAO;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.mybatis.po.AgencyTable;
import com.mybatis.pojo.AgencyTableParam;
@Repository
@Mapper
/*使用Spring自动扫描MyBatis的接口并装配
（Spring将指定包中所有被@Mapper注解标注的接口自动装配为MyBatis的映射接口*/
public interface AgencyTableDAO {
	public List<AgencyTable> selectAllAgencyTable();
	public List<AgencyTable> selectAgencyTableByDay(AgencyTableParam param);
	public AgencyTable selectAgencyTableByPrimary(AgencyTable agencyTable);
	public int addAgencyTable(AgencyTable agencyTable);
	public int deleteAgencyTable(AgencyTable agencyTable);
}
