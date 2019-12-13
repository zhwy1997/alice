package service;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

import com.mybatis.po.BuyGoods;
import com.mybatis.po.SellGoods;
import com.mybatis.pojo.BuyGoodsIMG;
import com.mybatis.pojo.SellGoodsIMG;

/*
 * 上传图片的工具类
 */

public class UpImgTools {
	
	private static final String path = "D:\\jee-2019-09\\firstProject\\WebContent\\img";
	
	/**
	 * @param sellGoodsIMG 上传图片信息
	 * @return 返回存储的图片文件名
	 * @throws IOException 
	 */
	public String saveImg(MultipartFile img) throws IOException {
		if(!img.isEmpty()) {
			String fileName = System.currentTimeMillis() 
					+ String.valueOf((int)(1+Math.random()*(65535-1+1))) //随机数
					+img.getOriginalFilename();//时间戳+原始文件名
			FileUtils.copyInputStreamToFile(img.getInputStream(), new File(path,fileName));
			return fileName;
		}
		
		return null;
	}; 
	
	
	/** 将上传的参数保存到pojo层SellGoods类
	 * @param sellGoodsIMG
	 * @return sellgoods 
	 * @throws IOException 
	 */
	public SellGoods saveSellGoods(SellGoodsIMG sellGoodsIMG) throws IOException {
		SellGoods sellGoods = new SellGoods();
		sellGoods.setBelongUsr(sellGoodsIMG.getBelongUsr());
		sellGoods.setGoodName(sellGoodsIMG.getGoodName());
		sellGoods.setFixedPrice(sellGoodsIMG.getFixedPrice());
		sellGoods.setMinPrice(sellGoodsIMG.getMinPrice());
		sellGoods.setGoodType(sellGoodsIMG.getGoodType()); 
		sellGoods.setGoodDescription(sellGoodsIMG.getGoodDescription());
		sellGoods.setGoodIMG(this.saveImg(sellGoodsIMG.getGoodIMG()));
		return sellGoods;
	}
	
	/** 将上传的参数保存到pojo层BuyGoods类
	 * @param buyGoodsIMG
	 * @return BuyGoods
	 * @throws IOException 
	 */
	public BuyGoods saveBuyGoods(BuyGoodsIMG buyGoodsIMG) throws IOException {
		BuyGoods buyGoods = new BuyGoods();
		buyGoods.setBelongUsr(buyGoodsIMG.getBelongUsr());
		buyGoods.setGoodName(buyGoodsIMG.getGoodName());
		buyGoods.setMaxPrice(buyGoodsIMG.getMaxPrice());
		buyGoods.setMinPrice(buyGoodsIMG.getMinPrice());
		buyGoods.setGoodType(buyGoodsIMG.getGoodType()); 
		buyGoods.setGoodDescription(buyGoodsIMG.getGoodDescription());
		buyGoods.setGoodIMG(this.saveImg(buyGoodsIMG.getGoodIMG()));
		return buyGoods;
	}
	
	
	
}
