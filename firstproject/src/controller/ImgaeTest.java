package controller;


import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.ResponseBody;


import com.mybatis.po.SellGoods;
import com.mybatis.pojo.SellGoodsIMG;

import service.UpImgTools;
@Controller
public class ImgaeTest {
	
	
	@RequestMapping(value="/testimg",method=RequestMethod.POST) 
	public @ResponseBody SellGoods test(SellGoodsIMG sellGoodsIMG) throws IOException {
		System.out.println("测试图片参数接受");
		
		UpImgTools upImgTools = new UpImgTools();
		String fileName = upImgTools.saveImg(sellGoodsIMG.getGoodIMG());
		System.out.println(fileName);
		System.out.println(sellGoodsIMG.getGoodName());
		SellGoods result = new SellGoods();
		result.setGid(1);
		return result;
	}
}
