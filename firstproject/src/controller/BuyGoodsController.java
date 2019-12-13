package controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mybatis.po.BuyGoods;
import com.mybatis.pojo.BuyGoodsIMG;
import com.mybatis.pojo.BuyGoodsMessage;
import com.mybatis.pojo.BuyGoodsParam;

import service.UpImgTools;
import service.interfaces.BuyGoodsService;

@Controller
@RequestMapping(value="/buyGoods")
public class BuyGoodsController {
	@Autowired
	private BuyGoodsService buyGoodsService;
	/*
	 * 商品详细信息
	 */
	@RequestMapping(value="/detail")
	public @ResponseBody BuyGoodsMessage detail(int gid) {	
		BuyGoods result = buyGoodsService.buyGoodsInfo(gid);
		BuyGoodsMessage response= new BuyGoodsMessage();
		if(result!=null) {
			response.setBuyGoods(result);
			response.setMessage("查询成功！");
			response.setMessageCode("1");
		} else {
			response.setBuyGoods(result);
			response.setMessage("查询失败！");
			response.setMessageCode("0");
			
		}
		return response;
	}
	
	
	/** 添加一个商品
	 * @param buyGoodsIMG
	 * @return 
	 * @throws IOException
	 */
	@RequestMapping(value="/addBuyGoods",method=RequestMethod.POST,produces= {"application/json;charset=utf-8"})	
	public @ResponseBody BuyGoodsMessage addBuyGoods (BuyGoodsIMG buyGoodsIMG) throws IOException {
		UpImgTools upImgTools =new UpImgTools();
		BuyGoods buyGoods = upImgTools.saveBuyGoods(buyGoodsIMG);
		BuyGoods result = buyGoodsService.addGoods(buyGoods);
		BuyGoodsMessage response= new BuyGoodsMessage();
		if(result!=null) {
			response.setBuyGoods(result);
			response.setMessage("添加成功！");
			response.setMessageCode("1");
		} else {
			response.setBuyGoods(result);
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
	@RequestMapping(value="/usrBuyGoods")
	public @ResponseBody BuyGoodsMessage usrBuyGoods(int uid) {
		System.out.println("查询用户全部求购");
		List<BuyGoods> result = buyGoodsService.usrBuyGoodsList(uid);
		BuyGoodsMessage response = new BuyGoodsMessage();
		if(result==null) {
			response.setBuyGoodsList(result);
			response.setMessage("无货物列表");
			response.setMessageCode("0");
		} else {
			response.setBuyGoodsList(result);
			response.setMessage("查询成功");
			response.setMessageCode("1");
		}
		return response;
	}
	
	/** 查询全部求购商品
	 * @return
	 */
	@RequestMapping(value="/all")
	public @ResponseBody BuyGoodsMessage all() {
		List<BuyGoods> result = buyGoodsService.allBuyGoodsList();
		BuyGoodsMessage response = new BuyGoodsMessage();
		if (result==null) {
			response.setBuyGoodsList(result);
			response.setMessage("无商品列表！");
			response.setMessageCode("00");
			
		} else {
			response.setBuyGoodsList(result);
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
	public @ResponseBody BuyGoodsMessage search(BuyGoodsParam param) {
		List<BuyGoods> result = buyGoodsService.search(param);
		BuyGoodsMessage response = new BuyGoodsMessage();
		if (result==null) {
			response.setBuyGoodsList(result);
			response.setMessage("无搜索结果！");
			response.setMessageCode("00");
			
		} else {
			response.setBuyGoodsList(result);
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
	public @ResponseBody BuyGoodsMessage modify (BuyGoodsIMG buyGoodsIMG) throws IOException {
		UpImgTools upImgTools =new UpImgTools();
		BuyGoods buyGoods = upImgTools.saveBuyGoods(buyGoodsIMG); //储存图片
		buyGoods.setGid(buyGoodsIMG.getGid());
		BuyGoods result = buyGoodsService.modifyInfo(buyGoods);
		BuyGoodsMessage response= new BuyGoodsMessage();
		if(result!=null) {
			response.setBuyGoods(result);
			response.setMessage("修改成功！");
			response.setMessageCode("1");
		} else {
			response.setBuyGoods(result);
			response.setMessage("修改失败！");
			response.setMessageCode("0");
		}
		System.out.println(response);
		return response;
	}
	
	@RequestMapping(value="/delete")
	public @ResponseBody BuyGoodsMessage delete(int gid)  {
		boolean result = buyGoodsService.deleteBuyGoods(gid);
		BuyGoodsMessage response= new BuyGoodsMessage();
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
