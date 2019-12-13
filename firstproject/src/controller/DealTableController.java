package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mybatis.po.DealTable;

import service.interfaces.DealTableService;

@Controller
@RequestMapping(value="/dealTable")
public class DealTableController {
	@Autowired
	private DealTableService dealTableService;
	
	//ÏêÏ¸Ò³
	@RequestMapping(value="/detail")
	public @ResponseBody DealTable detail(int gid){
		return dealTableService.dealTableInfo(gid);
	}
	//ËùÓÐÂô¶©µ¥
	@RequestMapping(value="/allSell")
	public @ResponseBody List<DealTable> allSell(int gid){
		return dealTableService.usrSellList(gid);
	}
	
	//ËùÓÐÂò¶©µ¥
	@RequestMapping(value="/allBuy")
	public @ResponseBody List<DealTable> allBuy(int gid){
		return dealTableService.usrBuyList(gid);
	}
}
