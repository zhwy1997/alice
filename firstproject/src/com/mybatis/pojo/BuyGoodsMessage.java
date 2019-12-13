package com.mybatis.pojo;

import java.util.List;

/**
 * @author zhwy
 * 用于返回json的货物信息;
 */
import com.fasterxml.jackson.annotation.JsonInclude;
import com.mybatis.po.BuyGoods;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BuyGoodsMessage {

		private BuyGoods buyGoods;
		private List<BuyGoods> buyGoodsList;
		
		/**
		 * 错误信息
		 */
		private String message;
		
		/**
		 * 错误编码 
		 * 首位 0 查询失败
		 *    1 查询成功
		 */
		private String messageCode;

		public BuyGoods getBuyGoods() {
			return buyGoods;
		}

		public List<BuyGoods> getBuyGoodsList() {
			return buyGoodsList;
		}

		public String getMessage() {
			return message;
		}

		public String getMessageCode() {
			return messageCode;
		}

		public void setBuyGoods(BuyGoods buyGoods) {
			this.buyGoods = buyGoods;
		}

		public void setBuyGoodsList(List<BuyGoods> buyGoodsList) {
			this.buyGoodsList = buyGoodsList;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		public void setMessageCode(String messageCode) {
			this.messageCode = messageCode;
		}
}
