package controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mybatis.po.AgencyTable;
import com.mybatis.po.DealTable;
import com.mybatis.po.SellGoods;
import com.mybatis.pojo.SellGoodsIMG;
import com.mybatis.pojo.SellGoodsMessage;
import com.mybatis.pojo.SellGoodsParam;

import service.UpImgTools;
import service.interfaces.AgencyTableService;
import service.interfaces.DealTableService;
import service.interfaces.SellGoodsService;
import service.interfaces.UsrService;


@Controller
@RequestMapping(value="/sellGoods")
public class SellGoodsController {
	@Autowired
	private SellGoodsService sellGoodsService;
	@Autowired
	private DealTableService dealTableService;
	@Autowired
	private UsrService usrService;
	@Autowired
	private AgencyTableService agencyTableService;
	
	
	@RequestMapping(value="detail")
	public @ResponseBody SellGoodsMessage detail(int gid) {	
		SellGoods result = sellGoodsService.sellGoodsInfo(gid);
		SellGoodsMessage response= new SellGoodsMessage();
		if(result!=null) {
			response.setSellGoods(result);
			response.setMessage("查询成功！");
			response.setMessageCode("1");
		} else {
			response.setSellGoods(result);
			response.setMessage("查询失败！");
			response.setMessageCode("0");
			
		}
		return response;
	}
	
	
	/** 添加一个商品
	 * @param sellGoodsIMG
	 * @return 
	 * @throws IOException
	 */
	@RequestMapping(value="/addSellGoods",method=RequestMethod.POST,produces= {"application/json;charset=utf-8"})	
	public @ResponseBody SellGoodsMessage addSellGoods (SellGoodsIMG sellGoodsIMG) throws IOException {
		UpImgTools upImgTools =new UpImgTools();
		SellGoods sellGoods = upImgTools.saveSellGoods(sellGoodsIMG);
		SellGoods result = sellGoodsService.addGoods(sellGoods);
		SellGoodsMessage response= new SellGoodsMessage();
		if(result!=null) {
			response.setSellGoods(result);
			response.setMessage("添加成功！");
			response.setMessageCode("1");
		} else {
			response.setSellGoods(result);
			response.setMessage("添加失败！");
			response.setMessageCode("0");
			
		}
		System.out.println(response);
		return response;
	}
	
	
	/**查询一个用户下所有贩卖
	 * @param uid
	 * @return
	 */
	@RequestMapping(value="/usrSellGoods")
	public @ResponseBody SellGoodsMessage usrSellGoods(int uid) {
		System.out.println("查询用户全部贩卖");
		List<SellGoods> result = sellGoodsService.usrSellGoodsList(uid);
		SellGoodsMessage response = new SellGoodsMessage();
		if(result==null) {
			response.setSellGoodsList(result);
			response.setMessage("无货物列表");
			response.setMessageCode("0");
		} else {
			response.setSellGoodsList(result);
			response.setMessage("查询成功");
			response.setMessageCode("1");
		}
		return response;
	}
	
	/**竞拍
	 * @param uid
	 * @return
	 */
	@RequestMapping(value="/Auction") 

	public @ResponseBody SellGoodsMessage Auction(SellGoods sellGoods) {
		
		SellGoods result = sellGoodsService.Auction(sellGoods);
		SellGoodsMessage response = new SellGoodsMessage();
		if (result==null) {
			response.setSellGoods(result);
			response.setMessage("修改失败！");
			response.setMessageCode("0");
		} else {
			response.setSellGoods(result);
			response.setMessage("修改成功！");
			response.setMessageCode("1");
		}
		return response;
	}
	
	/**确认竞拍结束或者一口价 直接扣款 创建订单
	 * @param gid minPrice
	 * @return
	 */
	@RequestMapping(value="/AuctionEnd") //竞拍结束
	public @ResponseBody SellGoodsMessage AuctionEnd(SellGoods sellGoods) {
		SellGoods result = sellGoodsService.AuctionEnd(sellGoods); //修改商品价格与状态
		DealTable dealTable=dealTableService.generateDeal(result); //成交一笔订单
		AgencyTable agencyTable=agencyTableService.addAgencyTable(dealTable);
		SellGoodsMessage response = new SellGoodsMessage();
		if(result!=null && dealTable!=null &&agencyTable!=null) {
			//卖方收入
			usrService.recharge(dealTable.getSellUsr(),
					dealTable.getDealPrice(),
					dealTable.getSellAgencyFee());
			//买方扣费
			usrService.pay(dealTable.getBuyUsr(),
					dealTable.getDealPrice(),
					dealTable.getBuyAgencyFee());
			response.setSellGoods(result);
			response.setMessage("交易成功");
			response.setMessageCode("1");
		} else {
			response.setSellGoods(result);
			response.setMessage("交易失败");
			response.setMessageCode("0");
		}
		
		return response;
	}

	/** 查询全部贩卖商品
	 * @return
	 */
	@RequestMapping(value="/all")
	public @ResponseBody SellGoodsMessage all() {
		List<SellGoods> result = sellGoodsService.allSellGoodsList();
		SellGoodsMessage response = new SellGoodsMessage();
		if (result==null) {
			response.setSellGoodsList(result);
			response.setMessage("无商品列表！");
			response.setMessageCode("00");
			
		} else {
			response.setSellGoodsList(result);
			response.setMessage("查询成功！");
			response.setMessageCode("10");
		}
		return response;
		
	}
	
	/** 按条件索引
	 * @param param 查询参数
	 * @return
	 */
	@RequestMapping(value="/search")
	public @ResponseBody SellGoodsMessage search(SellGoodsParam param) {
		List<SellGoods> result = sellGoodsService.search(param);
		SellGoodsMessage response = new SellGoodsMessage();
		if (result==null) {
			response.setSellGoodsList(result);
			response.setMessage("无搜索结果！");
			response.setMessageCode("00");
			
		} else {
			response.setSellGoodsList(result);
			response.setMessage("查询成功！");
			response.setMessageCode("10");
		}
		return response;
	}
	
	/** 修改商品 与添加类似
	 * @param 
	 * @return
	 */
	@RequestMapping(value="/modify",method=RequestMethod.POST,produces= {"application/json;charset=utf-8"})
	public @ResponseBody SellGoodsMessage modify (SellGoodsIMG sellGoodsIMG) throws IOException {
		UpImgTools upImgTools =new UpImgTools();
		SellGoods sellGoods = upImgTools.saveSellGoods(sellGoodsIMG); //储存图片
		sellGoods.setGid(sellGoodsIMG.getGid());
		SellGoods result = sellGoodsService.modifyInfo(sellGoods);
		SellGoodsMessage response= new SellGoodsMessage();
		if(result!=null) {
			response.setSellGoods(result);
			response.setMessage("修改成功！");
			response.setMessageCode("1");
		} else {
			response.setSellGoods(result);
			response.setMessage("修改失败！");
			response.setMessageCode("0");
		}
		System.out.println(response);
		return response;
	}
	
	@RequestMapping(value="/delete")
	public @ResponseBody SellGoodsMessage delete(int gid)  {
		boolean result = sellGoodsService.deleteSellGoods(gid);
		SellGoodsMessage response= new SellGoodsMessage();
		if(result) {
			response.setMessage("删除成功！");
			response.setMessageCode("0");
		} else {
			response.setMessage("删除失败！");
			response.setMessageCode("0");
		}
		return response;
	}
}
