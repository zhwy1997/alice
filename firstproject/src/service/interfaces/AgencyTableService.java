package service.interfaces;

import com.mybatis.po.AgencyTable;
import com.mybatis.po.DealTable;
import com.mybatis.pojo.AgencyTableParam;

import java.util.*;

public interface AgencyTableService {
	/** 添加一条新成交记录
	 *  如果该城市&种类&日期 存在记录则更新
	 */
	
	public AgencyTable addAgencyTable (DealTable dealTable);
	
	
	
	/**
	 * @return 所有中介信息
	 */
	public List <AgencyTable> allinfo();
	
	
	/** 某段时间所有中介信息
	 * 
	 */
	public List <AgencyTable> AgencyTableByDay(AgencyTableParam param);
}
