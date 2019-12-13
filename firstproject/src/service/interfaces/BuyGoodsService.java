package service.interfaces;
import com.mybatis.po.BuyGoods;
import com.mybatis.pojo.BuyGoodsParam;

import java.util.List;
public interface BuyGoodsService {
		/** 查看某个商品信息
		 * @param  商品标识 gid
		 * @return 商品信息
		 */
		public BuyGoods buyGoodsInfo(int gid);
			
		/** 用户所有贩卖商品信息
		 * @param usrId 用户标识
		 * @return 商品列表
		 */
		public List<BuyGoods> usrBuyGoodsList(int usrId);

		/** 所有贩卖商品信息
		 * @return 所有商品信息
		 */
		public List<BuyGoods> allBuyGoodsList();
		
		/** 查找符合条件的商品
		 * @param param  种类、商品名(模糊)、最低、最高价格
		 * @return 商品信息列表
		 */
		public List<BuyGoods> search(BuyGoodsParam param);
		
		/** 添加一件商品
		 * @param buyGoods 添加的商品信息
		 * @return 成功添加后的商品信息
		 */
		public BuyGoods addGoods(BuyGoods buyGoods);
				
		/** 修改基本信息
		 * @param buyGoods 修改信息 包括要修改的ID
		 * @return 返回修改后的结果
		 */
		public BuyGoods modifyInfo(BuyGoods buyGoods);
		
		/** 竞拍结束 竞拍状态：已售
		 * @param gId
		 * @return 成功删除则为1
		 */
		public boolean deleteBuyGoods(Integer gid);
		

}
