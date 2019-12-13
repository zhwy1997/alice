package service.interfaces;

import java.util.List;

import com.mybatis.po.SellGoods;
import com.mybatis.pojo.SellGoodsParam;

public interface SellGoodsService {
	/** 查看某个商品信息
	 * @param  商品标识 gid
	 * @return 商品信息
	 */
	public SellGoods sellGoodsInfo(int gid);
		
	/** 用户所有贩卖商品信息
	 * @param usrId 用户标识
	 * @return 商品列表
	 */
	public List<SellGoods> usrSellGoodsList(int usrId);

	/** 所有贩卖商品信息
	 * @return 所有商品信息
	 */
	public List<SellGoods> allSellGoodsList();
	
	/** 查找符合条件的商品
	 * @param param  种类、商品名(模糊)、最低、最高价格
	 * @return 商品信息列表
	 */
	public List<SellGoods> search(SellGoodsParam param);
	
	/** 添加一件商品
	 * @param sellGoods 添加的商品信息
	 * @return 成功添加后的商品信息
	 */
	public SellGoods addGoods(SellGoods sellGoods);
	
	/** 竞拍 修改竞拍状态 与新价格
	 * @param sellGoods 
	 * @return 返回修改后的结果
	 */
	public SellGoods Auction (SellGoods sellGoods);
	
	
	/** 竞拍结束 竞拍状态：已售
	 * @param sellGoods 修改竞拍状态
	 * @return 返回修改后的结果
	 */
	public SellGoods AuctionEnd(SellGoods sellGoods);
	
	/** 修改基本信息
	 * @param sellGoods 修改信息 包括要修改的ID
	 * @return 返回修改后的结果
	 */
	public SellGoods modifyInfo(SellGoods sellGoods);
	
	/** 删除一件商品
	 * @param gId
	 * @return 成功删除则为1
	 */
	public boolean deleteSellGoods(Integer gid);
	
	
} 
