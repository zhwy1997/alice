package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mybatis.po.AgencyTable;
import com.mybatis.pojo.AgencyTableParam;

import service.interfaces.AgencyTableService;

@Controller
@RequestMapping(value="/agencyTable")
public class AgencyTableController {
	@Autowired
	private AgencyTableService agencyTableService;
	
	
	@RequestMapping(value="/all",method=RequestMethod.POST)
	public 	@ResponseBody List <AgencyTable>  allinfo (@RequestBody AgencyTable agencyTable) {
		
		List <AgencyTable>  response = agencyTableService.allinfo();
		
		return response;
		
	}
	
	
	
	@RequestMapping(value="/condition",method=RequestMethod.POST)
	public 	@ResponseBody List <AgencyTable> agencyTableByDay  (@RequestBody AgencyTableParam param){
		List <AgencyTable>  response = agencyTableService.AgencyTableByDay(param);
		
		return response;
		
	}
	
}
