package service.interfaces;
import java.util.List;

import com.mybatis.po.DealTable;
import com.mybatis.po.SellGoods;
public interface DealTableService {
	/**创建新成交订单
	 * @param 成交商品
	 * @return 新成交订单
	 */
	public DealTable generateDeal(SellGoods sellGoods);

	/**
	 * @return 所有成交商品 
	 */
	public List <DealTable> allDealTable();

	/**
	 * @param 商品ID
	 * @return 某订单详细信息 
	 */
	public DealTable dealTableInfo(Integer gid);
	
	/** 用户购买订单
	 * @param usrid
	 * @return 订单列表
	 */
	public List <DealTable> usrBuyList(Integer usrid);

	/**用户贩售订单
	 * @param usrid
	 * @return
	 */
	public List <DealTable> usrSellList(Integer usrid);


}
